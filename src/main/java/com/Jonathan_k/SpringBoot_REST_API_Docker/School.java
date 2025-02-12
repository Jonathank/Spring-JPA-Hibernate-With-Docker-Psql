/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * @author JONATHAN
 */
@Entity
public class School {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    
    @OneToMany(mappedBy = "school")
    private List<Student> students;
    
    public School() {}
    /**
     * @param name
     */
    public School(String name) {
	super();
	this.name = name;
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
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }
    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    
}
