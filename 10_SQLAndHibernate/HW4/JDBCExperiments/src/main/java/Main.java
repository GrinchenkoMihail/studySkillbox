import TableObjects.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query.from(PurchaseList.class);
        query.select(root);

        List<PurchaseList> listPurchaseObject = session.createQuery(query).getResultList();
        saveNewDataPurchaseList(listPurchaseObject, session);

//Ниже выполняется для проверки свзи ManyToMany у студента с курсами через subscription
        CriteriaQuery<Student> queryStu = builder.createQuery(Student.class);
        Root<Student> rootStu = queryStu.from(Student.class);
        queryStu.select(rootStu);
        List<Student> studentList = session.createQuery(queryStu).getResultList();
        System.out.println(studentList.get(0).getCourses().get(0).getName());

        transaction.commit();
        sessionFactory.close();
    }

    public static void saveNewDataPurchaseList(List<PurchaseList> list, Session session) {
        list.forEach(purchaseList -> {
            String studentHql = "From " + Student.class.getSimpleName() + " WHERE name = '" + purchaseList.getKey().getStudentName() + "'";
            String courseHql = "From " + Course.class.getSimpleName() + " WHERE name = '" + purchaseList.getKey().getCourseName() + "'";

            Student student = (Student) session.createQuery(studentHql).getSingleResult();
            Course course = (Course) session.createQuery(courseHql).getSingleResult();

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setId(new LinkedPurchaseListId(student.getId(), course.getId()));
            linkedPurchaseList.setPrice(purchaseList.getPrice());
            linkedPurchaseList.setSubscriprionDate(purchaseList.getSubscriptionDate());
            session.save(linkedPurchaseList);
        });

    }
}
