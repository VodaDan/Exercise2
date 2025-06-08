package com.pm.models;

public abstract class Vehicle {
    private int cost;
    private boolean isRented;
    private String name;
    private User rentedBy;

    public Vehicle (int cost, String name) {
        this.name = name;
        this.cost = cost;
        this.isRented = false;
        System.out.println("Vehicle " + this.name + " has been created and it costs " + this.cost + "$ !");
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isRented() {
        return isRented;
    }

    public User getRentedBy() {
        return rentedBy;
    }

    public void setRented(boolean rented, User user) {
        isRented = rented;
        this.rentedBy = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
