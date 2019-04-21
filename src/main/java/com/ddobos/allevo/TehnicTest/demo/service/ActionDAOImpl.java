package com.ddobos.allevo.TehnicTest.demo.service;

import com.ddobos.allevo.TehnicTest.demo.dao.ActionDao;
import com.ddobos.allevo.TehnicTest.demo.mapper.ActionMapper;
import com.ddobos.allevo.TehnicTest.demo.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class ActionDAOImpl implements ActionDao {

    private final String SQL_FIND_ACTION = "Select * from action where id = ?";
    private final String SQL_GET_ALL = "Select * from action";
    private final String SQL_INSERT_ACTION = "Insert into action (id, name) values (?, ?)";

    JdbcTemplate jdbcTemplate;


    @Autowired
    public ActionDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean createAction(Action action) {
        return jdbcTemplate.update(SQL_INSERT_ACTION, action.getId() == null ? 1 : action.getId(), action.getName()) > 0;
    }

    @Override
    public List<Action> getAllAction() {
        return jdbcTemplate.query(SQL_GET_ALL, new ActionMapper());
    }

    @Override
    public Action getActionById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_ACTION, new Object[]{id}, new ActionMapper());
    }
}
