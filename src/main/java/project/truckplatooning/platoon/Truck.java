package project.truckplatooning.platoon;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class Truck {

    private Truck leadTruck = Platoon.leadTruck;
    private Long truckProcessId = ProcessHandle.current().pid();
    private Integer truckId;
    private Integer speed = Platoon.speed;
    private Truck truckInFront;
    private Truck truckBehind;
    private TruckRole truckRole;
    private Integer port;


    public Truck(){
        Random random = new Random();
        Integer randomId = random.nextInt(999999999);
        this.truckId = randomId;

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

    public Integer getTruckId() {
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
    public Integer getLeadTruck(){
        return leadTruck.truckId;
    }
    public Long getTruckProcessId() {
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
    public void setTruckId(Integer truckId) {
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

    public void setTruckProcessId(Long truckProcessId) {
        this.truckProcessId = truckProcessId;
    }

    @Override
    public String toString() {
        return "" + truckId;

    }
}