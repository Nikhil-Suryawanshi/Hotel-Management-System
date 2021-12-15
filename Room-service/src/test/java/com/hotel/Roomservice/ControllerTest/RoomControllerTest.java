package com.hotel.Roomservice.ControllerTest;

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
import com.hotel.Roomservice.Controllers.RoomController;
import com.hotel.Roomservice.Models.Room;
import com.hotel.Roomservice.Repo.ManagerMongoRepo;
import com.hotel.Roomservice.Services.ManagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = RoomController.class)
@AutoConfigureMockMvc
public class RoomControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ManagerService service;
	
	@MockBean
	private ManagerMongoRepo repo;
	
	@Test
	public void getDepartmentTest() throws Exception
	{
		Room room=new Room();
		room.setAvailable(true);
		room.setDesc("Testing Desc");
		room.setRoomNum(101);
		room.setRoomRent(2000);
		room.setType("Test Type");
		
		Optional<Room> roomOptional = Optional.of(room);
		String inputInJason= this.mapToJson(room);
		String uri="/Room/getRoom/101";
		Mockito.when(service.getRoom(Mockito.anyInt())).thenReturn(roomOptional);
		
		MockHttpServletRequestBuilder req=MockMvcRequestBuilders
				.get(uri)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result =mvc.perform(req).andReturn();
		MockHttpServletResponse response= result.getResponse();
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJason);
	}
	
	@Test
	public void addDepartment() throws Exception
	{
		Room room=new Room(109,"Test",2000,true,"This department is For testing");
		String inputInJson= this.mapToJson(room);
		String uri="/Room/addRoom";
		Mockito.when(service.addRoom(Mockito.any(Room.class))).thenReturn(room);
		MockHttpServletRequestBuilder req=MockMvcRequestBuilders
				.post(uri)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result =mvc.perform(req).andReturn();
		String outputInJson = result.getResponse().getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.SC_OK,result.getResponse().getStatus());
	}
	
	@Test
	public void deleteDepartmetnTest() throws Exception
	{
		String expectedOutput = "Room Deleted";
		String uri="/Room/deleteRoom/109";
		Mockito.when(service.deleteRoom(Mockito.anyInt())).thenReturn(expectedOutput);
		MockHttpServletRequestBuilder req=MockMvcRequestBuilders
				.delete(uri)
				.accept(MediaType.ALL_VALUE);
		MvcResult result =mvc.perform(req).andReturn();
		String actualOutput = result.getResponse().getContentAsString();
		assertThat(actualOutput).isEqualTo(expectedOutput);
		assertThat(repo.existsById(109)).isFalse();
	}
	
	
	
	private String mapToJson(Room room) throws Exception
	{
		ObjectMapper objMapper=new ObjectMapper();
		return objMapper.writeValueAsString(room);
	}
}
