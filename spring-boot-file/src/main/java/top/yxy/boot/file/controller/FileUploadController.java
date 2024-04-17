package top.yxy.boot.file.controller;

import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.yxy.boot.file.utils.MinIoTemplate;
import top.yxy.boot.file.utils.OssTemplate;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
@Component
@RestController
@RequestMapping(value="/file")
public class FileUploadController {
    @Value("${file.upload-path}")
    private String uploadPath;

    @Value("${minio.endPoint}")
    private String endPoint;

    @Resource
    private OssTemplate ossTemplate;
    DateFormat df=new SimpleDateFormat("yyyyMMdd");

    @Resource
    private MinIoTemplate minioTemplate;

    @PostMapping("/native")
    public  String nativeUpload(MultipartFile file, HttpServletRequest request){
        if (file == null){
            throw new RuntimeException("文件不能为空");
        }
        String today=df.format(new Date());
        //创建上传子目录
        File folder= new File(uploadPath +"/" +today);
        if (!folder.exists()){
            boolean flag= folder.mkdirs();
            System.out.println(flag);
        }
        //对上传的文件重命名， bac.123.jpg> 121
        String oldFileName= file.getOriginalFilename();
        assert  oldFileName!=null;
        int index =oldFileName.lastIndexOf(".");
        String suffixName=oldFileName.substring(index);
        System.out.println(suffixName);
        String newFileName= UUID.randomUUID() + suffixName;
        System.out.println(newFileName);
        //
        try {
            file.transferTo(new File(folder,newFileName));
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
        //
        //
        return request.getScheme() +"://" + request.getServerName()+ ":" +request.getServerPort() +"/" +today +"/"+newFileName;

    }

    @PostMapping("/minio")
    public String minioUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {

        String today = df.format(new Date());
        // 对上传的文件重命名
        String oldFileName = file.getOriginalFilename();
        assert oldFileName != null;
        int index = oldFileName.lastIndexOf(".");
        String suffixName = oldFileName.substring(index);
        System.out.println(suffixName);
        String newFileName = UUID.randomUUID() + suffixName;


        ObjectWriteResponse owr;
        owr = minioTemplate.putObject("yxy", today + "/" + newFileName, file.getInputStream());
        System.out.println(owr.object());
        return endPoint + "/xyx/" + today + "/" + newFileName;
    }

    @PostMapping("/oss")
    public String ossUpload(MultipartFile file) {
        return ossTemplate.ossUpload(file);
    }
}
