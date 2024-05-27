package sdia.reservationbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sdia.reservationbackend.dtos.UserDTO;
import sdia.reservationbackend.exceptions.UserNotFoundException;
import sdia.reservationbackend.services.ReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class UserRestController {
    private ReservationService reservationService;

    @GetMapping("/users")
    public List<UserDTO> listUsers(){
        return reservationService.listUsers();
    }

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long userId) throws UserNotFoundException {
        return reservationService.getUser(userId);
    }

    @PostMapping("/user")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return reservationService.saveUser(userDTO);
    }

    @PutMapping("/users/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO){
        userDTO.setId(userId);
        return reservationService.updateUser(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        reservationService.deleteUser(id);
    }

}
