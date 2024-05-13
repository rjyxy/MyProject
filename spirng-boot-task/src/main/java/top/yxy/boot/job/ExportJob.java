package top.yxy.boot.job;

import com.alibaba.excel.EasyExcel;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import top.yxy.boot.easyexcel.entity.Student;
import top.yxy.boot.mapper.StudentMapper;

import java.util.List;
import java.util.UUID;

@Slf4j
public class ExportJob extends QuartzJobBean {
    @Resource
    private StudentMapper studentMapper;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("执行导出任务");
        List<Student> list=studentMapper.selectList(null);
        String fileName="F:/report/"+ UUID.randomUUID()+".xlsx";
        EasyExcel.write(fileName,Student.class)
                .sheet("学生数据")
                .doWrite(()->{
                    //查询到的数据
                    return list;
                });
    }
}
