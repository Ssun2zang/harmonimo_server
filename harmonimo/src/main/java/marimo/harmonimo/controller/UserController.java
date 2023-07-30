package marimo.harmonimo.controller;

import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.dto.User.UserRegisterDTO;
import marimo.harmonimo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping( produces = "application/json;charset=utf8")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRegisterDTO userRegisterDTO){
        userService.save(userRegisterDTO);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers(@ModelAttribute UserDTO userDTO) {
        List<UserDTO> result = userService.getUsers();
        return result;
    }
}