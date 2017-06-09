/**
 * 
 */
package com.centrica.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.centrica.task.configuration.EmbeddedTomcatConfiguration;

/**
 * Spring boot greeting application
 * 
 * @author wemccl
 *
 */
@SpringBootApplication
@ComponentScan(value = { "com.centrica.task" })
@Import(EmbeddedTomcatConfiguration.class)
public class GreetingApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    SpringApplication.run(GreetingApplication.class, args);
	}

}
