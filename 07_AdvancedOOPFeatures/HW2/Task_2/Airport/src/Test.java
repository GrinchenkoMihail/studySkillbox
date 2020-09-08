import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;


import java.util.*;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR, -2);

        Date timeRangFirst = calendar.getTime();
        Date timeRangeSecond = new Date();

        Airport airport = Airport.getInstance();


//        airport.getTerminals().forEach(terminal -> {
//            List<Flight> flights = terminal.getFlights();
//
//            flights.stream()
//                    .filter(flight -> flight.getDate().after(timeRangFirst))
//                    .filter(flight -> flight.getDate().before(timeRangeSecond))
//                    .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
//                    .sorted(Comparator.comparing(Flight::getDate))
//                    .forEach(flight -> {
//                System.out.println("Terminal " + terminal.getName() + " " + flight.toString() + " " + flight.getAircraft().getModel());
//            });
//        });
        airport.getTerminals().stream().flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getDate().after(timeRangFirst))
                .filter(flight -> flight.getDate().before(timeRangeSecond))
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .sorted(Comparator.comparing(Flight::getDate))
                .forEach(flight -> {
                    System.out.println(flight.toString() + " " + flight.getAircraft().getModel());
                });
    }

}


