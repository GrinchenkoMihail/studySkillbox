public class Main {

    public static void vivod(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i) + ": " + (int) str.charAt(i));
        }
    }
    public static void main(String[] args) {
        String strENG = "abcdifghijklmnopqrstuvwxyzABCDIFGHIJKLMNOPQRSTUVWXYZ";
        String strRUS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        vivod(strENG);
        vivod(strRUS);
    }
}
