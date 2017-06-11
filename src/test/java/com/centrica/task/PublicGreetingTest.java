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

import com.centrica.task.api.controller.PublicGreetingController;

/**
 * @author wemccl
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("local")
public class PublicGreetingTest {

	private MockMvc mockMvc;

	@InjectMocks
	PublicGreetingController internalController;

	private String validGetPublicGreetingRequest = new String("/greetings") ;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(internalController).build();
	}

	@Test
	public void getInternalGreetingController_200_OK_Test() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(validGetPublicGreetingRequest))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello, World!"));
	}

	@Test
	public void getInternalGreetingController_404_Fail_Test() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/greetings/404")).andExpect(MockMvcResultMatchers.status().isNotFound());
	}
}
