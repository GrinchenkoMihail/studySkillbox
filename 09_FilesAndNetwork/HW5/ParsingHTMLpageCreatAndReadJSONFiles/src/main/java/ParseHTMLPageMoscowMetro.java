import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class ParseHTMLPageMoscowMetro {
    private Elements elements;

    public ParseHTMLPageMoscowMetro(Document doc) throws IOException {
        elements = doc.select("div.t-text-simple");
    }

    public List<Line> parseLineForGson() {
        List<Line> lineArrayList = new ArrayList<>();
        Elements elementsLine = elements.select("div.js-toggle-depend");
        for (Element element : elementsLine) {
            String numLine = element.select("span.js-metro-line").attr("data-line");
            String nameLine = element.select("span").text();
            lineArrayList.add(new Line(numLine, nameLine));
        }
        return lineArrayList;
    }

    public Map<String, List<String>> parseStation() {
        Map<String, List<String>> station = new TreeMap<>();
        Elements elementsStation = elements.select("div.js-metro-stations");
        String str = "";
        for (Element element : elementsStation) {
            if (!str.equals(element.attr("data-line"))) {
                str = element.attr("data-line");
            }
            Elements elementsNumAndNameStation = element.select("a");
            List stationArrList = new ArrayList<String>();
            for (Element element1 : elementsNumAndNameStation) {
                String numStr = element1.select("span.num").text();
                String nameStr = element1.select("span.name").text();
                stationArrList.add(numStr + nameStr);
            }
            station.put(str, stationArrList);
        }
        return station;
    }
}
