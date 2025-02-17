/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

/**
 * @author JONATHAN
 */
public record StudentDto(
	String firstname,
	String lastname,
	String email,
	Integer schoolId
	) {

}
