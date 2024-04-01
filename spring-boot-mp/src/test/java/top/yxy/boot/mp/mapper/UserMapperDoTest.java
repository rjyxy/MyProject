package top.yxy.boot.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.yxy.boot.mp.entity.UserDo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@SpringBootTest
@Slf4j
class UserMapperDoTest {
    @Autowired
    private UserDoMapper userdoMapper;

    /**
     * 增加一条记录
     */
    @Test
    void  insert() {
        UserDo userDo = new UserDo().setUsername("大杨").setPhone("138213355215").setGender("男");
        int rs = userdoMapper.insert(userDo);
        //成功拿到回写的userID
        System.out.println(userDo.getId());
    }

    @Test
    void delete() {
        // 根据id删除
         userdoMapper.deleteById(5);

        // 根据条件删除
        userdoMapper.delete(new LambdaQueryWrapper<UserDo>()
                .eq(UserDo::getUsername, "大杨"));
    }

    @Test
    void update() {
        // 1. 根据id更新
        userdoMapper.updateById(new UserDo()
                .setId(1)
                .setPhone("1234567890"));

        // 2. 根据条件更新
        userdoMapper.update(new UserDo().setUsername("大李"), new LambdaQueryWrapper<UserDo>()
                .eq(UserDo::getPhone, "1234567890"));
        //3.不创建项目
        userdoMapper.update(
                null,
                new LambdaUpdateWrapper<UserDo>()
                        .set(UserDo::getCreateTime, LocalDateTime.now())
                        .set(UserDo::getDeleted, 3)
                        .eq(UserDo::getUsername, "小王")
        );
    }

    @Test
    void select() {
//        UserDo userDo = userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getPhone, "10001"));

        List<UserDo> userdos = this.userdoMapper.selectList((Wrapper)null);
        System.out.println("********************");
        System.out.println(userdos);
//        userdoMapper.selectList(new LambdaQueryWrapper<UserDo>().like(UserDo::getUsername, "王"));

//        userMapper.selectList(new LambdaQueryWrapper<UserDO>());
    }

    @Test
    void orderBy() {
        userdoMapper.selectList(Wrappers.<UserDo>query().orderByAsc("create_time"));

//        userMapper.selectList(Wrappers.<UserDO>query().orderByAsc(Lists.newArrayList("create_time", "phone")));

//        userMapper.selectList(new LambdaQueryWrapper<UserDO>().orderByAsc(UserDO::getUsername).orderByDesc(UserDO::getCreateTime));
    }

    @Test
    public void groupBy() {
        QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
        wrapper.select("gender, count(*) as total").groupBy("gender");
        List<Map<String, Object>> mapList = userdoMapper.selectMaps(wrapper);
        System.out.println(mapList);
    }
    @Test
    public void testSelectMaxId() {
        QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
        wrapper.select(new String[] {"max(id) as id"});
        UserDo user = (UserDo)this.userdoMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void selectPage() {
        Page<UserDo> page = new Page<>(1, 2);
        Page<UserDo> userPage = userdoMapper.selectPage(page, null);
        System.out.println(userPage);
    }

}