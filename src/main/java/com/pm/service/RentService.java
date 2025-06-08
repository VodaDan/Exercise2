package com.pm.service;

import com.pm.models.User;
import com.pm.models.Vehicle;

public class RentService {

    public RentService () {}

    public static boolean rentVehicle(User user, Vehicle vehicle) {
        if(!vehicle.isRented()) {
            if(user.getBudget() >= vehicle.getCost()) {
                vehicle.setRented(true,user);
                System.out.println("User " + user.getName() + " successfully rented vehicle "+vehicle.getName() + " !");
                user.setBudget(user.getBudget() - vehicle.getCost());
                return true;
            } else {
                System.out.println("User " + user.getName() + " budget is to low for vehicle " + vehicle.getName() + " !");
                return false;
            }
        } else {
            System.out.println("Vehicle " + vehicle.getName() + " is already rented !");
            return false;
        }
    }

    public static boolean returnVehicle(User user, Vehicle vehicle) {
        if(!vehicle.isRented()) {
            System.out.println("Vehicle " + vehicle.getName() + " is not rented!" );
            return false;
        } else {
            if(vehicle.getRentedBy().equals(user)){
                vehicle.setRented(false,null);
                System.out.println("User " + user.getName() + " returned vehicle " +vehicle.getName() + " !" );
                return true;
            } else {
                System.out.println("Vehicle " + vehicle.getName() + " is not rented by " + user.getName() + " !");
                return false;
            }

        }
    }
}
