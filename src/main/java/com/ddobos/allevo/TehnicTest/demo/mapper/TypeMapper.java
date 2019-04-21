package com.ddobos.allevo.TehnicTest.demo.mapper;

import com.ddobos.allevo.TehnicTest.demo.model.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeMapper implements RowMapper<Type> {
    @Override
    public Type mapRow(ResultSet rs, int rowNum) throws SQLException {
        Type type = new Type();
        type.setId(rs.getLong("id"));
        type.setName(rs.getString("name"));
        return type;
    }
}
