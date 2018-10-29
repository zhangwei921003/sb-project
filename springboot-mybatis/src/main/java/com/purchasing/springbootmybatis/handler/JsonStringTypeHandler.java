package com.purchasing.springbootmybatis.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.purchasing.springbootmybatis.annotation.entity.Description;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhangwei
 * @createTime 2018/10/29
 */
public class JsonStringTypeHandler extends BaseTypeHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        try {
            StringWriter stringWriter = new StringWriter();
            objectMapper.writeValue(stringWriter, parameter);
            String desc = stringWriter.toString();
            ps.setString(i, desc);
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String desc = rs.getString(columnName);
        Description description = null;
        try {
            if (StringUtils.hasText(desc)) {
                description = objectMapper.readValue(desc, Description.class);
            }
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return description;
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String desc = rs.getString(columnIndex);
        Description description = null;
        try {
            if (StringUtils.hasText(desc)) {
                description = objectMapper.readValue(desc, Description.class);
            }
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return description;
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String desc = cs.getString(columnIndex);
        Description description = null;
        try {
            if (StringUtils.hasText(desc)) {
                description = objectMapper.readValue(desc, Description.class);
            }
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return description;
    }
}
