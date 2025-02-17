/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

/**
 * @author JONATHAN
 */
//return proper response to user, with only required data
public record StudentResponseDto(
	//these are what to expose to the user/client
	String firstname,
	String lastname,
	String email
	) {

}
