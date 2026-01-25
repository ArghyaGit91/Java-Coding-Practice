package _interface.implementation;

import _interface.Vehicle;

public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car Started: Wheels: "+Vehicle.WHEELS);
    }
}
