package com.ddobos.allevo.TehnicTest.demo.mapper;


import com.ddobos.allevo.TehnicTest.demo.model.Allevo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllevoMapper implements RowMapper<Allevo> {

    @Override
    public Allevo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Allevo allevo = new Allevo();
        allevo.setId(rs.getInt("id"));
        allevo.setQueueName(rs.getString("queue_name"));
        allevo.setDescription(rs.getString("description"));
        allevo.setExitPoint(rs.getInt("exit_point"));
        allevo.setExitPointBool(rs.getBoolean("exit_point_bool"));
        allevo.setHoldStatus(rs.getBoolean("hold_status"));
        return allevo;
    }
}
