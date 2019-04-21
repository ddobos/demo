package com.ddobos.allevo.TehnicTest.demo.dao;

import com.ddobos.allevo.TehnicTest.demo.model.Allevo;

public interface AllevoDao {
    boolean createAllevo(Allevo allevo);

    Allevo getAllevoById(Long id);
}
