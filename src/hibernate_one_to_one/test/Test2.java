package hibernate_one_to_one.test;

import hibernate_one_to_one.entiti.Detail;
import hibernate_one_to_one.entiti.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session=null;
try {

    session=factory.getCurrentSession();


//Employee employee=new Employee("Sergey", "Ivanov","HR",850);
//Detail detail=new Detail("York","464646","nikolay@gmail.ru");
//
//employee.setEmpDetail(detail);
//detail.setEmployee(employee);
//    session.beginTransaction();
//    session.save(detail);
//    session.getTransaction().commit();
//    System.out.println("Done");


    session.beginTransaction();
  Detail detail=session.get(Detail.class,4);

//    System.out.print(detail.getEmployee());
  detail.getEmployee().setEmpDetail(null);   // разрыв связи детали - работник
    session.delete(detail);

    session.getTransaction().commit();
    System.out.println("Done");



}
finally {
    session.close();
    factory.close();
}
}
}


