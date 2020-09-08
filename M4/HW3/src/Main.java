import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int boxesKol = scan.nextInt();
        //int boxesKol = 24;
        int container = 1;
        int box = 0;
        int maxBoxInContainer = 27;
        int maxContainerInTruck = 12;
        int allTrucks = 1;
        int allContainer = 1;
//        for (int truck = 1; box <= boxesKol && box != boxesKol; truck++) {
//            allTrucks++;
//
//            System.out.println("Грузовик " + truck + ":");
//            for (container = 1; container <= 12 && box != boxesKol; container++) {
//                allContainer++;
//
//                System.out.println("\tКонтейнер " + container + ":");
//                for (int loadBox = 0; loadBox < 27 && box != boxesKol; ) {
//                    loadBox++;
//                    box++;
//                    System.out.println("\t\tЯщик " + box);
//
//                }
//            }
//        }
        for (box = 1; box <= boxesKol; box++) {
            if (box % maxBoxInContainer == 0 && container <= maxContainerInTruck) {
                System.out.format("Грузовик: %s Контейнер: %s Ящик: %s \n", allTrucks, container, box);
                container++;
                allContainer++;
            } else if (container > maxContainerInTruck) {
                container = 1;
                allTrucks++;
                System.out.format("Грузовик: %s Контейнер: %s Ящик: %s \n", allTrucks, container, box);
            } else {
                System.out.format("Грузовик: %s Контейнер: %s Ящик: %s \n", allTrucks, container, box);
            }
        }
        if ((allContainer - 1) * maxBoxInContainer == box - 1) {
            allContainer--;
        }
        System.out.println("Всего грузовиков: " + allTrucks);
        System.out.println("Всего контейнеров: " + allContainer);
    }
}











