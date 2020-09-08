import tasks.*;

import java.util.*;

class Main {
    public static void main(String[] args) {
        int diaposon =6;
        Task1_Basic task1_basic = new Task1_Basic();
        Task2_IntStream task2_intStream = new Task2_IntStream();
        Task3_GroupBy task3_groupBy = new Task3_GroupBy();
        Task4_Exam task4_exam = new Task4_Exam();

        System.out.println("Please use tests to run the program");

        String company = "Google";

        Collection<Integer> collection = new ArrayList<>();
        List<Integer> arrList  = new ArrayList<>();
        int[] arrInt = new int[5];

        List<Task3_GroupBy.Employee> employeeList = new ArrayList<>();
        employeeList.add(new Task3_GroupBy.Employee("Serg","Google"));
        employeeList.add(new Task3_GroupBy.Employee("Lena","Microsoft"));
        employeeList.add(new Task3_GroupBy.Employee("Max","Epam"));
        employeeList.add(new Task3_GroupBy.Employee("Nikita","Google"));

        List<Task4_Exam.Truck> truckList = new ArrayList<>();
        truckList.add(new Task4_Exam.Truck(2000));
        truckList.add(new Task4_Exam.Truck(2500));
        truckList.add(new Task4_Exam.Truck(4500));
        truckList.add(new Task4_Exam.Truck(15000));

        for(int i =1;i<diaposon;i++)
        {
            arrInt[i-1] =i+1;
            arrList.add(i);
            collection.add(i);
        }



        //TODO Task_1
        System.out.println(task1_basic.countEven(collection));
        System.out.println(task1_basic.countLowercaseLetters("ВОтШЩлдорО"));
        System.out.println(task1_basic.replaceWordsOnLength("Один два три четрые"));

        //TODO Task_2
        System.out.println(task2_intStream.multiply(arrList));
        System.out.println(task2_intStream.findAverage(arrInt));

        //TODO Task_3
        System.out.println(company + ": ");
        task3_groupBy.groupByCompaniesAsList(employeeList).get(company).stream().forEach(x->{
            System.out.print(x.getName() + ", ");
        });

        System.out.println("\n"+company.toUpperCase() + ": ");
        task3_groupBy.groupByCompaniesAsListUppercase(employeeList).get(company.toUpperCase()).stream().forEach(x->{
            System.out.print(x.getName()+ ", ");
        });

        System.out.print("\nEpam: ");
       task3_groupBy.groupByCompaniesAsSet(employeeList).get("Epam").stream().forEach(x->{
           System.out.print(x.getName());
       });
        System.out.print("\nMicrosoft: ");
       task3_groupBy.groupByCompaniesAsString(employeeList).get("Microsoft").stream().forEach(System.out::println);

       //TODO Task_4
        try {
            System.out.println(task4_exam.getTypeByWeight(1000));
            task4_exam.groupTrucksByType(truckList);
            task4_exam.countTrucksByType(truckList);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
