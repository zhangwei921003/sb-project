package com.purchasing.springjdbc.service;

import com.purchasing.springjdbc.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangwei
 * @createTime 2018/10/26
 */
@Service
@EnableTransactionManagement
@Transactional
public class MemberService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Member> list() {
        return jdbcTemplate.query("SELECT * FROM t_member",
                (RowMapper<Member>) (rs, rowNum) -> {
                    Member member = new Member();
                    member.setId(rs.getInt(1));
                    member.setName(rs.getString(2));
                    member.setAge(rs.getInt(4));
                    member.setAddr(rs.getString(3));
                    return member;
                });
    }

    public boolean save(Member member) {
        return jdbcTemplate.execute("INSERT INTO  t_member (name,addr,age) values (?,?,?)",
                (PreparedStatementCallback<Boolean>) ps -> {
                    ps.setString(1, member.getName());
                    ps.setString(2, member.getAddr());
                    ps.setInt(3, member.getAge());
                    return ps.executeUpdate() > 0;
                });
    }

    public Member selectById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM t_member WHERE id = ?",
                (RowMapper<Member>) (rs, rowNum) -> {
                    Member member = new Member();
                    member.setId(rs.getInt(1));
                    member.setName(rs.getString(2));
                    member.setAge(rs.getInt(4));
                    member.setAddr(rs.getString(3));
                    return member;
                }, id);
    }

    public boolean deleteById(Integer id) {
        return jdbcTemplate.update("DELETE  FROM t_member WHERE id=?", id) > 0;
    }
}
