package de.truckplatooning.controlservice;

import org.springframework.stereotype.Component;

@Component
public class Truck {

    private Integer leadTruckId;
    private Integer truckInFrontId;
    private Integer truckBehindId;
    private Integer truckId;
    private Integer speed;
    private TruckRole truckRole;

    public Truck() {

    }

    public Integer getTruckInFrontId() {
        return truckInFrontId;
    }
    public Integer getTruckBehindId() {
        return truckBehindId;
    }
    public Integer getLeadTruckId() {
        return leadTruckId;
    }
    public Integer getTruckId() {
        return truckId;
    }
    public Integer getSpeed() {
        return speed;
    }
    public TruckRole getTruckRole() {
        return truckRole;
    }


    public void setLeadTruckId(Integer leadTruckId) {
        this.leadTruckId = leadTruckId;
    }
    public void setTruckInFrontId(Integer truckInFrontId) {
        this.truckInFrontId = truckInFrontId;
    }
    public void setTruckBehindId(Integer truckBehindId) {
        this.truckBehindId = truckBehindId;
    }
    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
    public void setTruckRole(TruckRole truckRole) {
        this.truckRole = truckRole;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "leadTruckId=" + leadTruckId +
                ", truckId=" + truckId +
                ", speed=" + speed +
                ", truckRole=" + truckRole +
                '}';
    }

}
