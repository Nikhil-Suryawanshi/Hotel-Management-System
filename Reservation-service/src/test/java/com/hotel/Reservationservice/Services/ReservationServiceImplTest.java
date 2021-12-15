package com.hotel.Reservationservice.Services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.hotel.Reservationservice.Models.Reservation;
import com.hotel.Reservationservice.Repository.ReservationRepo;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ReservationServiceImplTest {
	
	@Mock
	private ReservationRepo repo;
	
	@Mock
	private RestTemplate restTmp;
	
	private ReservationServiceImpl reservationService;

	@BeforeEach
	void setUp() throws Exception 
	{
		this.reservationService=new ReservationServiceImpl(repo,restTmp);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Test cases Executed");
	}

	@Test
	void testBookRoom() {
		Reservation res=new Reservation();
		res.setGuestId(1001);
		res.setRoomId(101);
		res.setCheckInDate("test");
		res.setCheckOutDate("");
		res.setNoOfGuest("4");
		res.setStatus("test");
		res.setNoOfNight(2);
		reservationService.bookRoom(res);
		assertNotNull(reservationService.getReservations());
		
	}

	@Test
	void testGetReservations() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateRes() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteRes() {
		fail("Not yet implemented");
	}

}
