package top.yxy.boot.fi.service;

import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
    /**
     * 文件上传
     *
     * @param file 文件
     * @return 上传后的 url
     */
    String upload(MultipartFile file);

}
