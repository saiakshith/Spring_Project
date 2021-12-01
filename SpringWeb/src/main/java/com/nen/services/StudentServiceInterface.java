package com.nen.services;

import com.nen.model.Student;

import java.util.List;

public interface StudentServiceInterface {

    void serviceSaveStudent(Student student);

    Student serviceGetStudent(Integer studentId);

    List<Student> serviceGetAllStudents();

    void serviceUpdateStudent(Student student);

    void serviceDeleteStudent(Integer studentId);
}
