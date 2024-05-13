package top.yxy.boot.fi.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.yxy.boot.fi.service.CommonService;
import top.yxy.boot.fi.service.ImageService;
import java.util.UUID;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    @Resource
    private CommonService commonService;

    @Override
    public String uploadImage(MultipartFile file) {
        try{
            // 对上传的文件重命名
            String oldFileName = file.getOriginalFilename();
            assert oldFileName != null;
            int index = oldFileName.lastIndexOf(".");
            String suffixName = oldFileName.substring(index);
            String newFileName = UUID.randomUUID() + suffixName;
            return commonService.upload(file);
        } catch (Exception e){
            throw new RuntimeException("上传图片失败");
        }

    }

}
