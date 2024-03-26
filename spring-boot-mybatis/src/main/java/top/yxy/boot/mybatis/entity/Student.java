package top.yxy.boot.mybatis.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Integer studentId;

    private Integer clazzId;

    private String studentName;

    private String hometown;

    private LocalDate birthday;

    /**
     * 多方（Student）里声明一方（Clazz）的对象
     * */
    private Clazz clazz;

    private List<Course> courses;
}
