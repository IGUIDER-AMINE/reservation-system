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
public class ReservationRestController {
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public List<ReservationDTO> ReservationList(){
        return reservationService.ReservationList();
    }
    @GetMapping("/reservations/{id}")
    public ReservationDTO getReservation(@PathVariable(name = "id") Long reservationId) throws ReservationNotFoundException {
        return reservationService.getReservation(reservationId);
    }

    @PostMapping("/reservation")
    public ReservationDTO saveReservation(@RequestBody ReservationDTO reservationDTO){
        return reservationService.saveReservation(reservationDTO);
    }

    @PutMapping("/reservations/{reservationId}")
    public ReservationDTO updateReservation(@PathVariable Long reservationId, @RequestBody ReservationDTO reservationDTO){
        reservationDTO.setId(reservationId);
        return reservationService.updateReservation(reservationDTO);
    }

    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
    }
}
