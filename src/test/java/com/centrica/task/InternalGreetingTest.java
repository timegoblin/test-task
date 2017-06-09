/**
 * 
 */
package com.centrica.task;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.centrica.task.api.controller.InternalGreetingController;

/**
 * @author wemccl
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("local")
public class InternalGreetingTest {

	private MockMvc mockMvc;

	@InjectMocks
	InternalGreetingController internalController;
	
	private String validGetInternalGreetingRequest = new String("/internal-greetings") ;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(internalController).build();
	}

	@Test
	public void getInternalGreetingController_200_OK_Test() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(validGetInternalGreetingRequest))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello, Management!"));
	}

	@Test
	public void getInternalGreetingController_404_Fail_Test() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/internal-greetings/nohere")).andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
