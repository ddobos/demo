package com.ddobos.allevo.TehnicTest.demo.model;

public class Action {

    private Long id;
    private String name;

    public Action() {
    }

    public Action(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
