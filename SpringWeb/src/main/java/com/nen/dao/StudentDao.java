package com.nen.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import javax.transaction.Transactional;
import javax.validation.constraints.AssertFalse;
import java.io.Serializable;

import org.hibernate.Session;
import com.nen.model.Student;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import java.util.List;

//@ComponentScan(basePackages = "com.nen")
@Component
public class StudentDao {

/*    private SessionFactory sf;

    public SessionFactory getSf() {
        return sf;
    }

    public void setSf(SessionFactory sf) {
    System.out.println("The Session Factory is being set ---------------- in setSf");
        this.sf = new Configuration().configure().buildSessionFactory();
    }*/

    public StudentDao() {
    }

    //        save or create student
    public void saveStudent(Student student){

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Before saving the obj by session ---------------------");
        session.persist(student);
        tx.commit();


    }
//        get single student by id
    public Student getStudent(Integer studentId){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, studentId);
//        session.get
        tx.commit();

        return student;
    }
//        get all students
    public List<Student> getAllStudents(){
        System.out.println("getting all the students --------------------");
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Student> studentsList = session.createQuery("from Student", Student.class).list();
        tx.commit();
        return studentsList;
    }
//        update student
    public void updateStudent(Student student){
        System.out.println("updating student --------------------");
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Student is updating ---------------");
//        session.createQuery("update Student set age= :student.age, country= :student.country, email= :student.email, gender= :student.gender, password= student.password, username= :student.username where student_id= :id");
        session.update(student);
        tx.commit();

    }
//        delete student
    public void deleteStudent(Integer studentId){

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = this.getStudent(studentId);
        System.out.println("Student is deleting ---------------" + student + "-- " + studentId);
        session.delete(student);
        tx.commit();

    }

}
