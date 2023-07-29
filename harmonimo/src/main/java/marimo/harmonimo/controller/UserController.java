package marimo.harmonimo.controller;

import marimo.harmonimo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
public class UserController {

//    @GetMapping("/member/save")
//    public String saveForm() {
//        return "save";
//    }

    @PostMapping("/register")    // name값을 requestparam에 담아온다
    public String save(@ModelAttribute UserDTO userDTO) {
        System.out.println("UserController.save");
        System.out.println("userDTO = " + userDTO);
//        userService.save(userDTO);

        return "index";
    }
}