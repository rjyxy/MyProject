package top.yxy.boot.mybatis.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mqxu
 * @TableName t_teacher
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private Integer clazzId;
    /**
     * Teacher.java 中声明 Clazz 对象：一对一
     * */
    private Clazz clazz;
}
