package com.nen.controller;

import com.nen.model.Student;
import com.nen.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestHomeController {

    private StudentService ss;

    public StudentService getSs() {
        return ss;
    }

    @Autowired
    public void setSs(StudentService ss) {
    System.out.println("I am in resthomecontroller setting studentservice -------------");
        this.ss = ss;
    }

//    getting single student
    @GetMapping(value = "/student/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Student> getStudentPage(@PathVariable("id") Integer studentId, Model model) {

        try{
            Student student = getSs().serviceGetStudent(studentId);

            return new ResponseEntity(student, HttpStatus.OK);

        }catch (Exception e){
            System.out.println("Get mapping exception --------" + e);
            e.printStackTrace();

            return new ResponseEntity(e, HttpStatus.NO_CONTENT);
        }

    }

//    getting list of all students
    @GetMapping(value = "/getAllStudents", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Student>> allStudentsPage(Model model){

        try{
            List<Student> studentList = getSs().serviceGetAllStudents();

            return new ResponseEntity(studentList, HttpStatus.OK);

        }catch (Exception e){
            System.out.println("Get mapping exception --------" + e);
            e.printStackTrace();

            return new ResponseEntity(e, HttpStatus.NO_CONTENT);
        }

    }

//    creating a new student
    @PostMapping(path = "/createStudent",consumes = {MediaType.APPLICATION_JSON_VALUE } ,produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity registerPage(@Valid @RequestBody Student student, BindingResult br, Model model){

        try{
            this.getSs().serviceSaveStudent(student);
            ResponseEntity<Student> responseEntity = new ResponseEntity(student, HttpStatus.CREATED);
            System.out.println("This is the body of post request api/createStudent try block ----------" + responseEntity.getBody() + "  response entity ------" + responseEntity);

            return responseEntity;

        }catch (Exception e){
            System.out.println("Post mapping exception raised -----" + e);
            e.printStackTrace();
            ResponseEntity responseEntity = new ResponseEntity(e, HttpStatus.FORBIDDEN);

            return responseEntity;
        }

    }

//    updating an existing student
    @PutMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateStudentPage(@Valid @RequestBody Student student, BindingResult br, Model model){

        System.out.println("Student in put mapping : --------------" + student );
        if(br.hasErrors()){

            List<FieldError> errorsList = br.getFieldErrors();
            System.out.println(errorsList);

            ResponseEntity<List<FieldError>> responseEntity = new ResponseEntity(errorsList, HttpStatus.FORBIDDEN);
            System.out.println("api/update if This is update error list by responseentity.getbody() --------------------" + responseEntity.getBody() + " error list bro-----   " + errorsList);

            return responseEntity;
        }else{

            System.out.println("The saving method is called from api/update else -------------");
            getSs().serviceUpdateStudent(student);
            ResponseEntity<Student> responseEntity = new ResponseEntity(student, HttpStatus.OK);
            System.out.println("api/update else This is update error list by responseentity.getbody() --------------------" + responseEntity.getBody() + " reponseEntity bro-----   " + responseEntity);

            return responseEntity;
        }

    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteStudent(@PathVariable("id") Integer studentId){

        try{
            getSs().serviceDeleteStudent(studentId);

            return new ResponseEntity("From ResponseEntity Student deleted successfully with id " + String.valueOf(studentId), HttpStatus.OK);

        }catch (Exception e){

            System.out.println("Delete mapping exception --------" + e);
            e.printStackTrace();

            return new ResponseEntity(e, HttpStatus.NO_CONTENT);
        }

    }

}
