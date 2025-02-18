/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker.students;

import jakarta.validation.constraints.NotEmpty;

/**
 * @author JONATHAN
 */
public record StudentDto(
	@NotEmpty(message = "FirstName should not be Empty")
	String firstname,
	@NotEmpty(message = "LasttName should not be Empty")
	String lastname,
	String email,
	Integer schoolId
	) {

}
