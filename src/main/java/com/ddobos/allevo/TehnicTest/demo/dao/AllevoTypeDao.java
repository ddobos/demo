package com.ddobos.allevo.TehnicTest.demo.dao;

import com.ddobos.allevo.TehnicTest.demo.model.Action;
import com.ddobos.allevo.TehnicTest.demo.model.AllevoAction;
import com.ddobos.allevo.TehnicTest.demo.model.AllevoType;

import java.util.List;

public interface AllevoTypeDao {
    boolean createAllevoType(AllevoType allevoType);
    List<AllevoType> getAllAllevoType(int alevo_id);
}
