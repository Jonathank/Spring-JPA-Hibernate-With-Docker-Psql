/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

import org.springframework.stereotype.Service;

/**
 * @author JONATHAN
 */
@Service
public class SchoolMapper {

    //DTO
    public School toStudent(SchoolDto schdto) {
	
	return new School(schdto.name());
    }
    
  //return list in using DTO
    public SchoolDto toSchoolDto(School sch) {
   	return new SchoolDto(sch.getName());
       }
    
    
}
