/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker.students;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author JONATHAN
 */
//use the id of the class so as to identify it

public interface StudentRepository extends JpaRepository<Student,Integer>{

    List<Student> findAllByFirstnameContaining(String firstname);
    
}
