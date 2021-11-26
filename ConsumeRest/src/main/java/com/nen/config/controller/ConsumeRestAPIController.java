package com.nen.config.controller;

import com.nen.config.model.ConsumeStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Controller
public class ConsumeRestAPIController {

  @Autowired
  private RestTemplate restTemplate;

  public final String URL = "http://localhost:8080/SpringWeb/api/";

  @ModelAttribute("countryList")
  public HashMap<String, String> loadCountryList(){

    HashMap<String, String> countryList = new HashMap<>();
    countryList.put("America", "America");
    countryList.put("China", "China");
    countryList.put("Canada", "Canada");
    countryList.put("India", "India");
    countryList.put("Nepal", "Nepal");
    countryList.put("Europe", "Europe");

    return countryList;
  }

  @GetMapping(path = "/register", produces = {MediaType.APPLICATION_JSON_VALUE})
  public String getRegisterPage(ConsumeStudent consumeStudent){

    return "register";
  }

  @GetMapping(path = "/student/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
  public String getStudentDetailsPage(@PathVariable("id") String studentId, ConsumeStudent consumeStudent, Model model){
//        http://localhost:8080/SpringWeb/api/student/1  --- API URL

    try{
      ResponseEntity responseEntity = this.restTemplate.getForEntity(URL + "student/" + studentId, ConsumeStudent.class);
      System.out.println("student id ----------------------" + responseEntity.getBody());
      if(responseEntity.getBody().equals(null)){

        return "pageNotFound";
      }else {
        model.addAttribute("student", responseEntity.getBody());

        return "studentDetails";
      }
    }catch (Exception  e){
      System.out.println("Delete Student Exception --------" + e);
      e.printStackTrace();
      model.addAttribute("exception", e);

      return "pageNotFound";
    }

  }

  @GetMapping(path = "/getAllStudents", produces = {MediaType.APPLICATION_JSON_VALUE})
  public String getAllStudentsListPage(Model model){
//        http://localhost:8080/SpringWeb/api/getAllStudents
    try{
      ResponseEntity responseEntity = this.restTemplate.getForEntity(URL + "getAllStudents", List.class);
      model.addAttribute("studentsList", responseEntity.getBody());

      return "studentsList";
    }catch (Exception e){
      System.out.println("Delete Student Exception --------" + e);
      e.printStackTrace();
      model.addAttribute("exception", e);

      return "register";
    }
  }

  @PostMapping(path = "/createStudent", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
  public String createStudentSuccessPage(@Valid ConsumeStudent consumeStudent, BindingResult br, Model model){
//        http://localhost:8080/SpringWeb/api/createStudent

    if(br.hasErrors()){
      List<FieldError> errorsList = br.getFieldErrors();
      System.out.println("createStudent has errors ---------------------");
      System.out.println(errorsList);

      return "register";
    }else{
      try{
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(consumeStudent, httpHeaders);

        ResponseEntity<ConsumeStudent> responseEntity = this.restTemplate.exchange(URL + "createStudent/", HttpMethod.POST, httpEntity, ConsumeStudent.class);
        model.addAttribute("student", responseEntity.getBody());

        return "studentCreated";
      }catch (Exception e){
        System.out.println("Delete Student Exception --------" + e);
        e.printStackTrace();
        model.addAttribute("exception", e);
        System.out.println("From create student else catch block ----------------------------");

        return "register";
      }

    }

  }

  @GetMapping(path = "update/{id}")
  public String updateStudentPage(@PathVariable("id") String studentId, ConsumeStudent consumeStudent, BindingResult br, Model model){

    try{
      ResponseEntity responseEntity = this.restTemplate.getForEntity(URL + "student/" + studentId, ConsumeStudent.class);
      model.addAttribute("consumeStudent", responseEntity.getBody());

      return "updateForm";
    }catch (Exception e){
      System.out.println("Delete Student Exception --------" + e);
      e.printStackTrace();
      model.addAttribute("exception", e);

      return "pageNotFound";
    }
  }

  @RequestMapping(path = "/updateSuccess", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
  public String studentUpdateSuccessPage(@Valid ConsumeStudent consumeStudent, BindingResult br, Model model) {
//        http://localhost:8080/SpringWeb/api/update

    System.out.println("update success ------ " + consumeStudent);

    if (br.hasErrors()) {
      List<FieldError> errorsList = br.getFieldErrors();
      System.out.println("update success has errors ---------------------");
      System.out.println(errorsList);

      return "updateForm";
    } else {
      try {
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(consumeStudent, httpHeaders);

        ResponseEntity<ConsumeStudent> responseEntity = this.restTemplate.exchange(URL + "update/", HttpMethod.PUT, httpEntity, ConsumeStudent.class);
        model.addAttribute("student", responseEntity.getBody());
        System.out.println("update success response entity getbody() ------ " + responseEntity.getBody() + " re ----" + responseEntity);

        return "updateSuccess";
      } catch (Exception e) {
        System.out.println("update success Exception --------" + e);
        e.printStackTrace();
        model.addAttribute("exception", e);

        return "updateForm";
      }
    }
  }

  @RequestMapping(path = "/delete/{id}")
  public String deleteStudentSuccessPage(@PathVariable("id") String studentId, Model model){
//        http://localhost:8080/SpringWeb/api/delete/4

    try{
      this.restTemplate.delete(URL + "delete/" + studentId);

      return "deleteSuccess";
    }catch (Exception e){
      System.out.println("Delete Student Exception --------" + e);
      e.printStackTrace();
      model.addAttribute("exception", e);

      return "pageNotFound";
    }
  }

  @RequestMapping(path = {"*", "student/*"})
  public String pageNotFound404(){

    return "pageNotFound";
  }

}
