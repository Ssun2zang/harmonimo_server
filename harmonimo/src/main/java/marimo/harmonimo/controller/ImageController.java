import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping(produces = "application/json;charset=utf8")
public class ImageController {

    private static final String UPLOAD_DIR = "/home/ubuntu/.ssh/harmonimo_server/harmonimo/build/resources/main/static/uploadImg/";

    @PostMapping("/uploadImg")
    public ResponseEntity<UserImgDTO> uploadImage(@RequestParam("file") MultipartFile file) {
        UserImgDTO userImgDTO = new UserImgDTO();
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(userImgDTO);
        }

        try {
            // 폴더 존재 여부 확인 및 생성
            File uploadFolder = new File(UPLOAD_DIR);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
            }

            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            File saveFile = new File(UPLOAD_DIR + fileName);
            file.transferTo(saveFile);

            String imageUrl = "http://ec2-3-39-175-221.ap-northeast-2.compute.amazonaws.com:8080/uploadImg/" + fileName;
            userImgDTO.setUploadImg(imageUrl);
            return ResponseEntity.status(HttpStatus.OK).body(userImgDTO);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userImgDTO);
        }
    }
}
