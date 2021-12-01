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
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


@Controller
public class ConsumeRestAPIController {
    private static final Logger LOG = Logger.getLogger("ConsumeRestAPIController");

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

    @GetMapping(path = "/about")
    public String getAboutPage(){
        return "about";
    }

    @GetMapping(path = "/contact")
    public String getContactPage(){
        return "contact";
    }

    @GetMapping(path = "/student/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getStudentDetailsPage(@PathVariable("id") String studentId, Model model){
        try{
            ResponseEntity responseEntity = this.restTemplate.getForEntity(URL + "student/" + studentId, ConsumeStudent.class);
                model.addAttribute("student", responseEntity.getBody());
                return "studentDetails";
        }catch (Exception  e){
            model.addAttribute("exception", e);
            return "pageNotFound";
        }

    }

    @GetMapping(path = "/getAllStudents", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getAllStudentsListPage(Model model){
        try{
            ResponseEntity responseEntity = this.restTemplate.getForEntity(URL + "getAllStudents", List.class);
            model.addAttribute("studentsList", responseEntity.getBody());
            return "studentsList";
        }catch (Exception e){
            model.addAttribute("exception", e);
            return "register";
        }
    }

    @PostMapping(path = "/createStudent", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String createStudentSuccessPage(@Valid ConsumeStudent consumeStudent, BindingResult br, Model model){
        if(br.hasErrors()){
            List<FieldError> errorsList = br.getFieldErrors();
            return "register";
        }else{
            try{
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                ResponseEntity<ConsumeStudent> responseEntity = this.restTemplate.exchange(URL + "createStudent/", HttpMethod.POST, new HttpEntity(consumeStudent, httpHeaders), ConsumeStudent.class);
                model.addAttribute("student", responseEntity.getBody());
                return "studentCreated";
            }catch (Exception e){
                e.printStackTrace();
                model.addAttribute("exception", e);
                return "register";
            }
        }
    }

    @GetMapping(path = "update/{id}")
    public String updateStudentPage(@PathVariable("id") String studentId, Model model){
        try{
            ResponseEntity responseEntity = this.restTemplate.getForEntity(URL + "student/" + studentId, ConsumeStudent.class);
            model.addAttribute("consumeStudent", responseEntity.getBody());
            return "updateForm";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("exception", e);
            return "pageNotFound";
        }
    }

    @RequestMapping(path = "/updateSuccess", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String studentUpdateSuccessPage(@Valid ConsumeStudent consumeStudent, BindingResult br, Model model) {
        if (br.hasErrors()) {
            List<FieldError> errorsList = br.getFieldErrors();
            System.out.println(errorsList);
            return "updateForm";
        } else {
            try {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                ResponseEntity<ConsumeStudent> responseEntity = this.restTemplate.exchange(URL + "update/", HttpMethod.PUT, new HttpEntity(consumeStudent, httpHeaders), ConsumeStudent.class);
                model.addAttribute("student", responseEntity.getBody());
                return "updateSuccess";
            } catch (Exception e) {
                model.addAttribute("exception", e);
                return "updateForm";
            }
        }
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteStudentSuccessPage(@PathVariable("id") String studentId, Model model){
        try{
            this.restTemplate.delete(URL + "delete/" + studentId);
            return "deleteSuccess";
        }catch (Exception e){
            model.addAttribute("exception", e);
            return "pageNotFound";
        }
    }

    @RequestMapping(path = {"*", "student/*"})
    public String pageNotFound404(){
        return "pageNotFound";
    }

}
