package project.truckplatooning;


import java.util.Random;

public class Platoon {

    public static Truck leadTruck = null;
    public static Integer speed = 65;

    public void accelerate() {
        Random random = new Random();

        int accelerationValue = random.nextInt(8);
        int maxSpeed = 80;


        if (speed >= maxSpeed) {
            return;
        }
        speed += accelerationValue;
    }

    public  void brake() {
        Random random = new Random();
        int brakeValue = random.nextInt(8);

        if (speed <= 0) {
            return;
        }

        speed -= brakeValue;
    }

    public void steer() {

    }

    public void leavePlatoon(Truck truck) {

    }

    public void stop() {
        speed = 0;
    }

}
