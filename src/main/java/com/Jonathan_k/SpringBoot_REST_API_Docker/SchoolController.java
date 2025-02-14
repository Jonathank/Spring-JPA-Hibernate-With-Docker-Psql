/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

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
@RequestMapping("/rest/api/schools/")
public class SchoolController {

    private final SchoolRepository repo;
    
    /**
     * @param repo
     */
    public SchoolController(SchoolRepository repo) {
	this.repo = repo;
    }


    @PostMapping("/addSchool")
    public School AddSchool(@RequestBody School school) {
	return repo.save(school);
    }
    
    @GetMapping("/getSchools")
    public List<School> getSchools(){
	return repo.findAll();
    }
}
