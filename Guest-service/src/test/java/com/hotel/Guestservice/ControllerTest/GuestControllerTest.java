package com.hotel.Guestservice.ControllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.Guestservice.Controllers.GuestController;
import com.hotel.Guestservice.Models.Guest;
import com.hotel.Guestservice.Repo.GuestRepo;
import com.hotel.Guestservice.Services.GuestService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = GuestController.class)
@AutoConfigureMockMvc
public class GuestControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private GuestService service;
	
	@MockBean
	private GuestRepo repo;
	
	@Test
	public void getGuestTest() throws Exception
	{
		Guest guest =new Guest();
		guest.setName("Test");
		guest.setId(1009);
		guest.setPhoneNum(100000000000L);
		guest.setGender("Male");
		guest.setEmail("test@gmail.com");
		guest.setAddress("Test address");
		Optional<Guest> guestOptional = Optional.of(guest);
		String inputInJason= this.mapToJson(guest);
		String uri="/Guest/getGuest/1009";
		Mockito.when(service.getGuest(Mockito.anyInt())).thenReturn(guestOptional);
		
		MockHttpServletRequestBuilder req=MockMvcRequestBuilders
				.get(uri)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result =mvc.perform(req).andReturn();
		MockHttpServletResponse response= result.getResponse();
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJason);
	}
	
	@Test
	public void addGuestTest() throws Exception
	{
		Guest guest =new Guest();
		guest.setName("Test");
		guest.setId(1009);
		guest.setPhoneNum(100000000000L);
		guest.setGender("Male");
		guest.setEmail("test@gmail.com");
		guest.setAddress("Test address");
		String inputInJson= this.mapToJson(guest);
		String uri="/Guest/addGuest";
		Mockito.when(service.addGuest(Mockito.any(Guest.class))).thenReturn(guest);
		MockHttpServletRequestBuilder req=MockMvcRequestBuilders
				.post(uri)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result =mvc.perform(req).andReturn();
		String outputInJson = result.getResponse().getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.SC_OK,result.getResponse().getStatus());
	}
	
	
	
	private String mapToJson(Guest guest) throws Exception
	{
		ObjectMapper objMapper=new ObjectMapper();
		return objMapper.writeValueAsString(guest);
	}
}
