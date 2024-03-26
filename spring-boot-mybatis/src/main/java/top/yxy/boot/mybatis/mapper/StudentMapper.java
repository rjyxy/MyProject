package top.yxy.boot.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import top.yxy.boot.mybatis.entity.Student;

import java.util.List;

/**
 * @author Administrator
 */
public interface StudentMapper {
    /**
     *
     * @param student
     * return
     */

    int insert(Student student);
    /**
     *
     * @param studentId
     * return
     */
    Student findStudentById(int studentId);
    /**
     *
     * @param student
     * return
     */
    int updateById(Student student);
    /**
     *
     * @param studentId
     * return
     */
    int deleteById(int studentId);
    /**
     *
     * @param students
     * return
     */
    int batchInsert(@Param("students") List<Student> students);
    /**
     *
     * @param ids
     * return
     */
    int batchDelete(@Param("idList") List<Integer> ids);
    /**
     *
     * @param students
     * return
     */
    int batchUpdate(@Param("students") List<Student> students);
    /**
     *
     * @param student
     * return
     */
    List<Student> selectByDynamicSql(Student student);

    /**一对多
     * 根据学生id查询（关联查询所属班级信息）
     *
     * @param studentId 学生id
     * @return 学生信息
     */
    Student getStudentManyToOne(int studentId);

    /**
     * 根据学生id查询（关联查询出所属班级信息，所选课程信息）
     *
     * @param studentId 学生id
     * @return 学生对象
     */
    Student getStudent(int studentId);
}

