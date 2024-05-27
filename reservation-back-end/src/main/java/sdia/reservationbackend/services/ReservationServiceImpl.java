package sdia.reservationbackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdia.reservationbackend.dtos.ReservationDTO;
import sdia.reservationbackend.dtos.SessionDTO;
import sdia.reservationbackend.dtos.UserDTO;
import sdia.reservationbackend.entites.Reservation;
import sdia.reservationbackend.entites.Session;
import sdia.reservationbackend.entites.User;
import sdia.reservationbackend.exceptions.ReservationNotFoundException;
import sdia.reservationbackend.exceptions.SessionNotFoundException;
import sdia.reservationbackend.exceptions.UserNotFoundException;
import sdia.reservationbackend.mappers.ReservationsMapperImpl;
import sdia.reservationbackend.repositories.ReservationsRepository;
import sdia.reservationbackend.repositories.SessionsRepository;
import sdia.reservationbackend.repositories.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private UsersRepository usersRepository;
    private SessionsRepository sessionsRepository;
    private ReservationsRepository reservationsRepository;
    private ReservationsMapperImpl dtoMapper;
    @Override
    public List<UserDTO> listUsers() {
        List<User> users = usersRepository.findAll();
        List<UserDTO> UserDTOS = users.stream()
                .map(user -> dtoMapper.fromUser(user))
                .collect(Collectors.toList());
        return UserDTOS;
    }
    @Override
    public List<ReservationDTO> ReservationList() {
        List<Reservation> reservations = reservationsRepository.findAll();
        List<ReservationDTO> ReservationDTOS = reservations.stream()
                .map(reservation -> dtoMapper.fromReservation(reservation))
                .collect(Collectors.toList());
        return ReservationDTOS;
    }
    @Override
    public List<SessionDTO> SessionList() {
        List<Session> sessions = sessionsRepository.findAll();
        List<SessionDTO> SessionDTOS = sessions.stream()
                .map(session -> dtoMapper.fromSession(session))
                .collect(Collectors.toList());
        return SessionDTOS;
    }
    @Override
    public UserDTO getUser(Long userId) throws UserNotFoundException {
        User user = usersRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User Not found"));
        return dtoMapper.fromUser(user);
    }

    @Override
    public ReservationDTO getReservation(Long reservationId) throws ReservationNotFoundException {
        Reservation reservation = reservationsRepository.findById(reservationId)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation Not found"));
        return dtoMapper.fromReservation(reservation);
    }

    @Override
    public SessionDTO getSession(Long sessionId) throws SessionNotFoundException {
        Session session = sessionsRepository.findById(sessionId)
                .orElseThrow(() -> new SessionNotFoundException("Session Not found"));
        return dtoMapper.fromSession(session);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user=dtoMapper.fromUserDTO(userDTO);
        User savedUser = usersRepository.save(user);
        return dtoMapper.fromUser(savedUser);
    }

    @Override
    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
        Reservation reservation=dtoMapper.fromReservationDTO(reservationDTO);
        Reservation savedReservation = reservationsRepository.save(reservation);
        return dtoMapper.fromReservation(savedReservation);
    }

    @Override
    public SessionDTO saveSession(SessionDTO sessionDTO) {
        Session session=dtoMapper.fromSessionDTO(sessionDTO);
        Session savedSession = sessionsRepository.save(session);
        return dtoMapper.fromSession(savedSession);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user=dtoMapper.fromUserDTO(userDTO);
        User savedUser = usersRepository.save(user);
        return dtoMapper.fromUser(savedUser);
    }

    @Override
    public ReservationDTO updateReservation(ReservationDTO reservationDTO) {
        Reservation reservation =dtoMapper.fromReservationDTO(reservationDTO);
        Reservation savedReservation = reservationsRepository.save(reservation);
        return dtoMapper.fromReservation(savedReservation);
    }

    @Override
    public SessionDTO updateSession(SessionDTO sessionDTO) {
        Session session =dtoMapper.fromSessionDTO(sessionDTO);
        Session savedSession = sessionsRepository.save(session);
        return dtoMapper.fromSession(savedSession);
    }

    @Override
    public void deleteUser(Long userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationsRepository.deleteById(reservationId);
    }

    @Override
    public void deleteSession(Long sessionId) {
        sessionsRepository.deleteById(sessionId);
    }

    @Override
    public UserDTO getJuryMember(Long sessionId, Long userId) {
        return null;
    }
}
