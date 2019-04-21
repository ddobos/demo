package com.ddobos.allevo.TehnicTest.demo.service;

import com.ddobos.allevo.TehnicTest.demo.dao.AllevoActionDao;
import com.ddobos.allevo.TehnicTest.demo.mapper.AllevoActionMapper;
import com.ddobos.allevo.TehnicTest.demo.model.AllevoAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class AllevoActionDAOImpl implements AllevoActionDao {

    private final String SQL_INSERT_ALLEVOACTION = "insert into allevo_action (id, allevo_id, action_id) values(?,?,?,?,?,?)";
    private final String SQL_GET_ALLEVOACTION_BY_ALLEVO_ID = "select * from allevo_action where allevo_id = ?";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public AllevoActionDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate((dataSource));
    }

    @Override
    public boolean createAllevoAction(AllevoAction allevoAction) {
        return jdbcTemplate.update(SQL_INSERT_ALLEVOACTION,
                allevoAction.getId(),
                allevoAction.getAllevo_id(),
                allevoAction.getAction_id()) > 0;
    }

    @Override
    public List<AllevoAction> getActionAllevoById(Long allevoId) {
        return jdbcTemplate.query(SQL_GET_ALLEVOACTION_BY_ALLEVO_ID, new Object[]{allevoId}, new AllevoActionMapper());
    }
}
