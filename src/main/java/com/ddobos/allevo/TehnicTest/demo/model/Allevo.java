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
    private String description;
    private int exitPoint;
    @OneToMany(targetEntity = Action.class)
    private Set<Action> actions = new HashSet<>();
    @OneToMany(targetEntity = Type.class)
    private Set<Type> types = new HashSet<>();


    public Allevo() {
    }

    public Allevo(Long id, String queueName, String description, int exitPoint, int type, Set<Action> setActions) {
        this.id = id;
        this.queueName = queueName;
        this.description = description;
        this.exitPoint = exitPoint;
        this.actions = setActions;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
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

    private enum holdStatus {
        Active,
        Inactive
    }
}
