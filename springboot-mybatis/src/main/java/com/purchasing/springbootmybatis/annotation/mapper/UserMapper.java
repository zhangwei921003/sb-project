package com.purchasing.springbootmybatis.annotation.mapper;

import com.purchasing.springbootmybatis.annotation.entity.User;
import com.purchasing.springbootmybatis.handler.DateStringTypeHandler;
import com.purchasing.springbootmybatis.handler.JsonStringTypeHandler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhangwei
 * @createTime 2018/10/29
 */
@Mapper
public interface UserMapper {

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "description", column = "desc",typeHandler = JsonStringTypeHandler.class),
            @Result(property = "birth", column = "birth",typeHandler = DateStringTypeHandler.class)
    })
    @Select("SELECT id,username,password,`desc`,birth FROM t_user WHERE id = #{id}")
    User selectUserById(Integer id);
}
