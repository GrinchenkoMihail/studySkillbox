import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final int NEW_WIDTH = 300;
    static final String SRC_FOLDER = "src\\srcFolder";
    static final String DST_FOLDER = "src\\dstFolder";
    static final String DST_FOLDER_WITHOUT_LOSING_QUALITY = "src\\dsrFolderWithoutLosingQuality";
    static int countCPU = Runtime.getRuntime().availableProcessors();

    static File[] files;

    public static void main(String[] args) throws InterruptedException {

        File srcDir = new File(SRC_FOLDER);
        files = srcDir.listFiles();
        int quarter = getQuarter(files);
        long start = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < countCPU; i++) {
            Thread thread = new Thread(workThreadWithoutLosingQuality(quarter, start, quarter * i, 0));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Ресайз завершен");
    }

    static int getQuarter(File[] files) {
        //у меня 4 ядерный, поэтому именно такие условия для того, чтобы равномерно распределить файлы на каждое ядро
        int quarter = files.length / countCPU;
        if (quarter * countCPU != files.length) {
            quarter++;
        }
        return quarter;
    }

    static Thread workThread(int quarter, long start, int srcPos, int desPos) {
        File[] files1 = copyArrFiles(quarter, srcPos, desPos);
        ImageResizer imageResizer1 = new ImageResizer(files1, NEW_WIDTH, DST_FOLDER, start);
        return new Thread(imageResizer1);
    }

    static Thread workThreadWithoutLosingQuality(int quarter, long start, int srcPos, int desPos) {
        File[] files1 = copyArrFiles(quarter, srcPos, desPos);
        ReduceTheImageWithoutLosingQuality reduceTheImageWithoutLosingQuality
                = new ReduceTheImageWithoutLosingQuality(files1, NEW_WIDTH, DST_FOLDER_WITHOUT_LOSING_QUALITY, start);
        return new Thread(reduceTheImageWithoutLosingQuality);
    }

    static private File[] copyArrFiles(int quarter, int srcPos, int desPos) {
        File[] files1;
        int quarterSmall = files.length - srcPos;
        if (quarterSmall < quarter) {
            files1 = new File[quarterSmall];
            System.arraycopy(files, srcPos, files1, desPos, quarterSmall);
        } else {
            files1 = new File[quarter];
            System.arraycopy(files, srcPos, files1, desPos, quarter);
        }
        return files1;
    }

}
