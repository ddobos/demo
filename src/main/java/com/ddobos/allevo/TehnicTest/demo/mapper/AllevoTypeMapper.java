package com.ddobos.allevo.TehnicTest.demo.mapper;

import com.ddobos.allevo.TehnicTest.demo.model.AllevoType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllevoTypeMapper implements RowMapper<AllevoType> {
    @Override
    public AllevoType mapRow(ResultSet rs, int rowNum) throws SQLException {
        AllevoType allevoType = new AllevoType();
        allevoType.setId(rs.getLong("id"));
        allevoType.setAllevo_id(rs.getLong("allevo_id"));
        allevoType.setType_id(rs.getLong("type_id"));
        return allevoType;
    }
}
