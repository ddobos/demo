package com.ddobos.allevo.TehnicTest.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "allevo")
public class Allevo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String queueName;
    private String Description;
    private int exitPoint;
    private int type;
    @OneToMany(targetEntity = Action.class)
    private Set<Action> setActions = new HashSet<>();

    public Allevo() {
    }

    public Allevo(Long id, String queueName, String description, int exitPoint, int type, Set<Action> setActions) {
        this.id = id;
        this.queueName = queueName;
        Description = description;
        this.exitPoint = exitPoint;
        this.type = type;
        this.setActions = setActions;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Set<Action> getSetActions() {
        return setActions;
    }

    public void setSetActions(Set<Action> setActions) {
        this.setActions = setActions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getExitPoint() {
        return exitPoint;
    }

    public void setExitPoint(int exitPoint) {
        this.exitPoint = exitPoint;
    }

    private enum holdStatus {
        Active,
        Inactive
    }
}
