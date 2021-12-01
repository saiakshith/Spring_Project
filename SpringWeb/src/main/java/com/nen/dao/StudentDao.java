package com.nen.dao;

import org.hibernate.Session;
import com.nen.model.Student;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StudentDao {

//    private Session session = new Configuration().configure().buildSessionFactory().openSession();

    public StudentDao() {
    }

    public void saveStudent(Student student){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
    }

  public Student getStudent(Integer studentId) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Student student = session.get(Student.class, studentId);
        return student;
    }

    public List<Student> getAllStudents(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        List<Student> studentsList = session.createQuery("from Student", Student.class).list();
        return studentsList;
    }

    public void updateStudent(Student student){
        Session updateSession = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = updateSession.beginTransaction();
        updateSession.update(student);
        tx.commit();
    }

    public void deleteStudent(Integer studentId){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = this.getStudent(studentId);
        session.delete(student);
        tx.commit();
    }

}
