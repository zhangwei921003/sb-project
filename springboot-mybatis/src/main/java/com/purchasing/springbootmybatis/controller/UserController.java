package com.purchasing.springbootmybatis.controller;

import com.purchasing.springbootmybatis.annotation.entity.User;
import com.purchasing.springbootmybatis.annotation.mapper.UserMapper;
import com.purchasing.springbootmybatis.generator.entity.TMember;
import com.purchasing.springbootmybatis.generator.entity.TUser;
import com.purchasing.springbootmybatis.generator.mapper.TMemberMapper;
import com.purchasing.springbootmybatis.generator.mapper.TUserMapper;
import com.purchasing.springbootmybatis.xml.entity.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
   private TUserMapper userMapper;

   @Autowired
   private TMemberMapper tMemberMapper;

   @Autowired
   private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping(value = "user/{id}")
    public User list(@PathVariable Integer id){
        return mapper.selectUserById(id);
    }

    @RequestMapping(value = "member/{id}")
    public Member memberList(@PathVariable Integer id){
        return sqlSessionTemplate.selectOne("com.purchasing.springbootmybatis.xml.MemberMapper.selectById",id);
    }

    @RequestMapping(value = "member/list")
    public List<TMember> selectAll(){
        return tMemberMapper.selectAll();
    }

    @RequestMapping(value = "user/list")
    public List<TUser> selectUserAll(){
        return userMapper.selectByExample(null);
    }
}
