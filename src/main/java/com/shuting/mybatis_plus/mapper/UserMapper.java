package com.shuting.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuting.mybatis_plus.pojo.User;
import org.springframework.stereotype.Repository;

//在对应的mapper上继承基本的类BaseMapper
@Repository //代表持久层
public interface UserMapper extends BaseMapper<User> {
    //所有CRUD操作已经编写完成
    //不需要配置一堆文件
}


