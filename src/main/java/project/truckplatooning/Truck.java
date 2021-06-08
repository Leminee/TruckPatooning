package project.truckplatooning;


import java.util.concurrent.atomic.AtomicInteger;

public class Truck {
    private static final AtomicInteger pIdCounter = new AtomicInteger(0);
    private Truck leadTruck = Platoon.leadTruck;
    private Integer truckProcessId;
    private Long truckId;
    private Integer speed = Platoon.speed;
    private Integer distanceBetweenTrucks = 15;
    private Truck truckInFront;
    private Truck truckBehind;


    public Truck(){
      truckProcessId = pIdCounter.incrementAndGet();
    }

    public Truck(Long truckId,Integer speed, Truck truckInFront, Truck truckBehind) {
        this.truckId = truckId;
        this.speed = speed;
        this.truckInFront = truckInFront;
        this.truckBehind = truckBehind;
    }

    public static void createTruck() {

    }

    public void joinPlatoon(Truck truck) {

        createTruck();

        Truck currentTruck = this;

        while (currentTruck.truckBehind != null) {
            currentTruck = currentTruck.truckBehind;
        }
        currentTruck.setTruckBehind(truck);
        truck.setTruckInFront(currentTruck);
    }

    public void leavePlatoon(Truck truck) {

    }

    public Long getTruckId() {
        return truckId;
    }
    public Truck getTruckInFront() {
        return truckInFront;
    }
    public Truck getTruckBehind() {
        return truckBehind;
    }
    public Integer getSpeed() {
        return speed;
    }
    public Long getLeadTruck(){
        return leadTruck.truckId;
    }
    public Integer getTruckProcessId() {
        return truckProcessId;
    }
    public Integer getDistanceBetweenTrucks() {
        return distanceBetweenTrucks;
    }
    public void setLeadTruck(Truck leadTruck) {
        this.leadTruck = leadTruck; }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setTruckInFront(Truck truckInFront) {
        this.truckInFront = truckInFront;
    }
    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }
    public void setTruckBehind(Truck truckBehind) {
        this.truckBehind = truckBehind;
    }
    public void setTruckProcessId(Integer truckProcessId) {
        this.truckProcessId = truckProcessId;
    }
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
    public void setDistanceBetweenTrucks(Integer distanceBetweenTrucks) {
        this.distanceBetweenTrucks = distanceBetweenTrucks;
    }
}