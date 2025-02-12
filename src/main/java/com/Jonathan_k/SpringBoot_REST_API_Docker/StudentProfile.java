/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author JONATHAN
 */
@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;
    private String bio;
    
    public StudentProfile() {}
    /**
     * @param bio
     */
    public StudentProfile(String bio) {
	super();
	this.bio = bio;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the bio
     */
    public String getBio() {
        return bio;
    }
    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }
    
    
    
    
}
