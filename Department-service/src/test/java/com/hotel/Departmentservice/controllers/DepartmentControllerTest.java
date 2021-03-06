package com.hotel.Departmentservice.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
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
import com.hotel.Departmentservice.Controllers.DepartmentController;
import com.hotel.Departmentservice.Models.Department;
import com.hotel.Departmentservice.Models.DepartmentList;
import com.hotel.Departmentservice.Repo.MongoDBRepo;
import com.hotel.Departmentservice.Services.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = DepartmentController.class)
@AutoConfigureMockMvc
public class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private DepartmentService service;
	
	@MockBean
	private MongoDBRepo repo;
	
	
	
	@Test
	public void getDepartmentTest() throws Exception
	{
		Department dept=new Department(1001,"Manager","This department is of Manager",5);
		Optional<Department> deptOptional = Optional.of(dept);
		String inputInJason= this.mapToJson(dept);
		String uri="/Department/findById/1001";
		Mockito.when(service.getDepartment(Mockito.anyLong())).thenReturn(deptOptional);
		
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
		Department dept=new Department(1009L,"Test","This department is For testing",5);
		String inputInJson= this.mapToJson(dept);
		String uri="/Department/add";
		Mockito.when(service.addDepartment(Mockito.any(Department.class))).thenReturn(dept);
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
	public void getAllDepartment() throws Exception
	{
		List<Department> list= repo.findAll();
		DepartmentList deptList = new DepartmentList();
		deptList.setDeptList(list);
		
		String expectedList=this.mapToJson2(deptList);
		String uri ="/Department/ShowAll";
		
		Mockito.when(service.getAllDepartments()).thenReturn(deptList);
		
		MockHttpServletRequestBuilder req=MockMvcRequestBuilders
				.get(uri)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result =mvc.perform(req).andReturn();
		MockHttpServletResponse response= result.getResponse();
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(expectedList);
	}
	
	
	@Test
	public void deleteDepartmetnTest() throws Exception
	{
		String expectedOutput = "Department Deleted";
		String uri="/Department/delete/1009";
		Mockito.when(service.deleteDepartment(Mockito.anyLong())).thenReturn(expectedOutput);
		MockHttpServletRequestBuilder req=MockMvcRequestBuilders
				.delete(uri)
				.accept(MediaType.ALL_VALUE);
		MvcResult result =mvc.perform(req).andReturn();
		String actualOutput = result.getResponse().getContentAsString();
		assertThat(actualOutput).isEqualTo(expectedOutput);
		assertThat(repo.existsById(1009L)).isFalse();
	}
	
	
	private String mapToJson(Department dept) throws Exception{
		ObjectMapper objMapper=new ObjectMapper();
		return objMapper.writeValueAsString(dept);
	}
	
	private String mapToJson2(DepartmentList dept) throws Exception{
		ObjectMapper objMapper=new ObjectMapper();
		return objMapper.writeValueAsString(dept);
	}

	   
}
