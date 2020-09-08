import java.io.File;
import java.io.IOException;

import java.util.Scanner;

public class Main {
    static final int POW = 1024;
    public static void main(String[] args)  {

        FileSizeCalculation fileSizeCalculation = new FileSizeCalculation();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //TODO получать через консоль путь от пользователя до папки;
            System.out.println("Введите путь к папке");

            String thePathToTheFolder = scanner.nextLine();
            File folder = new File(thePathToTheFolder);

            //TODO суммировать размер файлов папки и вложенных папок;
            long size = 0;
            try {
                size = fileSizeCalculation.getSumOfFilesSize(folder);
                //TODO выводить полученную сумму файлов в удобочитаемом виде — в байтах, килобайтах, мегабайтах или гигабайтах;
                System.out.println(formatOutputSize(size));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String formatOutputSize(long size) {
        String answer = null;
        double[] sizeArr = new double[4];
        String[] sizeArrName = new String[]{" B", " KB", " MB", " Gb"};
        for (int i = 1; i <= sizeArrName.length; i++) {
            if (size < Math.pow(POW, i)) {
                answer = String.format("%.2f", size / Math.pow(POW, i - 1)) + sizeArrName[i - 1];
                break;
            }
        }
        return answer;
    }
//        sizeArr[0] =  size; //Byte
//        sizeArr[1] = size / POW;//Kb
//        sizeArr[2] = sizeArr[1] / POW;//Mb
//        sizeArr[3] = sizeArr[2] / POW;//Gb
//        for (int i = 0; i < sizeArr.length; i++) {
//            if((long)sizeArr[i]==0) {
//                System.out.println(String.format("%.2f", sizeArr[i-1]) + sizeArrName[i-1]);
//                break;
//            }else if(i==3){
//                System.out.println(String.format("%.2f", sizeArr[i]) + sizeArrName[i]);
//            }


    //TODO программа должна перехватывать все исключения, возникающие при ошибках чтения файлов и папок, и выводить сообщение об ошибке с трассировкой стека (stack trace).
}
