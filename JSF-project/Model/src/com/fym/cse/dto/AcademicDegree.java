package com.fym.cse.dto;

public class AcademicDegree {

    private String name;
    private int id;
    private int MaxLoad;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxLoad() {
        return MaxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        MaxLoad = maxLoad;
    }
}
