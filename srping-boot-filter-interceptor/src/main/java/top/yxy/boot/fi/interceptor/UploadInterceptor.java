package top.yxy.boot.fi.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.json.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.yxy.boot.fi.constant.Constant;
import top.yxy.boot.fi.enums.ErrorCode;
import top.yxy.boot.fi.exception.ServerException;
import top.yxy.boot.fi.utils.JwtUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Component
public class UploadInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入图片拦截器！！");
        String accessToken = JwtUtil.getAccessToken(request);
        if (StringUtils.isBlank(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        if (!JwtUtil.validate(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        // 取出JWT中的载荷：id和昵称
        JSONObject payload = JwtUtil.getPayload(accessToken);
        Object userId = payload.get(Constant.USER_ID);
        Object nickname = payload.get(Constant.NICKNAME);
        // 取出file
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
        if (file != null) {
            // 添加水印
            MultipartFile watermarkedFile = addWatermark(file, userId + ", " + nickname);
                    // 将加了水印的文件重新放入request中，传给接口
                    request.setAttribute("watermarkedFile", watermarkedFile);
        }
        return true;
    }
    private MultipartFile addWatermark(MultipartFile file, String text) throws IOException {
        String fileName = file.getOriginalFilename();
        if (StringUtils.isNotBlank(fileName)) {
            // uuid 前缀
            String prefix = UUID.randomUUID().toString().replace("-", "");
            // 文件后缀名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            // 创建临时文件
            File tempFile = File.createTempFile(prefix, suffix);
            // 获取图片大小，用来计算水印位置
            BufferedImage image = ImageIO.read(file.getInputStream());
            int width = image.getWidth();
            int height = image.getHeight();
            log.info("width:{},height:{}", width, height);
            // 复制到临时文件
            file.transferTo(tempFile);
            // 目标文件路径
            String filePath = Constant.TEMP_PATH + "/" + prefix + suffix;
            // 临时文件加指定内容和格式的水印，生成到目标文件
            ImgUtil.pressText(FileUtil.file(tempFile), FileUtil.file(filePath), text, Color.WHITE, new Font("黑体", Font.BOLD, 80), width / 3, height / 3, 1.0f);
            // 将带了水印的目标文件包装为 MockMultipartFile
            return new MockMultipartFile("file", fileName, "image/jpeg", Files.readAllBytes(Paths.get(filePath)));
        }
        throw new ServerException(ErrorCode.INTERNAL_SERVER_ERROR);
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = (String) request.getAttribute("url");
        log.info("url:{}", url);
        QrCodeUtil.generate(url, 300, 300, FileUtil.file(Constant.TEMP_PATH + "/" + UUID.randomUUID() + ".png"));
    }
}
