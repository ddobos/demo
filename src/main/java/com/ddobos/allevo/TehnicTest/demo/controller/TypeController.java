package com.ddobos.allevo.TehnicTest.demo.controller;

import com.ddobos.allevo.TehnicTest.demo.model.Type;
import com.ddobos.allevo.TehnicTest.demo.repository.TypeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
