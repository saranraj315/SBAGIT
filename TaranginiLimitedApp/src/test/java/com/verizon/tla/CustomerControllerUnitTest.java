package com.verizon.tla;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.tla.model.Customer;
import com.verizon.tla.restapi.CustomerApi;
import com.verizon.tla.service.CustomerService;
import com.verizon.tla.testUtil.TestUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerApi.class)
public class CustomerControllerUnitTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	@MockBean
	private CustomerService custServiceMock;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	@After
	public void tearDown() throws Exception {
		mockMvc = null;
	}

	
	@Test
	public void testAddCustomer() throws Exception{
		assertThat(this.custServiceMock).isNotNull();
		
		Customer cust = new Customer();
		
		when(custServiceMock.addCustomer(Mockito.any(Customer.class))).thenReturn(cust);
			
		this.mockMvc.perform(post("/addCustomer").contentType(TestUtil.APPLICATION_JSON_UTF8)
												.content(TestUtil.convertObjectToJsonBytes(cust)))
					.andDo(print())
					.andExpect(status().isOk());
		
	}

}
