package top.yxy.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.yxy.boot.easyexcel.entity.Student;
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
