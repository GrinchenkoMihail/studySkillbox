import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WorkWithJSON {
    private String pathToFile;
    private JSONObject jsonObject;
    private Writer out;

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void setOut(Writer out) {
        this.out = out;
    }

    public List<LineMetroMsc> getLinesWithStations() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

        JSONArray linesArray = (JSONArray) jsonData.get("lines");
        List<LineMetroMsc> lines = parseLine(linesArray);

        JSONObject stationsObject = (JSONObject) jsonData.get("stations");
        List<LineMetroMsc> linesWithStations = parseStation(stationsObject, lines);
        return linesWithStations;
    }

    private String getJsonFile() {
        final StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathToFile));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    private List<LineMetroMsc> parseLine(JSONArray linesArray) {
        List<LineMetroMsc> lineMetroMscList = new ArrayList<>();
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            LineMetroMsc lineMetroMsc = new LineMetroMsc();
            lineMetroMsc.setNumLine(lineJsonObject.get("number").toString());
            lineMetroMsc.setNameLine(lineJsonObject.get("name").toString());
            lineMetroMscList.add(lineMetroMsc);
        });
        return lineMetroMscList;
    }

    private List<LineMetroMsc> parseStation(JSONObject stationsObject, List<LineMetroMsc> lineMetroMscList) {
        stationsObject.keySet().forEach(line -> {
            String strNumLine = line.toString();
            List<String> stationList = new ArrayList<>();
            JSONArray stationArray = (JSONArray) stationsObject.get(strNumLine);
            stationArray.forEach(station -> {
                stationList.add(station.toString());
            });
            for (LineMetroMsc lineMetro : lineMetroMscList) {
                if (lineMetro.getNumLine().equals(strNumLine)) {
                    lineMetro.setStation(stationList);
                }
            }
        });
        return lineMetroMscList;
    }

    public void writeJsonStrInJsonFile(String jsonResponse) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        jsonObject = (JSONObject) parser.parse(jsonResponse);
        jsonObject.writeJSONString(out);
        out.flush();
    }
}
