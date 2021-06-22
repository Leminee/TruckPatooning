package de.truck.platooning.regservice.service;

import de.truck.platooning.regservice.domain.Truck;
import de.truck.platooning.regservice.domain.TruckRole;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TruckService {

   private final List<Truck> platoon = new LinkedList<>();
   private static int position = 0;

   public void addTruck(Truck truck) {

      Random random = new Random();

      if (platoon.size() == 0) {
         truck.setSpeed(64);
      } else {
         truck.setSpeed(platoon.get(0).getSpeed());
      }


      truck.setTruckId(random.nextInt(999999999));


      if (!isLeader()) {

         truck.setTruckRole(TruckRole.FOLLOW);
         truck.setLeadTruckId(platoon.get(0).getTruckId());
         truck.setTruckInFrontId(platoon.get(position - 1).getTruckId());

      } else {

         truck.setTruckRole(TruckRole.LEAD);

      }

      position++;

      platoon.add(truck);

   }

   public void addTruckPosition(int position, Truck truck) {



      if (platoon.size() <= position) {
         System.err.println("Du kannst an dieser Position keinen Truck hinzufügen");
         return;
      }

      Random random = new Random();

      truck.setTruckId(random.nextInt(999999999));

      if (platoon.size() == 0) {
         truck.setSpeed(64);
      } else {
         truck.setSpeed(platoon.get(0).getSpeed());
      }

      truck.setTruckRole(TruckRole.FOLLOW);
      truck.setLeadTruckId(platoon.get(0).getTruckId());
      truck.setTruckInFrontId(platoon.get(position - 1).getTruckId());


      platoon.add(position, truck);


      if (platoon.size() > 2) {
         platoon.get(position + 1).setTruckInFrontId(platoon.get(position).getTruckId());
      }

   }

   public void removeTruck(int position) {


      if (platoon.size() == 0) {
         System.err.println("Kein LKW im Platoon");
         return;
      }

      if (position > platoon.size()) {
         System.err.println("Es gibt keinen LKW an der angegebenen Position");
         return;
      }

      if (platoon.get(position).getTruckRole() == TruckRole.LEAD) {

         platoon.get(position + 1).setTruckRole(TruckRole.LEAD);
         platoon.get(position + 1).setLeadTruckId(null);
         platoon.get(position + 1).setTruckInFrontId(null);

         if (platoon.size() > 2) {
            platoon.get(position + 1).setTruckBehindId(platoon.get(position + 2).getTruckId());
         }

         for (Truck truck : platoon) {

            truck.setLeadTruckId(platoon.get(position + 1).getTruckId());

         }

      }

      platoon.remove(position);

   }

   public void updateTruckData() {

      for (int i = 0; i < platoon.size() -1; i++) {

         while (platoon.get(i).getTruckBehindId() == null && platoon.indexOf(platoon.get(i)) < platoon.size()) {

            platoon.get(i).setTruckBehindId(platoon.get(i+1).getTruckId());

         }
      }
   }

   public List<Truck> getAllTrucks() {

      updateTruckData();
      return platoon;
   }

   public Truck getTruckByPosition(int position) {

      updateTruckData();
      return platoon.get(position);

   }

   public int getSize() {

      return platoon.size();
   }

   private static boolean isLeader() {

      return TruckService.position == 0;
   }


   public void adjustSpeed() {


   }

   public void accelerate(int value) {

      if (platoon.get(0).getSpeed() + value > 80) {
         System.err.println("Du kannst nicht um " + value + " beschleunigen");
         return;
      }

      platoon.get(0).setSpeed(platoon.get(0).getSpeed() + value);
   }

   public void brake(int value) {

      if (platoon.get(0).getSpeed() - value <= 0) {
         return;
      }

      platoon.get(0).setSpeed(platoon.get(0).getSpeed() - value);
   }

   public void stop() {

      platoon.get(0).setSpeed(0);
   }

}
