package hibernate_one_to_one.test;

import hibernate_one_to_one.entiti.Detail;
import hibernate_one_to_one.entiti.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
try {


//Employee employee=new Employee("Zaur", "Tregulov","IT",500);
//Detail detail=new Detail("Baku","123456789","zaurtregulov@gmail.ru");
//employee.setEmpDetail(detail);
//    session.beginTransaction();
//    session.save(employee);
//    session.getTransaction().commit();
//    System.out.println("Done");


//    Employee employee=new Employee("Oleg", "Smirnov","Sales",700);
//    Detail detail=new Detail("Moscow","415767515","olehsv@gmail.ru");
//    employee.setEmpDetail(detail);
//    session.beginTransaction();
//    session.save(employee);
//    session.getTransaction().commit();
//    System.out.println("Done");


    session.beginTransaction();
    Employee epm=session.get(Employee.class, 2);
    session.delete(epm);
    session.getTransaction().commit();
    System.out.println("Done");

}
finally {
    session.close();
    factory.close();
}
}
}


