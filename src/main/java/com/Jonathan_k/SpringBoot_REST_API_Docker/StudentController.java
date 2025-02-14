/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JONATHAN
 */


@RestController
@RequestMapping("/rest/api")
public class StudentController {

    private final StudentRepository repo;
    
    public StudentController(StudentRepository repos) {
	this.repo = repos;
    }
    
    @PostMapping("/addStudent")
    public Student post( @RequestBody Student std) {
	return repo.save(std);
	 
    }
    
    @GetMapping("/findById/{id}")
    public Student findById( @PathVariable Integer id) {
	return repo.findById(id)
	.orElse(new Student());
    }
    
    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents() {
	return repo.findAll();
	
    }
    
    @GetMapping("/students/search/{student-name}")
    public List<Student> findAllStudents(@PathVariable("student-name") String name) {
	return repo.findAllByFirstnameContaining(name);
	
    }
   
    
    @DeleteMapping("/students/delete-id/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") Integer id) {
	repo.deleteById(id);
    }
  }
