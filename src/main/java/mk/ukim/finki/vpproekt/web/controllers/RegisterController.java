package mk.ukim.finki.vpproekt.web.controllers;

import mk.ukim.finki.vpproekt.model.Role;
import mk.ukim.finki.vpproekt.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.vpproekt.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.vpproekt.service.AuthService;
import mk.ukim.finki.vpproekt.service.StudentService;
import mk.ukim.finki.vpproekt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;
    private final UserService userService;
    private final StudentService studentService;

    public RegisterController(AuthService authService, UserService userService, StudentService studentService) {
        this.authService = authService;
        this.userService = userService;
        this.studentService = studentService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam Role role) {
        try{
            this.userService.register(username, password, repeatedPassword, role);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

}
