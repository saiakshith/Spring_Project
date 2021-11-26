package com.nen.controller;


import com.nen.model.Student;
import com.nen.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
//@RequestMapping("/main")
public class HomeController {

    @Autowired
    private StudentService ss;

    public StudentService getSs() {
        return ss;
    }

    @Autowired
    public void setSs(StudentService ss) {
    System.out.println("I am home controller setting student service -----------------");
        this.ss = ss;
    }

    @GetMapping(path = "/register", produces = "application/json")
    public String homePage(Student student, Model model, HttpServletRequest request){

        HashMap<String, String> countryList = new HashMap<>();
        countryList.put("America", "America");
        countryList.put("China", "China");
        countryList.put("Canada", "Canada");
        countryList.put("India", "India");
        countryList.put("Nepal", "Nepal");
        model.addAttribute("countryList", countryList);

    System.out.println("This is request content type header ----------" + request.getHeader("Content-Type"));

        return "register";
    }

    @PostMapping(path = "/success")
    public String registerPage(@Valid @ModelAttribute("student") Student student, BindingResult br, Model model){

        if(br.hasErrors()){
            List<FieldError> errorsList = br.getFieldErrors();
              System.out.println("errors list is here haserrors ---------------------");
              System.out.println(errorsList);

            return "register";
        }else{
            System.out.println("The saving method is called from homecontroller -------------");
            this.getSs().serviceSaveStudent(student);

            return "success";
        }
    }

//    @ResponseBody
    @GetMapping("/getAllStudents")
    public String allStudentsPage(Model model){

        List<Student> studentsList = getSs().serviceGetAllStudents();
        model.addAttribute("studentsList", studentsList);

        return "studentsList";
    }

    @GetMapping("/student/{id}")
    public String getStudentPage(@PathVariable("id") Integer studentId, Model model) {

        model.addAttribute("student", getSs().serviceGetStudent(studentId));

        return "student";
    }

    @GetMapping("/update/{id}")
    public String populateStudentPage(@PathVariable("id") Integer studentId, Model model){

        Student student = getSs().serviceGetStudent(studentId);
        System.out.println("In the update method Student1 :  " + student);
        model.addAttribute("student", student);

        return "update";
    }

    @PostMapping(value = "/updateSuccess")
    public String updateStudentPage(@Valid Student student, BindingResult br, Model model){

    System.out.println("Student in put mapping : --------------" + student );
        if(br.hasErrors()){
            List<FieldError> errorsList = br.getFieldErrors();
            System.out.println("errors list is here haserrors ---------------------");
            System.out.println(errorsList);

            return "update";
        }else{
            System.out.println("The saving method is called from homecontroller -------------");
            getSs().serviceUpdateStudent(student);

            return "updateSuccess";
        }

    }

    @RequestMapping("/delete/{id}")
    public String deleteStudentPage(@PathVariable("id") Integer studentId){

        getSs().serviceDeleteStudent(studentId);

        return "delete";
    }

}

