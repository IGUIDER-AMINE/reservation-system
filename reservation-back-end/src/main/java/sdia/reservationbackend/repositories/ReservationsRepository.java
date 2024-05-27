package sdia.reservationbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sdia.reservationbackend.entites.Reservation;

public interface ReservationsRepository extends JpaRepository<Reservation,Long> {
}
