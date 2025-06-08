package com.pm;

import com.pm.models.User;
import com.pm.models.Car;
import com.pm.models.Scooter;
import com.pm.models.Vehicle;
import com.pm.service.RentService;

public class Main {
    public static void main(String[] args) {
        User A = new User(100, "A");
        User B = new User(200, "B");

        Vehicle car = new Car(100);
        Vehicle scooter = new Scooter(5);

        RentService.rentVehicle(A,car);
        RentService.rentVehicle(B,car);

        RentService.returnVehicle(A,car);
        RentService.rentVehicle(B,scooter);

        RentService.returnVehicle(B,scooter);
        RentService.rentVehicle(A,scooter);

    }
}