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

    private final StudentRepository repo;
    
    public StudentController(StudentRepository repos) {
	this.repo = repos;
    }
    
    //use Data Transfer Object to filter sensitive info to api
    @PostMapping("/dto/addStudent")
    public StudentResponseDto post( @RequestBody StudentDto stdDto) {
	var student = toStudent(stdDto);
	var savedStudent = repo.save(student);
	return toStudentResponseDto(savedStudent);
    }
    //converts DTO object to Student object for persistence management
    private Student toStudent(StudentDto Dto) {
	var student = new Student();
	student.setFirstname(Dto.firstname());
	student.setLastname(Dto.lastname());
	student.setEmail(Dto.email());
	
	var school = new School();
	school.setId(Dto.schoolId());
	//set school for student
	student.setSchool(school);
	 return student;
	
    }
    //returns only what the user should see as response after creating Student OB
    private StudentResponseDto toStudentResponseDto(Student std) {
	return new StudentResponseDto(
	std.getFirstname(),
	std.getLastname(),
	std.getEmail()
		);
    }
    // normal way
    @PostMapping("/addStudent")
    public Student post( @RequestBody Student std) {
	return repo.save(std);
	 
    }
    
    @GetMapping("/findById/{id}")
    public Student findById( @PathVariable Integer id) {
	return repo.findById(id)
	.orElse(new Student());
    }
    
   //get using DTO
    @GetMapping("/dto/findAllStudents")
    public List<StudentResponseDto> findAllStudentsWithDTO() {
	
	return repo.findAll()
		.stream()
		.map(this::toStudentResponseDto)
		.collect(Collectors.toList());
    }
    //NORMAL WAY
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
