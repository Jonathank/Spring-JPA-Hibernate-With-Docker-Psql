/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker.studentProfile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JONATHAN
 */
@RestController
@RequestMapping("/rest/api/std-profile")
public class StudentProfileController {

    private final StudentProfileRepository repo;

    /**
     * @param repo
     */
    public StudentProfileController(StudentProfileRepository stdrepo) {
	this.repo = stdrepo;
    }
     
   @PostMapping("/addStdProfile")
   public StudentProfile addStudentProfile(@RequestBody StudentProfile profile) {
       return repo.save(profile);
   }
   
}
