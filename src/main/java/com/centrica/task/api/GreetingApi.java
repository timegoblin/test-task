/**
 * 
 */
package com.centrica.task.api;

import org.springframework.http.ResponseEntity;

/**
 * Greeting api interface definition
 * 
 * @author wemccl
 *
 */
public interface GreetingApi {

	/**
	 * Greeting api method to return greeting
	 * 
	 * @return
	 */
	public ResponseEntity<String> greetings() ;
}
