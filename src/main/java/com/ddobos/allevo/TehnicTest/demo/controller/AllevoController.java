package com.ddobos.allevo.TehnicTest.demo.controller;

import com.ddobos.allevo.TehnicTest.demo.model.Allevo;
import com.ddobos.allevo.TehnicTest.demo.repository.AllevoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AllevoController {

    @Resource
    private AllevoRepository allevoRepository;

    @GetMapping("/edit")
    public List<Allevo> getEditPage(){
        return allevoRepository.findAll();
    }

    @PostMapping("/edit")
    @ResponseStatus(HttpStatus.CREATED)
    public Allevo addAllevo(@RequestBody Allevo allevo){
        return allevoRepository.save(allevo);
    }

    @GetMapping("/edit/{id}")
    public Allevo getAllevoById(@PathVariable Long id){
    return allevoRepository.findById(id).orElse(null);
    }
}
