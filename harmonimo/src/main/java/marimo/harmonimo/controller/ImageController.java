package marimo.harmonimo.controller;

import marimo.harmonimo.dto.User.UserImgDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping(produces = "application/json;charset=utf8")
public class ImageController {

    private static final String UPLOAD_DIR = "../../src/main/resources/static/uploadImg/";

    @PostMapping("/uploadImg")
    public ResponseEntity<UserImgDTO> uploadImage(@RequestParam("file") MultipartFile file) {
        UserImgDTO userImgDTO = new UserImgDTO();
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userImgDTO); // 파일이 비어있을 경우 BAD_REQUEST 리턴
        }

        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            // 파일 저장 경로 생성
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());

            // 파일 저장
            Files.write(path, file.getBytes());

            String imageUrl = "http://ec2-3-39-175-221.ap-northeast-2.compute.amazonaws.com:8080/uploadImg/" + fileName;
            userImgDTO.setUploadImg(imageUrl);
            return ResponseEntity.status(HttpStatus.OK).body(userImgDTO);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userImgDTO);
        }
    }
}
