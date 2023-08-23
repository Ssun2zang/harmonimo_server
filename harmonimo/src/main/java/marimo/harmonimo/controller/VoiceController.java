package marimo.harmonimo.controller;

import marimo.harmonimo.dto.User.UserImgDTO;
import marimo.harmonimo.dto.User.UserRecDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.file.Path;
import java.util.UUID;

@RestController
public class VoiceController {

    private static final String UPLOAD_DIR = "harmonimo/src/main/resources/static/uploadRec/";

    @PostMapping("/uploadRec")
    public ResponseEntity<UserRecDTO> uploadRecording(@RequestParam("recording") MultipartFile file) {
        UserRecDTO userRecDTO = new UserRecDTO();
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(userRecDTO);
        }

        try {
            byte[] bytes = file.getBytes();
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            System.out.println(path);
            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            Files.write(path, bytes);
            System.out.println("444");
            String imageUrl = "http://ec2-3-39-175-221.ap-northeast-2.compute.amazonaws.com:8080/uploadRec/" + fileName;
            userRecDTO.setUploadRec(imageUrl);
            return ResponseEntity.status(HttpStatus.OK).body(userRecDTO);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userRecDTO);
        }
    }
}
