package com.verizon.tla;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.tla.model.InternetPackage;
import com.verizon.tla.restapi.InternetPackageApi;
import com.verizon.tla.service.InternetPackageService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = InternetPackageApi.class)
public class InternetPackageControllerUnitTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	@MockBean
	private InternetPackageService ipServiceMock;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	@After
	public void tearDown() throws Exception {
		mockMvc = null;
	}


	@Test
	public void testGetAllPackages() throws Exception{
		assertThat(this.ipServiceMock).isNotNull();
		
		List<InternetPackage> packList = new ArrayList<>();
		packList.add(new InternetPackage());
		
		when(ipServiceMock.getAllPackages()).thenReturn(packList);
		
		this.mockMvc.perform(get("/packages"))
					.andExpect(status().isOk())
					.andDo(print());
		
	}
	
	@Test
	public void testGetAllPackagesBySearchField() throws Exception{
		assertThat(this.ipServiceMock).isNotNull();
		
		List<InternetPackage> packList = new ArrayList<>();
		packList.add(new InternetPackage());
		
		double cost = 100;
		double max_usage = 200;
		double net_speed = 10;
		
		when(ipServiceMock.getAllPackagesByCost(cost)).thenReturn(packList);
		when(ipServiceMock.getAllPackagesByMaxUsage(max_usage)).thenReturn(packList);
		when(ipServiceMock.getAllPackagesByNetSpeed(net_speed)).thenReturn(packList);
		
		this.mockMvc.perform(get("/packages/cost/" + cost))
					.andExpect(status().isOk())
					.andDo(print());
		
		this.mockMvc.perform(get("/packages/maxUsage/" + max_usage))
		.andExpect(status().isOk())
		.andDo(print());
		
		this.mockMvc.perform(get("/packages/netSpeed/" + net_speed))
		.andExpect(status().isOk())
		.andDo(print());
		
	}
	
	
	
	

}
