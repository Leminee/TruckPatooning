package project.truckplatooning;

import java.util.Random;

public class Platoon {

    public static Truck leadTruck = null;

    public static Integer speed = 70;


    public void accelerate() {
        int accelerationValue = 5;
        int maxSpeed = 80;

        if (speed >= maxSpeed) {
            return;
        }
        speed += accelerationValue;
    }

    public  void brake() {
        int brakeValue = 5;

        if (speed <= 0) {
            return;
        }

        speed -= brakeValue;
    }

    public void stop() {
        speed = 0;
    }

}
