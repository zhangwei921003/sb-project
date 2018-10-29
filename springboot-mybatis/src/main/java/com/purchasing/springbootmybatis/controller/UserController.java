package com.purchasing.springbootmybatis.controller;

import com.purchasing.springbootmybatis.annotation.entity.User;
import com.purchasing.springbootmybatis.annotation.mapper.UserMapper;
import com.purchasing.springbootmybatis.generator.entity.TMember;
import com.purchasing.springbootmybatis.generator.entity.TUser;
import com.purchasing.springbootmybatis.generator.mapper.TMemberMapper;
import com.purchasing.springbootmybatis.generator.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangwei
 * @createTime 2018/10/29
 */
@RestController
public class UserController {

   @Autowired
   private UserMapper mapper;

   @Autowired
   private TMemberMapper memberMapper;

    @RequestMapping(value = "user/list")
    public User list(){
        return mapper.selectUserById(1);
    }

    @RequestMapping(value = "user/member")
    public TMember memberList(){
        return memberMapper.selectByPrimaryKey(28);
    }
}
