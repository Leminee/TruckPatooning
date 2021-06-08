package project.truckplatooning.service;

public class TruckService {

    public void closeGap(){

        // Um die Lücke zu schließen,
        // müssen die Fahrzeuge,
        // die sich hinter dem LKW,
        // der den Platoon verlassen hat,
        // befinden,
        // um 4 km/h für 20 Sekunden
        // ihre Geschwingkeit erhöhen,
        // damit die Lücke geschlossen und der Abstand von 15 Meter behalten wird

        //Berechnung der Geschwindigkeit:
        //Geschwindigkeit = Strecke/Zeit (v= s/t)

        // v = 33 Meter / 20 => v = 1,25 m/s => v = (int) 4.5 km/s

        //TODO

        
    }

    public void adjustSpeed(){

        //TODO

    }
}
