/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

import java.util.List;
import java.util.stream.Collectors;

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

    
    private final StudentService service;
    
    
    /**
     * @param service
     */
    public StudentController(StudentService service) {
	this.service = service;
    }

    //use Data Transfer Object to filter sensitive info to api
    @PostMapping("/dto/addStudent")
    public StudentResponseDto saveStudent( @RequestBody StudentDto stdDto) {
	return this.service.saveStudent(stdDto);
    }
    
  
    
    @GetMapping("/findById/{id}")
    public StudentResponseDto findById( @PathVariable Integer id) {
	return this.service.findById(id);
    }
    
   //get using DTO
    @GetMapping("/dto/findAllStudents")
    public List<StudentResponseDto> findAllStudentsWithDTO() {
	
	return this.service.findAllStudentsWithDto();
    }
    //NORMAL WAY
    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents() {
	return this.service.findAllStudents();
    }
    
    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentsByName(@PathVariable("student-name") String name) {
	
	return this.service.findStudentsByName(name);
    }
    
    @DeleteMapping("/students/delete-id/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") Integer id) {
	this.service.deleteStudent(id);
    }
  }
