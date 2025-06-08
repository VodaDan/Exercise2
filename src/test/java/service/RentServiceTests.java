package service;

import com.pm.models.Car;
import com.pm.models.Scooter;
import com.pm.models.User;
import com.pm.models.Vehicle;
import com.pm.service.RentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RentServiceTests {

    private User userA;
    private User userB;
    private Vehicle car;
    private Vehicle scooter;

    @BeforeEach
    public void setUp() {
        userA = new User(100,"A");
        userB = new User(200,"B");

        car = new Car(100);
        scooter = new Scooter(5);
    }

    @Test
    public void rentVehicleSuccessTest() {
        assertTrue(RentService.rentVehicle(userA,car));
        assertTrue(car.isRented());
        assertEquals(0,userA.getBudget());
        assertEquals(userA, car.getRentedBy());
    }

    @Test
    public void rentVehicleInsufficientBudgetTest() {
        userA.setBudget(90); // Car requires 100$

        assertFalse(RentService.rentVehicle(userA,car));
        assertEquals(90,userA.getBudget());
        assertFalse(car.isRented());
    }

    @Test
    public void rentAlreadyRentedVehicleTest() {
        RentService.rentVehicle(userB, car);

        assertFalse(RentService.rentVehicle(userA,car));
        assertEquals(userB,car.getRentedBy());
        assertEquals(100,userA.getBudget());
    }

    @Test
    public void returnRentedVehicleSuccesfullyTest() {
        RentService.rentVehicle(userA, car);
        assertEquals(userA,car.getRentedBy());

        RentService.returnVehicle(userA, car);
        assertNull(car.getRentedBy());
        assertEquals(0, userA.getBudget());

        RentService.rentVehicle(userB, car);
        assertEquals(userB, car.getRentedBy());
    }

    @Test
    public void onlyOwnerCanReturnTest() {
        RentService.rentVehicle(userB,car);
        assertNotEquals(userA, car.getRentedBy());

        assertFalse(RentService.returnVehicle(userA, car));

        RentService.returnVehicle(userA, car);
        assertTrue(car.isRented());
        assertEquals(userB, car.getRentedBy());
    }

    @Test
    public void rentSameVehicleByOwnerTest() {
        // User B initial budget is 200$. Car rent is 100$.
        RentService.rentVehicle(userB,car);
        assertEquals(userB, car.getRentedBy());
        assertTrue(car.isRented());
        assertEquals(100, userB.getBudget());
        assertFalse(RentService.rentVehicle(userB,car));
        assertEquals(100,userB.getBudget());
    }
}
