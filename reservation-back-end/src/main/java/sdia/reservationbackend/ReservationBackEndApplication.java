package sdia.reservationbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sdia.reservationbackend.dtos.UserDTO;
import sdia.reservationbackend.enums.Role;
import sdia.reservationbackend.services.ReservationService;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ReservationBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationBackEndApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ReservationService reservationService){
        return args -> {
            Stream.of("Hassan","Imane","Mohamed").forEach(name->{
                UserDTO user=new UserDTO();
                user.setUsername(name);
                user.setPassword("1234");
                user.setRole(Role.ADMIN);
                reservationService.saveUser(user);
            });
        };
    }

}
