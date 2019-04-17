package com.ddobos.allevo.TehnicTest.demo.controller;

import com.ddobos.allevo.TehnicTest.demo.model.Allevo;
import com.ddobos.allevo.TehnicTest.demo.repository.AllevoRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class AllevoController {

    @Resource
    private AllevoRepository allevoRepository;

    @GetMapping("/edit")
    public List<Allevo> getEditPage() {
        return allevoRepository.findAll();
    }

    @GetMapping("/edit/add")
    public String getAddPage() {
        return "add";
    }

    @PostMapping(value = "/edit")
    public String addAllevo(@RequestBody Allevo allevo) {
        allevoRepository.save(allevo);
        return "edit";
    }

    @GetMapping("/edit/{id}")
    public String getAllevoById(Model model, @PathVariable("id") Long id) {
        Allevo allevo = (Allevo) allevoRepository.findById(id).orElse(null);
        model.addAttribute("allevo", allevo);
        if (allevo != null) {
            model.addAttribute("active", allevo.isHoldStatus());
            model.addAttribute("inactive", !allevo.isHoldStatus());
            model.addAttribute("isExitPoint", allevo.isExitPoint());
        }
        return "edit";
    }
}

