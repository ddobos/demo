package com.ddobos.allevo.TehnicTest.demo.controller;

import com.ddobos.allevo.TehnicTest.demo.service.ActionDAOImpl;
import com.ddobos.allevo.TehnicTest.demo.model.Action;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ActionController {

    @Resource
    private ActionDAOImpl actionDaoImpl;

    @GetMapping("/action")
    public List<Action> getActions() {
        return actionDaoImpl.getAllAction();
    }

    @PostMapping("/action")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addAction(@RequestBody Action action) {
        return actionDaoImpl.createAction(action);
    }
}
