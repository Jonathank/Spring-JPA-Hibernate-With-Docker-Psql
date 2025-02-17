/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker.school;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JONATHAN
 */
@RestController
@RequestMapping("/rest/api/schools")
public class SchoolController {

    private final SchoolService service;
    /**
     * @param service
     */
    public SchoolController(SchoolService service) {
	this.service= service;
    }

    //use Data Transfer Object to limit data expose
    @PostMapping("/dto/addSchool")
    public SchoolDto AddSchool(@RequestBody SchoolDto schooldto) {
	return this.service.addSchool(schooldto);
    }

    //normal way
    @PostMapping("/addSchool")
    public School AddSchool(@RequestBody School school) {
	return this.service.addStudent(school);
    }
    
    
    @GetMapping("/dto/getSchools")
    public List<SchoolDto> getSchoolsDto(){
	return this.service.getAllSchoolsDto();
    }
    //normal way
    @GetMapping("/getSchools")
    public List<School> getSchools(){
	return this.service.getAllSchools();
    }
}
