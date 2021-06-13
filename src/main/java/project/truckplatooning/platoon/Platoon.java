package project.truckplatooning.platoon;


public class Platoon  {

    public static Truck leadTruck = null;
    public static Integer speed = 68;

    public void onStart() {

        TruckService truckService = new TruckService();
        truckService.createLead();

    }

    public static void accelerate() {

        int accelerationValue = 3;
        int maxSpeed = 80;

        if (speed >= maxSpeed) {
            return;
        }

        speed += accelerationValue;
    }

    public static void brake() {

        int brakeValue = 3;

        if (speed <= 3) {
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
