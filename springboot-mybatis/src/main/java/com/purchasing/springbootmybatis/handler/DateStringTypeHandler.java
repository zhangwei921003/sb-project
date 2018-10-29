package com.purchasing.springbootmybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author zhangwei
 * @createTime 2018/10/29
 */
public class DateStringTypeHandler extends BaseTypeHandler<String> {


    private  final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setTimestamp(i, new Timestamp(sdf.parse(parameter).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp sqlTimestamp = rs.getTimestamp(columnName);
        if (sqlTimestamp != null) {
            return sdf.format(new java.util.Date(sqlTimestamp.getTime()));
        }
        return null;
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp sqlTimestamp = rs.getTimestamp(columnIndex);
        if (sqlTimestamp != null) {
            return sdf.format(new java.util.Date(sqlTimestamp.getTime()));
        }
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp sqlTimestamp = cs.getTimestamp(columnIndex);
        if (sqlTimestamp != null) {
            return sdf.format(new java.util.Date(sqlTimestamp.getTime()));
        }
        return null;
    }
}
