package marimo.harmonimo.controller;

import marimo.harmonimo.dto.User.UserImgDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;
import java.nio.file.Paths;


@RestController
@RequestMapping(produces = "application/json;charset=utf8")
public class ImageController {

    private static final String UPLOAD_DIR = "uploadImg/";

    @PostMapping("/uploadImg")
    public ResponseEntity<UserImgDTO> uploadImage(@RequestParam("file") MultipartFile file) {
        UserImgDTO userImgDTO = new UserImgDTO();
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(userImgDTO);
        }

        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            File saveFile = Paths.get(getClass().getClassLoader().getResource(UPLOAD_DIR).toURI()).resolve(fileName).toFile();
            file.transferTo(saveFile);

            String imageUrl = "http://ec2-3-39-175-221.ap-northeast-2.compute.amazonaws.com:8080/uploadImg/" + fileName;
            userImgDTO.setUploadImg(imageUrl);
            return ResponseEntity.status(HttpStatus.OK).body(userImgDTO);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userImgDTO);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
