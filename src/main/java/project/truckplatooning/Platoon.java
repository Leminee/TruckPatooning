package project.truckplatooning;

public class Platoon extends Truck {

    public static Truck leadTruck = null;
    public static Integer speed = 68;

    public void onStart() {

        Truck leadtruck = new Truck();
        leadtruck.setTruckId(1434355L);
        leadtruck.setSpeed(speed);
        leadtruck.setLeadTruck(leadtruck);
        leadtruck.joinPlatoon(leadtruck);
        Platoon.leadTruck = leadtruck;

    }


    public void onEnd(){
        System.exit(0);
    }
}
