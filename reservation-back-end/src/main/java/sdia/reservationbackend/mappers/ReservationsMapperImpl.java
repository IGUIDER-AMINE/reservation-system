package sdia.reservationbackend.mappers;

import org.springframework.beans.BeanUtils;
import sdia.reservationbackend.dtos.ReservationDTO;
import sdia.reservationbackend.dtos.SessionDTO;
import sdia.reservationbackend.dtos.UserDTO;
import sdia.reservationbackend.entites.Reservation;
import sdia.reservationbackend.entites.Session;
import sdia.reservationbackend.entites.User;

public class ReservationsMapperImpl {
    public UserDTO fromUser(User user){
        UserDTO userDTO=new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return  userDTO;
    }
    public User fromUserDTO(UserDTO userDTO){
        User user=new User();
        BeanUtils.copyProperties(userDTO,user);
        return  user;
    }

    //Session mappers

    public SessionDTO fromSession(Session session){
        SessionDTO sessionDTO=new SessionDTO();
        BeanUtils.copyProperties(session,sessionDTO);
        return  sessionDTO;
    }
    public Session fromSessionDTO(SessionDTO sessionDTO){
        Session session=new Session();
        BeanUtils.copyProperties(sessionDTO,session);
        return  session;
    }

    //Reservation mappers

    public ReservationDTO fromReservation(Reservation reservation){
        ReservationDTO reservationDTO=new ReservationDTO();
        BeanUtils.copyProperties(reservation,reservationDTO);
        return  reservationDTO;
    }
    public Reservation fromReservationDTO(ReservationDTO reservationDTO){
        Reservation reservation=new Reservation();
        BeanUtils.copyProperties(reservationDTO,reservation);
        return  reservation;
    }
}
