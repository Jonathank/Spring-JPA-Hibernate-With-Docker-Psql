/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker.students;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * @author JONATHAN
 */
@Service
public class StudentService {

    private final StudentRepository repo;
    private final StudentMapper studentMapper;
    /**
     * @param repo
     * @param studentMapper
     */
    public StudentService(StudentRepository repo, StudentMapper studentMapper) {
	this.repo = repo;
	this.studentMapper = studentMapper;
    }
    
    
    public StudentResponseDto saveStudent(StudentDto stdDto) {
	var student = studentMapper.toStudent(stdDto);
	var savedStudent = repo.save(student);
	return studentMapper.toStudentResponseDto(savedStudent);
    }
    
    public List<Student>findAllStudents(){
	return repo.findAll();
    }
   
    
    public StudentResponseDto findById(Integer id) {
	return repo.findById(id)
		.map(studentMapper::toStudentResponseDto)
		.orElse(null);
    }
    
    public List<StudentResponseDto> findStudentsByName(String name){
	return repo.findAllByFirstnameContaining(name)
		.stream()
		.map(studentMapper::toStudentResponseDto)
		.collect(Collectors.toList());
    }
    
    public void deleteStudent(Integer id) {
	repo.deleteById(id);
    }
    
    public List<StudentResponseDto>findAllStudentsWithDto(){
	return repo.findAll()
		.stream()
		.map(studentMapper::toStudentResponseDto)
		.collect(Collectors.toList());
    }
}
