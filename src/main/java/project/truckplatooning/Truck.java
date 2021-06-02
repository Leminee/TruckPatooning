package project.truckplatooning;

public class Truck {
    private Long truckId;
    private Integer speed = 0;
    private Truck truckInFront;
    private Truck truckBehind;

    public Truck() {

    }

    public void accelerate() {
        int accelerationValue = 5;
        int maxSpeed = 80;

        if (speed >= maxSpeed) {
            return;
        }
        speed += accelerationValue;
    }

    public  void brake() {
        int brakeValue = 5;

        if (speed <= 0) {
            return;
        }

        speed -= brakeValue;
    }

    public void stop() {
        speed = 0;
    }

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


}