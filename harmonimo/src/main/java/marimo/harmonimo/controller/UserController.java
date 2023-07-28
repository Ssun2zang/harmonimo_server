package marimo.harmonimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@RestController
public class UserController {
    @GetMapping("/custom")
    public ResponseEntity<String> customResponse() {
        String responseBody = "This is a custom response!";
        return ResponseEntity.status(HttpStatus.OK).body(responseBody); // 상태 코드 200 OK와 JSON 바디만 반환
    }
}