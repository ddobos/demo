package com.ddobos.allevo.TehnicTest.demo.controller;

import com.ddobos.allevo.TehnicTest.demo.model.Action;
import com.ddobos.allevo.TehnicTest.demo.model.Allevo;
import com.ddobos.allevo.TehnicTest.demo.repository.ActionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.xml.ws.Response;
import java.util.List;

@RestController
public class ActionController {

    @Resource
    private ActionRepository actionRepository;

    @GetMapping("/action")
    public List<Action> getActions() {
        return actionRepository.findAll();
    }

    @PostMapping("/action")
    @ResponseStatus(HttpStatus.CREATED)
    public Action addAction(@RequestBody Action action){
        return actionRepository.save(action);
    }
}
