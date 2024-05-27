package sdia.reservationbackend.dtos;

import lombok.Data;
import sdia.reservationbackend.enums.Role;
import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private List<SessionDTO> sessionsAsJury;

}
