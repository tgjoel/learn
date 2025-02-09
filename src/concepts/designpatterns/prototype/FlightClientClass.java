package concepts.designpatterns.prototype;

import java.util.List;

public class FlightClientClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        FlightClass flightClass = new FlightClass();
        flightClass.loadDefaultFlightList();

        FlightClass morningFlights = (FlightClass) flightClass.clone();
        List<String> morningFlightList = morningFlights.getDefaultFlightList();
        morningFlightList.add("SpiceJet");
        morningFlightList.add("Vistara");

        FlightClass nightFlights = (FlightClass) flightClass.clone();
        List<String> nightFlightsList = nightFlights.getDefaultFlightList();
        nightFlightsList.remove("Indian Airways");
        nightFlightsList.remove("Indigo");

        System.out.print("Default flights list: ");
        System.out.println(flightClass.getDefaultFlightList());

        System.out.print("Morning flights: ");
        System.out.println(morningFlights.getDefaultFlightList());

        System.out.print("Night flights: ");
        System.out.println(nightFlights.getDefaultFlightList());

    }
}
