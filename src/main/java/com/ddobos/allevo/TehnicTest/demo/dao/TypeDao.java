package com.ddobos.allevo.TehnicTest.demo.dao;

import com.ddobos.allevo.TehnicTest.demo.model.Type;

import java.util.List;

public interface TypeDao {
    boolean createType(Type type);
    List<Type> getAllType();
    Type getTypeById(Long id);
}
