package com.ddobos.allevo.TehnicTest.demo.controller;

import com.ddobos.allevo.TehnicTest.demo.service.TypeDAOImpl;
import com.ddobos.allevo.TehnicTest.demo.model.Type;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TypeController {

    @Resource
    private TypeDAOImpl typeDAOImpl;

    @GetMapping("/type")
    public List<Type> getTypes() {
        return typeDAOImpl.getAllType();
    }

    @PostMapping("/type")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean add(@RequestBody Type type) {
        return typeDAOImpl.createType(type);
    }
}
