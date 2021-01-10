package pl.sda.finalapp.users;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegistrationValidator {
    //todo dopisanie walidacji dla reszty pól
    Map<String, String> isValid(RegistrationUserDto dto){
        Map<String, String> errors = new HashMap<>();

        if(dto.getFirstName() == null || !dto.getFirstName().matches("^[A-Z][a-z]{2,}$")){
            errors.put("firstNameError", "Imię jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe.");
        }

        return errors;
    }

}
