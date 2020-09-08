import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String nameInFile = "engText.txt";
        String workDir = System.getProperty("user.dir");
        File fileIn = new File(workDir, nameInFile);
        String fullFileInName = fileIn.getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(fullFileInName));
        String str = br.readLine();
        while (str != null) {
            //str=str.replaceAll("\\p{Punct}",""); /
            // ^
            // |
            // |
            // Можно раскомментировать эту строку,а в цикле for оставить только System.out.println(i);
            //Или оставить как есть. Работает одинаково. Но какой более правильный и менее ресурсно затратный
            // ¯\_(ツ)_/¯

            String[] arrStr = str.split("\\s+");
            for (String i :arrStr) {
                System.out.println(i.replaceAll("\\p{Punct}",""));
            }
            str = br.readLine();
        }
    }
}