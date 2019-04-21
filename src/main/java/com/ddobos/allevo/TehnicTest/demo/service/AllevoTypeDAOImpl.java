package com.ddobos.allevo.TehnicTest.demo.service;

import com.ddobos.allevo.TehnicTest.demo.dao.AllevoTypeDao;
import com.ddobos.allevo.TehnicTest.demo.mapper.AllevoTypeMapper;
import com.ddobos.allevo.TehnicTest.demo.model.AllevoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class AllevoTypeDAOImpl implements AllevoTypeDao {

    private final String SQL_INSERT_ALLEVOTYPE = "insert into allevo_type (id, allevo_id, type_id) values(?,?,?)";
    private final String SQL_GET_ALLEVOTYPE_BY_ALLEVO_ID = "select * from allevo_type where allevo_id = ?";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public AllevoTypeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate((dataSource));
    }

    @Override
    public boolean createAllevoType(AllevoType allevoType) {
        return jdbcTemplate.update(SQL_INSERT_ALLEVOTYPE,
                allevoType.getId(),
                allevoType.getAllevo_id(),
                allevoType.getType_id()) > 0;
    }

    @Override
    public List<AllevoType> getAllAllevoType(int alevo_id) {
        return jdbcTemplate.query(SQL_GET_ALLEVOTYPE_BY_ALLEVO_ID, new Object[]{alevo_id}, new AllevoTypeMapper());
    }
}
