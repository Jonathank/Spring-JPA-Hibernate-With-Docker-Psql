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
public class School {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    
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
    
    
}
