package com.ddobos.allevo.TehnicTest.demo.controller;

import com.ddobos.allevo.TehnicTest.demo.model.Action;
import com.ddobos.allevo.TehnicTest.demo.repository.ActionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ActionControlller {

    @Resource
    private ActionRepository actionRepository;

    @GetMapping("/action")
    public List<Action> getActions() {
        return actionRepository.findAll();
    }
}
