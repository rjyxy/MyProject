package top.yxy.boot.job;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yxy.boot.service.MailService;

@Component
@Slf4j
public class ScheduledJobs {
    @Resource
    private MailService mailService;
    @Autowired
    private HttpServletResponse httpServletResponse;

//    //表示方法执行完成后5秒再开始执行
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob() throws InterruptedException {
//        log.info("fixedDelayJob start:{}", new Date());
//        Thread.sleep(10 * 1000);
//        log.info("fixedDelayJob stop:{}", new Date());
//    }
//
//    //表示每隔3秒
//    @Scheduled(fixedRate = 3000)
//    public void fixedRateJob() throws InterruptedException {
//        log.info("fixedRateJob start:{}", new Date());
//        Thread.sleep(5 * 1000);
//        log.info("fixedRateJob stop:{}", new Date());
//    }
//
//    //表示每隔10秒执行一次
//    @Scheduled(cron = "0/10 * * * * ? ")
//    public void cronJob() {
//        log.info("=========================== ...>>cron....{}", new Date());
//    }

//    //每年的指定时间给指定邮箱发送一封 HTML 邮件
//    @Scheduled(cron = "0 12 7 4 * ?")
//    public void sendEmail() throws MessagingException {
//        String content = """
//                        <body>
//                        <h2 style="color:blue">测试邮件</h2>
//                        <img src="https://spring-boot-learning.oss-cn-beijing.aliyuncs.com/2024/05/06/409b7bf8e7db4de497d33f00963bb72d.jpg"width="150" height="150"/>
//                        <a href="https://www.baidu.com">百度网页</a>
//                        </body>
//                        """;
//        mailService.sendHtmlMail("29177555602@qq.com","生活愉快!",content);
//    }
//    @Scheduled(fixedRate = 5000)
//    public void generateQRCode() throws MessagingException {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
////         格式化事件
////        String time = LocalDateTime.now().format(dateTimeFormatter);
////        try {
////            // 生成二维码对象
////            QRCodeWriter qrCodeWriter = new QRCodeWriter();
////            // 把时间字符串转化为二维码
////            BitMatrix bitMatrix = qrCodeWriter.encode(time, BarcodeFormat.QR_CODE, 200, 200);
////            // 指定二维码图片保存路径
////            Path path = new File("F:\\F\\pictures" + System.currentTimeMillis() + ".png").toPath();
////            // 将二维码转换为图片并保存
////            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
////            System.out.println("时间 " + time);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        String content = dateTimeFormatter.format(LocalDateTime.now());
//        String uuid = UUID.randomUUID().toString();
//        QrCodeUtil.generate(content,200,200, FileUtil.file("F:\\F\\pictures"+uuid
//        +".png"));
//    }

    /**
     * 每年的5月6号21:53分发送邮件*/
//    @Scheduled(cron = "0 53 21 6 5 *")
//    public void happyCronJob() throws MessagingException {
//        String content = """
//                <body>
//                    <div>发送给许老师的邮件</div>
//                    <h2>祝您身体健康</h2>
//                    <img src="https://spring-boot-learning.oss-cn-beijing.aliyuncs.com/2024/05/06/409b7bf8e7db4de497d33f00963bb72d.jpg" alt="">
//                </body>
//                """;
//        try {
//            mailService.sendHtmlMail("16422802@qq.com","生活愉快",content);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        log.info("邮件发送成功");
//    }
}
