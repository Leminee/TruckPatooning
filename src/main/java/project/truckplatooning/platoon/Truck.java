package project.truckplatooning.platoon;

public class Truck {

    private Truck leadTruck = Platoon.leadTruck;
    private static Integer truckProcessId = 0;
    private Long truckId;
    private Integer speed = Platoon.speed;
    private Truck truckInFront;
    private Truck truckBehind;
    private TruckRole truckRole;


    public Truck(){
        Truck.truckProcessId++;

    }

    public Truck(TruckRole role){
        Truck.truckProcessId++;

    }

    public Truck(Truck leadTruck, Integer truckProcessId, Long truckId, Integer speed, TruckRole truckRole) {
        this.leadTruck = leadTruck;
        this.truckProcessId = truckProcessId;
        this.truckId = truckId;
        this.speed = speed;
        this.truckRole = truckRole;
        Truck.truckProcessId = truckProcessId ++;
    }



    public Truck(Truck leadTruck, Integer truckProcessId, Long truckId, Integer speed, Truck truckInFront, Truck truckBehind, TruckRole truckRole) {
        this.leadTruck = leadTruck;
        this.truckProcessId = truckProcessId;
        this.truckId = truckId;
        this.speed = speed;
        this.truckInFront = truckInFront;
        this.truckBehind = truckBehind;
        this.truckRole = truckRole;
        Truck.truckProcessId = truckProcessId ++;
    }

    public void joinPlatoon(Truck truck) {

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
    public TruckRole getTruckRole() {
        return truckRole;
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
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public void setTruckRole(TruckRole truckRole) {
        this.truckRole = truckRole;
    }

    @Override
    public String toString() {
        return "" + truckId;

    }
}