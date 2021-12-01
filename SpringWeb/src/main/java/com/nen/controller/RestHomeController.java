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
        this.ss = ss;
    }

    @GetMapping(value = "/student/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Student> getStudentPage(@PathVariable("id") Integer studentId, Model model) {

        try{
            Student student = getSs().serviceGetStudent(studentId);
            return new ResponseEntity(student, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e, HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping(value = "/getAllStudents", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Student>> allStudentsPage(Model model){

        try{
            List<Student> studentList = getSs().serviceGetAllStudents();
            return new ResponseEntity(studentList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e, HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(path = "/createStudent",consumes = {MediaType.APPLICATION_JSON_VALUE } ,produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity registerPage(@Valid @RequestBody Student student, BindingResult br, Model model){

        if(br.hasErrors()){
            ResponseEntity responseEntity = new ResponseEntity(br.getFieldErrors(), HttpStatus.FORBIDDEN);
            return responseEntity;
        }else {
            try{
                this.getSs().serviceSaveStudent(student);
                ResponseEntity<Student> responseEntity = new ResponseEntity(student, HttpStatus.CREATED);
                return responseEntity;

            }catch (Exception e){
                ResponseEntity responseEntity = new ResponseEntity(e, HttpStatus.FORBIDDEN);
                return responseEntity;
            }
        }

    }

    @PutMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateStudentPage(@Valid @RequestBody Student student, BindingResult br, Model model){

/*        if(br.hasErrors()){
            List<FieldError> errorsList = br.getFieldErrors();
            ResponseEntity<List<FieldError>> responseEntity = new ResponseEntity(errorsList, HttpStatus.FORBIDDEN);
            return responseEntity;
        }else{*/
            try{
                getSs().serviceUpdateStudent(student);
                ResponseEntity<Student> responseEntity = new ResponseEntity(student, HttpStatus.OK);
                return responseEntity;

            }catch (Exception e){
                ResponseEntity responseEntity = new ResponseEntity(e, HttpStatus.FORBIDDEN);
                return responseEntity;
            }
//        }

    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteStudent(@PathVariable("id") Integer studentId){

        try{
            getSs().serviceDeleteStudent(studentId);
            return new ResponseEntity("From ResponseEntity Student deleted successfully with id " + String.valueOf(studentId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e, HttpStatus.NO_CONTENT);
        }

    }

}
