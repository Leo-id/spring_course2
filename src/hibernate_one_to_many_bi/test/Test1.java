package hibernate_one_to_many_bi.test;

import hibernate_one_to_many_bi.entiti.Department;
import hibernate_one_to_many_bi.entiti.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.jar.JarOutputStream;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session=null;
try {
    session=factory.getCurrentSession();

//Department dep=new Department("Sales", 800, 1500);
//Employee emp1=new Employee("Zaur", "Tregulov", 800);
//    Employee emp2=new Employee("Elena", "Sidorova", 1500);
//    Employee emp3=new Employee("Anton", "Smirnov", 1200);
////    Employee emp4=new Employee("Anton", "Smirnov", 1200);
//    dep.addEmploteeToDepartment(emp1);
//    dep.addEmploteeToDepartment(emp2);
//    dep.addEmploteeToDepartment(emp3);
////    dep.addEmploteeToDepartment(emp4);
//
//    session.beginTransaction();
//    session.save(dep);
//
//    session.getTransaction().commit();
//    System.out.println("Done");


    session.beginTransaction();
    System.out.println("Get department");
  Department department=session.get(Department.class, 3);

    System.out.println("Show department");
    System.out.println(department);


    System.out.println("Подгрузка");
    department.getEmps().get(0);

    session.getTransaction().commit();

    System.out.println("Show employee of the department");
    System.out.println(department.getEmps());
    System.out.println("Done!");



//
//    session.getTransaction().commit();
//    System.out.println("Show employees of the department");
//    System.out.println(department.getEmps());
//    System.out.println("Done");

//    session.beginTransaction();
//    Employee employee=session.get(Employee.class, 1);
//    System.out.println(employee);
//    System.out.println(employee.getDepartment());
//    session.getTransaction().commit();
//    System.out.println("Done");


//    session.beginTransaction();
//    Employee employee=session.get(Employee.class, 3);
//    session.delete(employee);
//    session.getTransaction().commit();
//    System.out.println("Done

}
finally {
    session.close();
    factory.close();
}
}
}


