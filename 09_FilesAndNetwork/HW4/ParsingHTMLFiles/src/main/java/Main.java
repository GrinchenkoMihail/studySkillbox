import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final Marker SAVED_IMAGES = MarkerManager.getMarker("SAVED_IMAGES");
    private static final String PATH_LENTA = "https://lenta.ru/";
    private static final String IMAGE_DESTINATION_FOLDER = "data/images";

    public static void main(String[] args) throws IOException {
        List<String> imageListURL = parsePathImage(PATH_LENTA);
        downloadImage(imageListURL);
    }

    public static void downloadImage(List<String> strImageURL) throws MalformedURLException {
        System.out.println("Скачивание изображения с " + PATH_LENTA);
        for (String str : strImageURL) {
            String strImageName = str.substring(str.lastIndexOf("/"));
            URL urlImage = new URL(str);
            try (InputStream inputStream = urlImage.openStream()) {
                File file = new File(IMAGE_DESTINATION_FOLDER);
                if (!file.exists()) {
                    file.mkdir();
                }
                Files.copy(inputStream, new File(IMAGE_DESTINATION_FOLDER + strImageName).toPath());
                LOGGER.info(SAVED_IMAGES, "Saving: " + strImageName + " from: " + str + "\nImage saving");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Скачивание завершено");
    }

    public static List<String> parsePathImage(String strURL) throws IOException {
        List<String> imageURL = new ArrayList<String>();
        Document doc = Jsoup.connect(strURL).get();
        Elements elements = doc.body().select("img");
        for (Element element : elements) {
            imageURL.add(element.attr("src"));
        }
        return imageURL;
    }
}
