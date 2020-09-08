public class Courses {
    private String courseId;
    private String courseName;
    private int courseCount;
    private int courseMaxMonthAll;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(String courseCount) {
        this.courseCount = Integer.parseInt(courseCount);
    }

    public int getCourseMaxMonthAll() {
        return courseMaxMonthAll;
    }

    public void setCourseMaxMonthAll(String courseMaxMonthAll) {
        this.courseMaxMonthAll = Integer.parseInt(courseMaxMonthAll);
    }
    public double averageNumberOfPurchasesPerMonth(){
        return    (double)courseCount/courseMaxMonthAll;
}
}
