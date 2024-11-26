package com.shuting.mybatis_plus;

import com.shuting.mybatis_plus.mapper.UserMapper;
import com.shuting.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        int insert;
        insert = userMapper.insert(user);
        System.out.println(user);
    }

}
