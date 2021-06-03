package project.truckplatooning;

public class Truck {
    private Long truckId;
    private Integer speed = Platoon.speed;
    private Truck truckInFront;
    private Truck truckBehind;

    public void joinPlatoon(Truck truck) {

        Truck currentTruck = this;

        while (currentTruck.getTruckBehind() != null) {
            currentTruck = currentTruck.getTruckBehind();
        }
        currentTruck.setTruckBehind(truck);
        truck.setTruckInFront(currentTruck);
    }


    public void leavePlatoon(Truck truck) {

    }

    public long getTruckId() {
        return truckId;
    }

    public int getSpeed() {
        return speed;
    }

    public Truck getTruckInFront() {
        return truckInFront;
    }

    public Truck getTruckBehind() {
        return truckBehind;
    }
    public void setTruckId(long truckId) {
        this.truckId = truckId;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTruckInFront(Truck truckInFront) {
        this.truckInFront = truckInFront;
    }

    public void setTruckBehind(Truck truckBehind) {
        this.truckBehind = truckBehind;
    }


    @Override
    public String toString() {
        return "Truck{" +
                "truckId=" + truckId +
                ", speed=" + speed +
                ", truckInFront=" + truckInFront +
                ", truckBehind=" + truckBehind +
                '}';
    }
}