/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 * @author JONATHAN
 */
@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;
    private String bio;
    
    @OneToOne()
    @JoinColumn(name = "student_id")
    private Student student;
    
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
    

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }
    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
