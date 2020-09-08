import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3305/skillbox?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "MihaIce_260196";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select distinct subscriptions.course_id, courses.name, \n" +
                            "(select count(*) from subscriptions \n" +
                            "where subscriptions.course_id = courses.id and YEAR(subscriptions.subscription_date) = 2018) as count_course,\n" +
                            "(select MAX(MONTH(subscriptions.subscription_date))  from subscriptions \n" +
                            "where subscriptions.course_id = courses.id and YEAR(subscriptions.subscription_date) = 2018) as month \n" +
                            "from subscriptions\n" +
                            "join courses on courses.id = subscriptions.course_id\n" +
                            "order by  courses.id");
            while (resultSet.next()) {
                Courses courses = new Courses();
                String courseID = resultSet.getString("course_id");
                courses.setCourseId(courseID);
                String courseName = resultSet.getString("name");
                courses.setCourseName(courseName);
                String courseCount = resultSet.getString("count_course");
                courses.setCourseCount(courseCount);
                String courseMonthNumMax = resultSet.getString("month");
                courses.setCourseMaxMonthAll(courseMonthNumMax);


                System.out.println("Id: " + courseID + " Name: " + courseName + " Course count: " + courseCount
                        + " Last month purchase: " + courseMonthNumMax + " Average monthly purchases: " + String.format("%.3f", courses.averageNumberOfPurchasesPerMonth()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
