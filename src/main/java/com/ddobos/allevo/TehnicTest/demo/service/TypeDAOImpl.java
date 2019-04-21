package com.ddobos.allevo.TehnicTest.demo.service;

import com.ddobos.allevo.TehnicTest.demo.dao.TypeDao;
import com.ddobos.allevo.TehnicTest.demo.mapper.TypeMapper;
import com.ddobos.allevo.TehnicTest.demo.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class TypeDAOImpl implements TypeDao {

    private final String SQL_INSERT_TYPE = "insert into type (id, name) values(?, ?)";
    private final String SQL_GET_TYPE = "select * from type";
    private final String SQL_FIND_TYPE = "select * from type where id = ?";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public TypeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean createType(Type type) {
        return jdbcTemplate.update(SQL_INSERT_TYPE, type.getId() == null ? 1 : type.getId(), type.getName()) > 0;
    }

    @Override
    public List<Type> getAllType() {
        return jdbcTemplate.query(SQL_GET_TYPE, new TypeMapper());
    }

    @Override
    public Type getTypeById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_TYPE, new Object[]{id}, new TypeMapper());
    }
}
