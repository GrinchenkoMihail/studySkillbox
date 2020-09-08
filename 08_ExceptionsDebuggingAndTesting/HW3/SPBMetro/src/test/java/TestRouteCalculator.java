import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

public class TestRouteCalculator extends TestCase {

    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator;

    List<Station> route;


    @Override
    protected void setUp() throws Exception {

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(1, "Первая")); // Line line1 = new Line(1, "Первая");
        lines.add(new Line(2, "Вторая")); //  Line line2 = new Line(2, "Вторая");
        lines.add(new Line(3, "Третья")); //  Line line2 = new Line(2, "Вторая");


        route = new ArrayList<>();
        route.add(new Station("Петровкая", lines.get(0)));
        route.add(new Station("Выборгская", lines.get(0)));
        route.add(new Station("Колмогорская", lines.get(0)));
        route.add(new Station("Международная", lines.get(1)));
        route.add(new Station("Столичная", lines.get(1)));
        route.add(new Station("Пересалочная", lines.get(2)));
        route.add(new Station("Конечная", lines.get(2)));

        List<Station> connectionListFirstAndSecondLines = new ArrayList<>();
        connectionListFirstAndSecondLines.add(route.get(2));
        connectionListFirstAndSecondLines.add(route.get(3));

        List<Station> connectionListSecondAndThirdLines = new ArrayList<>();
        connectionListSecondAndThirdLines.add(route.get(4));
        connectionListSecondAndThirdLines.add(route.get(5));


        route.stream().forEach(x -> stationIndex.addStation(x));
        lines.stream().forEach(x -> stationIndex.addLine(x));
        stationIndex.addConnection(connectionListFirstAndSecondLines);
        stationIndex.addConnection(connectionListSecondAndThirdLines);

        lines.get(0).addStation(route.get(0));
        lines.get(0).addStation(route.get(1));
        lines.get(0).addStation(route.get(2));
        lines.get(1).addStation(route.get(3));
        lines.get(1).addStation(route.get(4));
        lines.get(2).addStation(route.get(5));
        lines.get(2).addStation(route.get(6));


        routeCalculator = new RouteCalculator(stationIndex);
    }


    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 17;
        assertEquals(expected, actual);
    }


    //TODO расстояние до той же станции
    public void testDistanceToSameStation() {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(0));
        List<Station> expected = new ArrayList<>();
        expected.add(route.get(0));
        Assert.assertEquals(expected, actual);
    }

    //TODO станции рядом друг с другом на одной линии ()
    public void testStationsNextToEachOtherOnSingleLine() {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(1));
        List<Station> expected = new ArrayList<>();
        expected.add(route.get(0));
        expected.add(route.get(1));
        Assert.assertEquals(expected, actual);
    }

    //TODO противоположные станции на одной линии
    public void testOppositeStationsOnSingleLine() {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(2));
        List<Station> expected = new ArrayList<>();
        expected.add(route.get(0));
        expected.add(route.get(1));
        expected.add(route.get(2));
        Assert.assertEquals(expected, actual);
    }

    //TODO противоположные станции с одной пересадкой
    public void testOppositeStationsWithOneTransfer() {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(4));
        List<Station> expected = new ArrayList<>();
        expected.add(route.get(0));
        expected.add(route.get(1));
        expected.add(route.get(2));
        expected.add(route.get(3));
        expected.add(route.get(4));
        Assert.assertEquals(expected, actual);
    }

    //TODO противоположные станции с двумя пересадками
    public void testOppositeStationsWithTwoTransfers() {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(6));
        List<Station> expected = route;
        Assert.assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
