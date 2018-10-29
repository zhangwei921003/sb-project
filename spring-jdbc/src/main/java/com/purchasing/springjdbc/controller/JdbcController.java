package com.purchasing.springjdbc.controller;

import com.purchasing.springjdbc.domain.Member;
import com.purchasing.springjdbc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 单体数据库连接
 * @author zhangwei
 * @createTime 2018/10/26
 */
@RestController
public class JdbcController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/jdbc/list")
    public Map<String, Object> list(@RequestParam(value = "id", required = false) Integer id) {
        Map<String, Object> data = new HashMap<String, Object>();
        //数据库连接步骤
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            if (StringUtils.isEmpty(id)) {
                statement = connection.prepareStatement("SELECT * FROM t_member ");
            } else {
                statement = connection.prepareStatement("SELECT * FROM t_member WHERE id =?");
                statement.setInt(1, id);//预编译
            }
            rs = statement.executeQuery();
            while (rs.next()) {
                data.put(rs.getString(2) + "&" + rs.getInt(1), rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @RequestMapping(value = "/template/list")
    public List<Member> templateList() {
        return memberService.list();
    }

    @RequestMapping(value = "template/add", method = RequestMethod.POST)
    public boolean add(@RequestBody(required = false) Member member) {
        return  memberService.save(member);
    }

    @RequestMapping(value = "template/{id}",method = RequestMethod.GET)
    public Member selectById(@PathVariable(value = "id") Integer id) {
        return memberService.selectById(id);
    }

    @RequestMapping(value = "template/delete/{id}",method = RequestMethod.GET)
    public boolean delete(@PathVariable(value = "id") Integer id) {
        return memberService.deleteById(id);
    }
}
