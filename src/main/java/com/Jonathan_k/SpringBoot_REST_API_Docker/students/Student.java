/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker.students;

import com.Jonathan_k.SpringBoot_REST_API_Docker.school.School;
import com.Jonathan_k.SpringBoot_REST_API_Docker.studentProfile.StudentProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author JONATHAN
 */
@Entity
@Table(name ="T_Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="firstname")
    private String firstname; 
    @Column(name ="lasttname")
    private String lastname;
    @Column(name ="email",unique = true)
    private String email;
    @Column(name ="age")
    private int age;
    
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private StudentProfile studnetProfile;
    
    @JsonBackReference  // child, it tells that student doesnt need to serialize the parent(school)
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
    
    public Student() {}
    
    /**
     * @param firstname
     * @param lastname
     * @param email
     * @param age
     */
    public Student(String firstname, String lastname, String email, int age) {
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.age = age;
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
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }
    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }
    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the studnetProfile
     */
    public StudentProfile getStudnetProfile() {
        return studnetProfile;
    }

    /**
     * @param studnetProfile the studnetProfile to set
     */
    public void setStudnetProfile(StudentProfile studnetProfile) {
        this.studnetProfile = studnetProfile;
    }

    /**
     * @return the school
     */
    public School getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(School school) {
        this.school = school;
    }
    
    
    
}
