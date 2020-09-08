import TableObjects.CompositeId;
import TableObjects.Course;
import TableObjects.Student;
import TableObjects.Subscription;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

import static org.hibernate.id.PersistentIdentifierGenerator.PK;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Course course = session.get(Course.class,3);
        System.out.println("Name course: " + course.getName() + "\nStudents count: " + course.getStudentsCount());
        System.out.println(course.getTeacher().getName());
        System.out.println(course.getStudents().size());

        Subscription subscription =session.get(Subscription.class,new CompositeId(1,2) );
        System.out.println(subscription.getStudent().getName() + " --> " + subscription.getCourse().getName());


      //  System.out.println(subscription.getCourse());

//        Student student = session.get(Student.class,1);
//        System.out.println(student.getSubscriptions().size());
//        List<Subscription> subscriptions = student.getSubscriptions();
//
//        for(Subscription ss: subscriptions){
//            System.out.println(ss.getCourseId());
//        }


        transaction.commit();
        sessionFactory.close();
    }
}
