/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker.students;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author JONATHAN
 */
class StudentMapperTest {
    
   private StudentMapper mapper;
   
   @BeforeEach
   void setUp() {
       mapper = new StudentMapper();
   }
   
   @Test
   public void shouldMapStudentDtoToStudent() {
       StudentDto dto = new StudentDto(
	       "KYEYUNE",
	       "JOANTHAN",
	       "kyeyunejonathan@gmail.com",
	       1
	       );
       Student std = mapper.toStudent(dto);
       
      assertEquals(dto.firstname(), std.getFirstname().toUpperCase());
      assertEquals(dto.lastname(), std.getLastname());
      assertEquals(dto.email(), std.getEmail());
      assertNotNull(std.getSchool());
      assertEquals(dto.schoolId(),std.getSchool().getId());
   }
   
   @Test
   public void shouldMapStudentToStudentResponseDto() {
       //Given
       Student std = new Student();
       std.setFirstname("Kyeyune");
       std.setLastname("jonathan");
       std.setEmail("jonathan.com");
       
       //When
       StudentResponseDto response = mapper.toStudentResponseDto(std);
       
       //Then
       assertEquals(std.getFirstname(), response.firstname());
       assertEquals(std.getLastname(), response.lastname());
       assertEquals(std.getEmail(), response.email());
      
   }
}
