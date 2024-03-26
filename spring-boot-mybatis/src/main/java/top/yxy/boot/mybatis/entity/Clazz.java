package top.yxy.boot.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clazz {
    private Integer clazzId;

    private String clazzName;

    private Integer teacherId;
/**
 * Clazz.java 中声明 Teacher 对象：一对一
 * */
    private Teacher teacher;
/**
 * 一方(Clazz) 中声明多方(Student)的集合
 * */
    private List<Student> students;
}
