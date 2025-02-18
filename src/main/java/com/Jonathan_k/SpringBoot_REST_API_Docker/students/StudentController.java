/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker.students;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

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
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto stdDto) {
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
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
	var errors = new HashMap<String, String>();
	ex.getBindingResult().getAllErrors()
	.forEach(error ->{
	    var fieldname = ((FieldError)error).getField();
	    var errorMessage = error.getDefaultMessage();
	    errors.put(fieldname, errorMessage);
	});
	return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	
    }
    
  }
