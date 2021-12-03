package com.hotel.Reservationservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.Reservationservice.Models.Reservation;

public interface ReservationRepo extends MongoRepository<Reservation, Integer> {

}
