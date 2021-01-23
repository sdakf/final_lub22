package pl.sda.finalapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void registerUser(RegistrationUserDto dto) throws UserExistsException {
        //sprawzenie czy użytkownik istnieje
        Optional<User> byEmail = userRepository.findByEMail(dto.getEMail());
        if (byEmail.isPresent()) {
            throw new UserExistsException("Użytkownik o email " + byEmail.get().geteMail() + " już istnieje!");
        }
        //dodanie użytkownika do bazy
        User user = User.fromDto(dto);
        Role role = roleRepository.findByRoleName(Role.USER).orElseThrow(() -> new RuntimeException("Nie znaleziono roli!"));
        user.addRole(role);
        userRepository.save(user);
    }

}
