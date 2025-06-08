package com.pm.models;

public class User {
    private int budget;
    private String name;

    public User(int budget, String name) {
        this.budget = budget;
        this.name = name;
        System.out.println("User " +this.name  + " with a budget of " + this.budget + "$ has been created.");
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
