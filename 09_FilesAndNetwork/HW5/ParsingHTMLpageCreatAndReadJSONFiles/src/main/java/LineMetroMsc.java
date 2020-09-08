import java.util.List;

public class LineMetroMsc {
    private List<String> station;
    private String numLine;
    private String nameLine;

    public int quantityOfStations() {
        return station.size();
    }

    public List<String> getStation() {
        return station;
    }

    public void setStation(List<String> station) {
        this.station = station;
    }

    public String getNumLine() {
        return numLine;
    }

    public void setNumLine(String numLine) {
        this.numLine = numLine;
    }

    public String getNameLine() {
        return nameLine;
    }

    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }
}
