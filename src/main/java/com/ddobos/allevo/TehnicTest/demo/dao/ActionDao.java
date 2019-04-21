package com.ddobos.allevo.TehnicTest.demo.dao;

import com.ddobos.allevo.TehnicTest.demo.model.Action;

import java.util.List;

public interface ActionDao {
    boolean createAction(Action action);
    List<Action> getAllAction();
    Action getActionById(Long id);
}
