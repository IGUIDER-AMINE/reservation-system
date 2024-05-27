package sdia.reservationbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sdia.reservationbackend.entites.Session;

public interface SessionsRepository extends JpaRepository<Session,Long> {
}
