package project.truckplatooning;


import java.util.Random;

public class Platoon extends Truck {

    public static Truck leadTruck = null;
    public static Integer speed = 70;


    public void onStart() {

        Truck leadtruck = new Truck();
        leadtruck.setTruckId(1434355L);
        leadtruck.setSpeed(speed);
        leadtruck.setLeadTruck(leadtruck);
        leadtruck.joinPlatoon(leadtruck);
        Platoon.leadTruck = leadtruck;

    }

    public void accelerate() {
        Random random = new Random();

        int accelerationValue = random.nextInt(8);
        int maxSpeed = 80;

        //Wenn die Geschwindigkeit 75 wird die Orange, 79 oder 80 wird die Rot

        if (speed >= maxSpeed) {
            return;
        }
        speed += accelerationValue;
    }

    public void steer() {

        //TODO
    }

    public  void brake() {
        Random random = new Random();
        int brakeValue = random.nextInt(20);

        if (speed <= 0) {
            return;
        }

        speed -= brakeValue;
    }

    public void stop() {
        speed = 0;
    }

    public void leavePlatoon(Truck truck) {

        //TODO

    }

    public void onEnd(){
        System.exit(0);
    }

}
