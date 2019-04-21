package com.ddobos.allevo.TehnicTest.demo.controller;

import com.ddobos.allevo.TehnicTest.demo.model.*;
import com.ddobos.allevo.TehnicTest.demo.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AllevoController {

    @Resource
    private AllevoDAOImpl allevoDaoImpl;
    @Resource
    private AllevoTypeDAOImpl allevoTypeDaoImpl;
    @Resource
    private AllevoActionDAOImpl allevoActionDaoImpl;
    @Resource
    private ActionDAOImpl actionDaoImpl;
    @Resource
    private TypeDAOImpl typeDaoImpl;

    @GetMapping("/edit/add")
    public String getAddPage(Model model) {
        List<Type> typeList = typeDaoImpl.getAllType();
        Action[] intAction = actionDaoImpl.getAllAction().toArray(new Action[0]);
        model.addAttribute("actions", intAction);
        model.addAttribute("types", typeList);
        return "add";
    }

    @PostMapping(value = "/edit")
    @ResponseStatus(value = HttpStatus.OK)
    public String addAllevo(Model model, @RequestBody Allevo allevo) {
        allevoDaoImpl.createAllevo(allevo);
        return "add";
    }

    @GetMapping("/edit/{id}")
    public String getAllevoById(Model model, @PathVariable("id") Long id) {
        Allevo allevo = (Allevo) allevoDaoImpl.getAllevoById(id);
        List<AllevoType> allevoTypeList = allevoTypeDaoImpl.getAllAllevoType(id.intValue());
        List<Integer> actions = new ArrayList<>();
        for (AllevoAction allevoActionList : allevoActionDaoImpl.getActionAllevoById(id)) {
            actions.add((int)allevoActionList.getAction_id());
        }

        Action[] intAction = actionDaoImpl.getAllAction().toArray(new Action[0]);
        model.addAttribute("allevo", allevo);
        if (allevo != null) {
            model.addAttribute("active", allevo.isHoldStatus());
            model.addAttribute("inactive", !allevo.isHoldStatus());
            model.addAttribute("isExitPoint", allevo.isExitPointBool());
            model.addAttribute("types", allevoTypeList);
            model.addAttribute("acts", allevoActionDaoImpl.getActionAllevoById(id));
            model.addAttribute("allAction", intAction);
        }
        return "edit";
    }
}

