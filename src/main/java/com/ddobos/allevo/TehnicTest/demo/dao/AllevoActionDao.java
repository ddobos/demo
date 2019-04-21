package com.ddobos.allevo.TehnicTest.demo.dao;

import com.ddobos.allevo.TehnicTest.demo.model.AllevoAction;

import java.util.List;

public interface AllevoActionDao {
    boolean createAllevoAction(AllevoAction allevoAction);
    List<AllevoAction> getActionAllevoById(Long allevoId);
}
