package mk.ukim.finki.vpproekt.service.impl;


import mk.ukim.finki.vpproekt.model.Role;
import mk.ukim.finki.vpproekt.model.User;
import mk.ukim.finki.vpproekt.model.exceptions.InvalidUsernameOrPasswordException;
import mk.ukim.finki.vpproekt.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.vpproekt.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.vpproekt.repository.jpa.UserRepository;
import mk.ukim.finki.vpproekt.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }


    @Override
    public User register(String username, String password, String repeatPassword, Role userRole) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username,passwordEncoder.encode(password),userRole);
        return userRepository.save(user);
    }
}
