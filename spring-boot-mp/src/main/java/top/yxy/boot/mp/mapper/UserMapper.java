package top.yxy.boot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.yxy.boot.mp.entity.User;

/**
 * @author Administrator
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
