/**
 * 
 */
package com.centrica.task.api.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.centrica.task.api.GreetingApi;

/**
 * Public greeting api endpoint controller, implementing greetings interface for public
 * 
 * @author wemccl
 *
 */
@RestController
@RequestMapping("/greetings")
public class PublicGreetingController implements GreetingApi {
    private static final String greeting = "Hello, World!";

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<String> greetings() {
    	return new ResponseEntity<String>(greeting, HttpStatus.OK) ;
    }
}