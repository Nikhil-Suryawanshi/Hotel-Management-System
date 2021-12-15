package com.hotel.Departmentservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hotel.Departmentservice.Models.Department;
import com.hotel.Departmentservice.Repo.MongoDBRepo;
import com.hotel.Departmentservice.Services.DepartmentServiceImp;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
	MockMvc mockMvc;
	
	@Mock
	private MongoDBRepo repo;
	
	
	private DepartmentServiceImp deptService;
	
	@BeforeEach
	void setUp() {
		this.deptService=new DepartmentServiceImp(this.repo);
	}
	
	@Test
	public void getDepartmentTest() throws Exception
	{
		deptService.getDepartment(1001L);
		verify(repo).findById(1001L);
	}
	
	@Test
	public void addDepartmentTest() throws Exception
	{
		Department dept=new Department();
		dept.setDepartmentID(1L);
		dept.setDepartmentName("Test Name");
		dept.setDesc("test desc");
		dept.setNoOfEmp(5);
		deptService.addDepartment(dept);
		assertNotNull(deptService.getDepartment(1L));
	}
	
	@Test
	public void getAllDepartment() throws Exception
	{
		deptService.getAllDepartments();
		verify(repo).findAll();
	}
	
	@Test
	public void deleteDepartmentTest()
	{
		deptService.deleteDepartment(1L);
		assertThat(repo.existsById(1L)).isFalse();
	}
	
	@Test
	public void updateDepartment()
	{
		Department dept =new Department(1001L,"Testing","Test desc",100);
		repo.insert(dept);
		dept.setNoOfEmp(5);
		when(repo.save(any(Department.class))).thenReturn(dept);
		assertEquals(dept,deptService.updateDepartment(dept));
	}
	
	
}
