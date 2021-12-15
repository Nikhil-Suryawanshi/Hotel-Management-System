package com.hotel.Inventoryservice.Services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hotel.Inventoryservice.Models.Inventory;
import com.hotel.Inventoryservice.Models.InventoryList;
import com.hotel.Inventoryservice.Repositories.InventoryMongoRepo;

@ExtendWith(MockitoExtension.class)
class InventoryServiceImplTest {
	
	@Mock
	private InventoryMongoRepo repo;
	
	private InventoryServiceImpl invService;
	
	
	
	
	@BeforeEach
	void setUp() throws Exception 
	{
		this.invService=new InventoryServiceImpl(repo);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddInventory() 
	{
		Inventory inv=new Inventory();
		inv.setInventoryId(1001);
		inv.setInvName("Test");
		inv.setInvStock(100);
		inv.setInvType("Test type");
		invService.addInventory(inv);
		assertNotNull(repo.findById(inv.getInventoryId()));
	}
	
	@Test
	void testGetInventory() 
	{
		invService.getInventory(1);
		verify(repo).findById(1);
	}
	
	@Test
	void testDeleteInventory()
	{
		Inventory inv=new Inventory();
		inv.setInventoryId(1001);
		inv.setInvName("Test");
		inv.setInvStock(100);
		inv.setInvType("Test type");
		repo.insert(inv);
		assertThat(repo.existsById(1001));
		invService.deleteInventory(1001);
		assertThat(repo.existsById(inv.getInventoryId())).isFalse();
	}
	
	@Test
	void testUpdateInventory()
	{
		Inventory inv=new Inventory();
		inv.setInventoryId(1001);
		inv.setInvName("Test");
		inv.setInvStock(100);
		inv.setInvType("Test type");
		repo.insert(inv);
		when(repo.save(any(Inventory.class))).thenReturn(inv);
		assertEquals(inv, invService.updateInventory(inv));
		//Created second Inventory
		Inventory inv2=new Inventory();
		inv2.setInventoryId(inv.getInventoryId());
		inv2.setInvName(inv.getInvName());
		inv2.setInvStock(inv.getInvStock()+100);
		inv2.setInvType(inv.getInvType());
		//Updating inv
		invService.updateInventory(inv2);
		assertEquals(inv.getInvStock(), invService.getInventory(1001));
		
	}
}
