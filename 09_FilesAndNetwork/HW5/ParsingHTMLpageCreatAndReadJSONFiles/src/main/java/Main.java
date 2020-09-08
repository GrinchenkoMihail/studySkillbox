import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String STR_URL = "https://www.moscowmap.ru/metro.html#lines";
    public static final String PATH_TO_FILE = "data/map.json";

    public static void main(String[] args) throws IOException, ParseException {

        Document doc = Jsoup.connect(STR_URL).get();
        ParseHTMLPageMoscowMetro parseHTMLPageMoscowMetro = new ParseHTMLPageMoscowMetro(doc);

        WorkWithJSON workWithJSON = beforeStartWorkWithJson(PATH_TO_FILE);
        Map station = parseHTMLPageMoscowMetro.parseStation();
        List line = parseHTMLPageMoscowMetro.parseLineForGson();

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setLines(line);
        jsonResponse.setStations(station);
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(jsonResponse);

        workWithJSON.writeJsonStrInJsonFile(json);

        try {
            workWithJSON.getLinesWithStations().stream().forEach(x -> {
                System.out.println(x.getNumLine() + " линия\n" + x.getNameLine() + ". Всего станций: " + x.quantityOfStations());
            });
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static WorkWithJSON beforeStartWorkWithJson(String path) throws IOException {
        WorkWithJSON workWithJSON = null;
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            workWithJSON = new WorkWithJSON();
            workWithJSON.setOut(new FileWriter(file));
            workWithJSON.setJsonObject(new JSONObject());
            workWithJSON.setPathToFile(path);
        }
        return workWithJSON;
    }
}




