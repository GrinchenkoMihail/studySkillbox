package TableObjects;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    private CompositeId id;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Student getStudent() {
        return student;
    }

    public void setStudentId(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}

//@Embeddable
//public static class CompositeId implements Serializable {
//
//    @Column(name = "course_id")
//    private int courseId;
//
//    @Column(name = "student_id")
//    private int studentId;
//
//    public CompositeId() {
//    }
//
//    public CompositeId(int student, int courseId) {
//        this.studentId = student;
//        this.courseId = courseId;
//    }
//
//    public int getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(int courseId) {
//        this.courseId = courseId;
//    }
//
//    public int getStudent() {
//        return studentId;
//    }
//
//    public void setStudent(int studentId) {
//        this.studentId = studentId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CompositeId that = (CompositeId) o;
//        return courseId == that.courseId &&
//                studentId == that.studentId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(courseId, studentId);
//    }
//}


