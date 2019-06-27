package com.mkyong;

import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

//	private  static final Logger LOGGER = LogManager.getFormatterLogger(StudentController.class);
    @Autowired
    private StudentRepository repository;

    // Find
    @GetMapping("/students")
    List<Student> findAll() {
//    	LOGGER.info("Fetching students");
        return repository.findAll();
    }
    
    // Save
    @PostMapping("/students")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Student newBook(@RequestBody Student student) {
        return repository.save(student);
    }
    
    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    String getTest() {
    	return "Hi";
    }
}
