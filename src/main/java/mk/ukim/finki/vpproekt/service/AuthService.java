package mk.ukim.finki.vpproekt.service;

import mk.ukim.finki.vpproekt.model.User;

public interface AuthService {
    User login(String username, String password);
}
