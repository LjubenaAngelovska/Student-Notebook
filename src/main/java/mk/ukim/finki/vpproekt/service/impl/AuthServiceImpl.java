package mk.ukim.finki.vpproekt.service.impl;

import mk.ukim.finki.vpproekt.model.User;
import mk.ukim.finki.vpproekt.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.vpproekt.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.vpproekt.repository.jpa.UserRepository;
import mk.ukim.finki.vpproekt.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}
