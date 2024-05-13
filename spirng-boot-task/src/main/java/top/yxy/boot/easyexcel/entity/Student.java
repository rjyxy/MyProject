package top.yxy.boot.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Administrator
 */
@Data
@Accessors(chain = true)
@TableName("t_student")
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = -51545245L;

    @ExcelProperty("学号")
    private Integer studentId;

    @ExcelProperty("班级")
    private Integer clazzId;

    @ExcelProperty("姓名")
    private String studentName;

    @ExcelProperty("户籍")
    private String hometown;

    @ExcelProperty("出生年月")
    private LocalDate birthday;

}
