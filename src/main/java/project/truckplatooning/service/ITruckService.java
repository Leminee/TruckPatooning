package project.truckplatooning.service;

public interface ITruckService {
    void adjustSpeed(int speedValue);
    void joinPlatoon(int position);
    void leavePlatoon();
}
