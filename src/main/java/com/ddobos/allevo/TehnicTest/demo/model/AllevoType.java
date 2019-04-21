package com.ddobos.allevo.TehnicTest.demo.model;

public class AllevoType {
    private long id;
    private long allevo_id;
    private long type_id;

    public AllevoType() {
    }

    public AllevoType(long id, long allevo_id, long type_id) {
        this.id = id;
        this.allevo_id = allevo_id;
        this.type_id = type_id;
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

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }
}
