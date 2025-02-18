/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker.students;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author JONATHAN
 */
class StudentServiceTest {

    // which service we want to test
    @InjectMocks
    private StudentService service;
    
    //declare dependencies
    @Mock
    private StudentRepository repo;
    @Mock
    private StudentMapper mapper;
    
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void shouldSaveStudent() {
	//Given
	 StudentDto dto = new StudentDto(
		       "KYEYUNE",
		       "JOANTHAN",
		       "kyeyunejonathan@gmail.com",
		       1
		       );
	 Student std = new Student();
	       std.setFirstname("Kyeyune");
	       std.setLastname("jonathan");
	       std.setEmail("jonathan.com");
	       std.setAge(20);
	       
	       //when
	       StudentResponseDto responseDto = service.saveStudent(dto);
	        
	       //Then
	       assertEquals(dto.firstname(), responseDto.firstname());
	       assertEquals(dto.lastname(), responseDto.lastname());
	       assertEquals(dto.email(), responseDto.email());
	        
    }
    
}
