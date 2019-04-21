package com.ddobos.allevo.TehnicTest.demo.mapper;

import com.ddobos.allevo.TehnicTest.demo.dao.AllevoDao;
import com.ddobos.allevo.TehnicTest.demo.model.AllevoAction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllevoActionMapper implements RowMapper<AllevoAction> {
    @Override
    public AllevoAction mapRow(ResultSet rs, int rowNum) throws SQLException {
        AllevoAction allevoAction = new AllevoAction();
        allevoAction.setId(rs.getLong("id"));
        allevoAction.setAllevo_id(rs.getLong("allevo_id"));
        allevoAction.setAction_id(rs.getLong("action_id"));
        return allevoAction;
    }
}
