package com.nen.services;

import com.nen.model.Student;
import com.nen.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    private StudentDao sd;

    public StudentDao getSd() {
        return sd;
    }

    @Autowired
    public void setSd(com.nen.dao.StudentDao sd) {
    System.out.println("I am from student service setting sutudent dao ---------------");
        this.sd = sd;
    }

    public void serviceSaveStudent(Student student){
        sd.saveStudent(student);
    }

    public Student serviceGetStudent(Integer studentId){

        return sd.getStudent(studentId);
    }

    public List<Student> serviceGetAllStudents(){

       return sd.getAllStudents();
    }

    public void serviceUpdateStudent(Student student){
        sd.updateStudent(student);
    }

    public void serviceDeleteStudent(Integer studentId){
        sd.deleteStudent(studentId);
    }


}
