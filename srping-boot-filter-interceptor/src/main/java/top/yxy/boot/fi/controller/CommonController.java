package top.yxy.boot.fi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.yxy.boot.fi.result.Result;
import top.yxy.boot.fi.service.CommonService;

@Tag(name = "基础服务")
@RestController
@RequestMapping("/common")
@AllArgsConstructor
public class CommonController {
    private final CommonService commonService;
    @PostMapping(value = "/upload/img")
    @Operation(summary = "图片上传")
    public Result<String> upload(@RequestParam("file") MultipartFile file,
                                 HttpServletRequest request) {
        // 从请求属性中获取加了水印的文件
        MultipartFile watermarkedFile = (MultipartFile) request.getAttribute("watermarkedFile");
        String url = commonService.upload(watermarkedFile);
        // 将上传图片的 url 存入 request，方便在拦截器的后置处理中生成二维码
        request.setAttribute("url", url);
        return Result.ok(url);
    }
}
