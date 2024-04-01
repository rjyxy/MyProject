package top.yxy.boot.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yxy.boot.mp.entity.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    /**
     * 增加一条记录*/
    @Test
    void insert() {
        User user = User.builder().name("Rose").age(19).email("rose@baomidou.com").build();
        int row = userMapper.insert(user);
        assertEquals(1,row);
        log.info("雪花算法id:"+user.getId());
    }

    /**
     * 根据主键删除一条记录*/
    @Test
    void deleteById() {
        int rows=userMapper.deleteById(1772478797484969985L);
        System.out.println("影响记录数："+rows);
    }

    /**
     * 根据条件删除记录*/
    @Test
    void deleteByCondition(){
        //构造条件
        Map<String,Object> map=new HashMap<>();
        map.put("name","Jack");map.put("age",20);
        //执行删除
        int rows=userMapper.deleteByMap(map);
        assertEquals(0,rows);
        System.out.println("影响记录数："+rows);
    }

    /**
     * 根据主键查询一条数据*/
    @Test
    void findById(){
        User user=userMapper.selectById(1L);
        System.out.println(user);
    }

    /**
     * 根据ids批量查找数据*/
    @Test
    void batchSearch() {
        List<Long> ids = Arrays.asList(3L,4L,5L);
        List<User> list = userMapper.selectBatchIds(ids);
        list.forEach(System.out::println);
    }

    /**
     * 根据指定参数查询*/
    @Test
    void findByParam(){
        Map<String,Object> map=new HashMap<>();
        //map的key指代的是mysql表中的列名，并非java实体的属性名
        map.put("name","Jone");
        List<User> list=userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    /**
     * 指定查询结果字段
     * 只查出name和age字段，年龄在指定范围，限定两条数据*/
    @Test
    void queryWrapper1(){
        QueryWrapper<User> query=new QueryWrapper<>();
        query.select("name","age")
        //指定查询结果字段
        .in("age",Arrays.asList(18,19,20)).last("limit 2");
        List<User> list=userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    /**
     * 指定查询结果字段
     * 只查出name和age 字段，根据姓名关键词模糊查询，年龄小于指定值*/
    @Test
    void queryWrapper2(){
        QueryWrapper<User> query=new QueryWrapper<>();
        query.like("name","J%")  //like是MP的条件构造器，表示"模糊查询"
        .lt("age",30)  //lt是MP的条件构造器，表示"小于"关系
        .select("name","age");
        List<Map<String,Object>> maps=userMapper.selectMaps(query);
        maps.forEach(System.out::println);
    }

    /**
     * 通过主键id修改数据*/
    @Test
    void updateById() {
        User user = new User();
        user.setId(1L);
        user.setAge(28);
        user.setEmail("mybatis-plus@163.com");
        int rows = userMapper.updateById(user);
        System.out.println("影响记录数："+rows);
    }

    /**
     * 根据UpdateWrapper 自定义条件修改数据*/
    @Test
    void updateWrapper() {
        UpdateWrapper<User> update = new UpdateWrapper<>();
        update.eq("name","Sandy").eq("age",21); //eq是MP的条件构造器，表示”等于"关系
        User user = new User();
        user.setAge(29);
        user.setEmail("Sandy@163.com");
        int rows = userMapper.update(user,update);
        System.out.println("影响记录数："+rows);
    }

    }