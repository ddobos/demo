package com.ddobos.allevo.TehnicTest.demo.model;

public class AllevoAction {
    private long id;
    private long allevo_id;
    private long action_id;

    public AllevoAction() {
    }

    public AllevoAction(long id, long allevo_id, long action_id) {
        this.id = id;
        this.allevo_id = allevo_id;
        this.action_id = action_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAllevo_id() {
        return allevo_id;
    }

    public void setAllevo_id(long allevo_id) {
        this.allevo_id = allevo_id;
    }

    public long getAction_id() {
        return action_id;
    }

    public void setAction_id(long action_id) {
        this.action_id = action_id;
    }
}
