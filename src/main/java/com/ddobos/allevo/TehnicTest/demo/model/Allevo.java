package com.ddobos.allevo.TehnicTest.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Allevo {

    private int id;
    private String queueName;
    private String description;
    private int exitPoint;
    private boolean holdStatus;
    private boolean exitPointBool;
    private List<Map<String, Integer>> actions;
    private List<Map<String, Integer>> types;

    public Allevo() {
    }

    public Allevo(int id, String queueName, String description, int exitPoint, boolean holdStatus, boolean exitPointBool, List<Map<String, Integer>> actions, List<Map<String, Integer>> types) {
        this.id = id;
        this.queueName = queueName;
        this.description = description;
        this.exitPoint = exitPoint;
        this.holdStatus = holdStatus;
        this.exitPointBool = exitPointBool;
        this.actions = actions;
        this.types = types;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExitPoint() {
        return exitPoint;
    }

    public void setExitPoint(int exitPoint) {
        this.exitPoint = exitPoint;
    }

    public boolean isHoldStatus() {
        return holdStatus;
    }

    public void setHoldStatus(boolean holdStatus) {
        this.holdStatus = holdStatus;
    }

    public boolean isExitPointBool() {
        return exitPointBool;
    }

    public void setExitPointBool(boolean exitPointBool) {
        this.exitPointBool = exitPointBool;
    }

    public List<Map<String, Integer>> getActions() {
        return actions;
    }

    public void setActions(List<Map<String, Integer>> actions) {
        this.actions = actions;
    }

    public List<Map<String, Integer>> getTypes() {
        return types;
    }

    public void setTypes(List<Map<String, Integer>> types) {
        this.types = types;
    }
}
