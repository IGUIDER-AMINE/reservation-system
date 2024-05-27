package sdia.reservationbackend.dtos;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class SessionDTO {
    private Long id;
    private Date startTime;
    private Date endTime;
    private int maxReservations;
    private List<UserDTO> juryMembers;
    private List<ReservationDTO> reservations;

}
