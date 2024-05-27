package sdia.reservationbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sdia.reservationbackend.dtos.ReservationDTO;
import sdia.reservationbackend.dtos.SessionDTO;
import sdia.reservationbackend.dtos.UserDTO;
import sdia.reservationbackend.exceptions.ReservationNotFoundException;
import sdia.reservationbackend.exceptions.SessionNotFoundException;
import sdia.reservationbackend.exceptions.UserNotFoundException;
import sdia.reservationbackend.services.ReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class SessionRestController {
    private ReservationService reservationService;
    @GetMapping("/sessions")
    public List<SessionDTO> SessionList(){
        return reservationService.SessionList();
    }

    @GetMapping("/sessions/{id}")
    public SessionDTO getSession(@PathVariable(name = "id") Long sessionId) throws SessionNotFoundException {
        return reservationService.getSession(sessionId);
    }

    @PostMapping("/session")
    public SessionDTO saveSession(@RequestBody SessionDTO sessionDTO){
        return reservationService.saveSession(sessionDTO);
    }

    @PutMapping("/sessions/{sessionId}")
    public SessionDTO updateSession(@PathVariable Long sessionId, @RequestBody SessionDTO sessionDTO){
        sessionDTO.setId(sessionId);
        return reservationService.updateSession(sessionDTO);
    }

    @DeleteMapping("/sessions/{id}")
    public void deleteSession(@PathVariable Long id){
        reservationService.deleteSession(id);
    }

}
