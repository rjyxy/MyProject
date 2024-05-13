package top.yxy.boot.fi.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.yxy.boot.fi.config.OssConfig;
import top.yxy.boot.fi.exception.ServerException;
import top.yxy.boot.fi.service.CommonService;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class CommonServiceImpl implements CommonService {
    private final OssConfig ossConfig;
    // 允许上传文件图片格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg"
            , ".jpeg", ".gif", ".png"};
    @Override
    public String upload(MultipartFile file) {
        String returnImgUrl;
        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(),type)) {
                isLegal = true;
                break;
            }
        }
        if (!isLegal) {
            // 如果图⽚格式不合法
            throw new ServerException("图片格式不正确");
        }
        // 获取⽂件原名称
        String originalFilename = file.getOriginalFilename();
        // 获取⽂件类型
        assert originalFilename != null;
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 新⽂件名称
        String newFileName = UUID.randomUUID().toString().replace("-", "")
                + fileType;
        // 构建⽇期路径, 例如：OSS⽬标⽂件夹/2024/04/31/⽂件名
        String filePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        // ⽂件上传的路径地址
        String uploadUrl = filePath + "/" + newFileName;
        // 获取⽂件输⼊流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * 现在阿⾥云OSS 默认图⽚上传ContentType是image/jpeg
         * 也就是说，获取图⽚链接后，图⽚是下载链接，⽽并⾮在线浏览链接，
         * 因此，这⾥在上传的时候要解决ContentType的问题，将其改为image/jpg
         */
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType("image/jpg");
        //读取配置⽂件中的属性
        String endpoint = ossConfig.getEndpoint();
        String accessKeyId = ossConfig.getAccessKeyId();
        String accessKeySecret = ossConfig.getAccessKeySecret();
        String bucketName = ossConfig.getBucketName();
        // 创建 OssClient
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // ⽂件上传⾄阿⾥云 OSS
        ossClient.putObject(bucketName, uploadUrl, inputStream, meta);
        // 获取⽂件上传后的图⽚返回地址
        returnImgUrl = "https://" + bucketName + "." + endpoint + "/" + uploadUrl;
        return returnImgUrl;
    }
}

