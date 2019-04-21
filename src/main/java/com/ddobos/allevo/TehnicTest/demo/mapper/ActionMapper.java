package com.ddobos.allevo.TehnicTest.demo.mapper;

import com.ddobos.allevo.TehnicTest.demo.model.Action;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActionMapper implements RowMapper<Action> {
    @Override
    public Action mapRow(ResultSet rs, int rowNum) throws SQLException {
        Action action = new Action();
        action.setId(rs.getLong("id"));
        action.setName(rs.getString("name"));
        return action;
    }
}
