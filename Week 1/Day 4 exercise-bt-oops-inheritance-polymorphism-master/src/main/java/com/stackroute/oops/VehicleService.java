package com.stackroute.oops;

public class VehicleService {
    Car vehicle1;
    Bike vehicle2;
    /*
    create a Car object and return it
     */
    public Car createCar(String name, String modelName, String type) {
        return new Car(name, modelName,type );
    }

    /*
    create a bike object and return it
     */
    public Bike createBike(String name, String modelName, String type) {

        return new Bike(name,modelName,type);
    }

    /*
    Method should compare the speed only if the vehicle is of "SPORTS" type.
    Method should return 0 when speeds are equal otherwise should return maximum vehicle speed.
    Method returns -1 if the type is not "SPORTS"
    */
    public int compareMaxSpeed(Vehicle first, Vehicle second) {
        /*
        Vehicle objects should be downcasted to their respective concrete types
        */
        if (first instanceof Car) {
            vehicle1 = (Car) first;
            vehicle2 = (Bike) second;
        }

        if (second instanceof Car) {
            vehicle1 = (Car) second;
            vehicle2 = (Bike) first;
        }

        if (vehicle1.getType().equals("sports") && vehicle2.getType().equals("sports")) {
            if (vehicle1.maxSpeed("sports") == vehicle2.maxSpeed("sports")) {
                return 0;
            } else return Math.max(vehicle1.maxSpeed("sports"), vehicle2.maxSpeed("sports"));
        } else return -1;
    }
}
