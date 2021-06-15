package project.truckplatooning.platoon;


public class Platoon  {

    public static Truck leadTruck = null;
    public static Integer speed = 64;

    public void onStart() {

        TruckService truckService = new TruckService();
        truckService.createLead();

    }

    public static void accelerate() {

        int accelerationValue = 4;
        int maxSpeed = 80;

        if (speed >= maxSpeed - 3) {
            return;
        }

        speed += accelerationValue;
    }

    public static void brake() {

        int brakeValue = 4;

        if (speed <= 0) {
            return;
        }

        speed -= brakeValue;
    }

    public static void stop() {
        Platoon.speed = 0;
    }

    public void onEnd(){

        System.exit(0);
    }
}
