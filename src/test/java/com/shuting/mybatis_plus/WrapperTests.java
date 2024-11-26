package com.shuting.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuting.mybatis_plus.mapper.UserMapper;
import com.shuting.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .ge("age", 4);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    public void testWrapper2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .like("name", "T")
                .likeRight("email", "t");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void testWrapper3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("name");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
