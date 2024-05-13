package top.yxy.boot.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.yxy.boot.job.ExportJob;

@Configuration
public class QuartzExportConfig {
    @Bean
    public JobDetail exportTaskDetail() {
        return JobBuilder.newJob(ExportJob.class)
                .withIdentity("ExportJob")
                .storeDurably().build();
    }
    @Bean
    public Trigger exportTaskTrigger() {
        //10秒执行一次
        CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule("*/10 * * * * ?");
//返回任务触发器
 return TriggerBuilder.newTrigger().forJob(exportTaskDetail())
         .withIdentity("ExportJob")
         .withSchedule(scheduleBuilder)
         .build();
    }
}
