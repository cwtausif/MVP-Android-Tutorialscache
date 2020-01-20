package com.tutorialscache.datafilter.model;

public class DataModel {
    private int id;
    private String name;
    private int rollNumber;

    public DataModel(int id, String name, int rollNumber) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }
}
