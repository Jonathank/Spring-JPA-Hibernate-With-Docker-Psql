/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker.students;

import org.springframework.stereotype.Service;

import com.Jonathan_k.SpringBoot_REST_API_Docker.school.School;

/**
 * @author JONATHAN
 */
@Service
public class StudentMapper {

  //converts DTO object to Student object for persistence management
    public Student toStudent(StudentDto Dto) {
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
    public StudentResponseDto toStudentResponseDto(Student std) {
	return new StudentResponseDto(
	std.getFirstname(),
	std.getLastname(),
	std.getEmail()
		);
    }
}
