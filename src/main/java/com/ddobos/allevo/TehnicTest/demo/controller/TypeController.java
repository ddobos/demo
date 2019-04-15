package com.ddobos.allevo.TehnicTest.demo.controller;

import com.ddobos.allevo.TehnicTest.demo.model.Action;
import com.ddobos.allevo.TehnicTest.demo.model.Type;
import com.ddobos.allevo.TehnicTest.demo.repository.TypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TypeController {

    @Resource
    private TypeRepository typeRepository;

    @GetMapping("/type")
    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    @PostMapping("/type")
    @ResponseStatus(HttpStatus.CREATED)
    public Type add(@RequestBody Type type){
        return typeRepository.save(type);
    }
}
