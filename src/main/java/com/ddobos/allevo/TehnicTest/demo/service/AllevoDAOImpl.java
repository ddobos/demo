package com.ddobos.allevo.TehnicTest.demo.service;

import com.ddobos.allevo.TehnicTest.demo.dao.AllevoDao;
import com.ddobos.allevo.TehnicTest.demo.mapper.AllevoMapper;
import com.ddobos.allevo.TehnicTest.demo.model.Allevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

@Component
public class AllevoDAOImpl implements AllevoDao {

    private final String SQL_INSERT_ALLEVO = "insert into allevo (queue_name, description, exit_point, " +
            "exit_point_bool, hold_status) values(?,?,?,?,?)";
    private final String SQL_GET_ALLEVO = "select * from allevo";
    private final String SQL_GET_ALLEVO_BY_ID = "select * from allevo where id = ?";
    private final String SQL_INSERT_ALLEVOACTION = "insert into allevo_action (allevo_id, action_id)values(?,?)";
    private final String SQL_INSERT_ALLEVOTYPE = "insert into allevo_type (allevo_id, type_id)values(?,?)";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public AllevoDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate((dataSource));
    }

    @Override
    public boolean createAllevo(Allevo allevo) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement ps = con.prepareStatement(SQL_INSERT_ALLEVO, new String[]{"id"});
                        ps.setString(1, allevo.getQueueName());
                        ps.setString(2, allevo.getDescription());
                        ps.setInt(3, allevo.getExitPoint());
                        ps.setBoolean(4, allevo.isExitPointBool());
                        ps.setBoolean(5, allevo.isHoldStatus());
                        return ps;
                    }
                }, keyHolder);
        int id = keyHolder.getKey().intValue();
        if (allevo.getActions() != null) {
            for (Map<String, Integer> action : allevo.getActions()) {
                jdbcTemplate.update(SQL_INSERT_ALLEVOACTION, id, action.get("id"));
            }
        }
        if (allevo.getTypes() != null) {
            for (Map<String, Integer> type : allevo.getTypes()) {
                jdbcTemplate.update(SQL_INSERT_ALLEVOTYPE, id, type.get("id"));
            }
        }
        return id > 0;
    }

    @Override
    public Allevo getAllevoById(Long id) {
        return jdbcTemplate.queryForObject(SQL_GET_ALLEVO_BY_ID, new Object[]{id}, new AllevoMapper());
    }
}
