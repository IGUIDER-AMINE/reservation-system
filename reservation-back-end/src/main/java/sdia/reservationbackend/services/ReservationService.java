package sdia.reservationbackend.services;

import sdia.reservationbackend.dtos.ReservationDTO;
import sdia.reservationbackend.dtos.SessionDTO;
import sdia.reservationbackend.dtos.UserDTO;
import sdia.reservationbackend.exceptions.ReservationNotFoundException;
import sdia.reservationbackend.exceptions.SessionNotFoundException;
import sdia.reservationbackend.exceptions.UserNotFoundException;

import java.util.List;

public interface ReservationService {
    // Consultation
    List<UserDTO> listUsers();
    List<ReservationDTO> ReservationList();
    List<SessionDTO> SessionList();

    // Get
    UserDTO getUser(Long userId) throws UserNotFoundException;
    ReservationDTO getReservation(Long reservationId) throws ReservationNotFoundException;
    SessionDTO getSession(Long sessionId) throws SessionNotFoundException;

    // Create
    UserDTO saveUser(UserDTO userDTO);
    ReservationDTO saveReservation(ReservationDTO reservationDTO);
    SessionDTO saveSession(SessionDTO sessionDTO);

    // Update
    UserDTO updateUser(UserDTO userDTO);
    ReservationDTO updateReservation(ReservationDTO reservationDTO);
    SessionDTO updateSession(SessionDTO sessionDTO);


    // Delete
    void deleteUser(Long userId);
    void deleteReservation(Long reservationId);
    void deleteSession(Long sessionId);

    UserDTO getJuryMember(Long sessionId, Long userId);
    //AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}
