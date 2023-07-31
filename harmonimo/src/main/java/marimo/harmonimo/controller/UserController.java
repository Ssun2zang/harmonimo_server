package marimo.harmonimo.controller;

import marimo.harmonimo.dto.User.UserDTO;
import marimo.harmonimo.dto.User.UserIdDTO;
import marimo.harmonimo.dto.User.UserLoginDTO;
import marimo.harmonimo.dto.User.UserRegisterDTO;
import marimo.harmonimo.service.UserService;
import org.springframework.http.ResponseEntity;
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
        return;
    }

    @GetMapping("/login")
    public ResponseEntity<UserIdDTO> login(@RequestBody UserLoginDTO userLoginDTO){  //userId DTO로변경
        UserIdDTO loginResult = new UserIdDTO();
        if (userService.login(userLoginDTO) != null) {
            loginResult = userService.login(userLoginDTO);
            return ResponseEntity.ok(userService.login(userLoginDTO));
        } else{
            return ResponseEntity.badRequest().body(loginResult);
        }
    }

    @GetMapping("/users/{accountId}/exist")
    public ResponseEntity<Boolean> checkAccountIdDuplicate(@PathVariable String accountId){
        return ResponseEntity.ok(userService.checkAccountIdDuplicate(accountId));
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers(@ModelAttribute UserDTO userDTO) {
        List<UserDTO> result = userService.getUsers();
        return result;
    }
}