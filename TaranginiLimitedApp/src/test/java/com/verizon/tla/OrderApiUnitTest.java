package com.verizon.tla;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.verizon.tla.model.Order;
import com.verizon.tla.restapi.OrderApi;
import com.verizon.tla.service.OrderService;
import com.verizon.tla.testUtil.TestUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OrderApi.class)
public class OrderApiUnitTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	@MockBean
	private OrderService orderServiceMock;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	@After
	public void tearDown() throws Exception {
		mockMvc = null;
	}

	
	
	@Test
	public void testGetOrderByCustomerId() throws Exception{
		assertThat(this.orderServiceMock).isNotNull();
		
		Order odr = new Order();
		String id = "1234567890";
		
		when(orderServiceMock.getOrderByCustomer(id)).thenReturn(odr);
		
		this.mockMvc.perform(get("/viewOrder/"+id))
					.andExpect(status().isOk())
					.andDo(print());
			
		this.mockMvc.perform(post("/viewOrder/"+id))
					.andExpect(status().is4xxClientError())
					.andDo(print());
		
	}
	
	
	@Test
	public void testAddOrder() throws Exception{
		assertThat(this.orderServiceMock).isNotNull();
		
		Order odr = new Order();
		
		when(orderServiceMock.addOrder(Mockito.any(Order.class))).thenReturn(odr);
			
		this.mockMvc.perform(post("/addOrder")
						.contentType(TestUtil.APPLICATION_JSON_UTF8)
						.content(TestUtil.convertObjectToJsonBytes(odr)))
					.andDo(print())
					.andExpect(status().isOk());
		
	}
	
	
}
