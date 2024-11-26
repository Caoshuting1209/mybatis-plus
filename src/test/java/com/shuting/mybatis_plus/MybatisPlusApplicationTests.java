package com.shuting.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuting.mybatis_plus.mapper.UserMapper;
import com.shuting.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void textInsert(){
        User user = new User();
        user.setAge(38);
        user.setName("shuting");
        user.setEmail("shuting@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    public void textUpdate(){
        User user = userMapper.selectById(4);
        user.setAge(3);
        user.setName("yuqi");
        user.setEmail("yuqi@qq.com");
        int update = userMapper.updateById(user);
        System.out.println(user);
    }


    @Test
    //批量查询
    public void textSelect(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(4, 5));
        users.forEach(System.out::println);
    }

    @Test
    //条件查询
    public void textSelectByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","shuting");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void textPage(){
        //参数1:当前页；参数2:页面大小
        Page<User> page = new Page<>(1,6);
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());
    }

    @Test
    public void textDelete(){
        int delete = userMapper.deleteById(3);
    }

    @Test
    public void textDeleteByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","shuting");
        userMapper.deleteByMap(map);
    }

    @Test
    public void textDeleteBatch(){
        int delete = userMapper.deleteBatchIds(Arrays.asList(1,2));
    }
}
