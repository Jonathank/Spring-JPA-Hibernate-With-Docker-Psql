/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

import java.util.List;
import java.util.stream.Collectors;

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

    private final SchoolRepository repo;
    
    /**
     * @param repo
     */
    public SchoolController(SchoolRepository repo) {
	this.repo = repo;
    }

    //use Data Transfer Object to limit data expose
    @PostMapping("/dto/addSchool")
    public SchoolDto AddSchool(@RequestBody SchoolDto schooldto) {
	var school = toStudent(schooldto);
	 repo.save(school);
	 return schooldto;
    }

    //DTO
    private School toStudent(SchoolDto schdto) {
	
	return new School(schdto.name());
    }
    
    
    //normal way
    @PostMapping("/addSchool")
    public School AddSchool(@RequestBody School school) {
	return repo.save(school);
    }
    
    //return list in using DTO
    private SchoolDto toSchoolDto(School sch) {
   	return new SchoolDto(sch.getName());
       }
    
    @GetMapping("/dto/getSchools")
    public List<SchoolDto> getSchoolsDto(){
	return repo.findAll()
		.stream()
		.map(this::toSchoolDto)
		.collect(Collectors.toList());
    }
    //normal way
    @GetMapping("/getSchools")
    public List<School> getSchools(){
	return repo.findAll();
    }
}
