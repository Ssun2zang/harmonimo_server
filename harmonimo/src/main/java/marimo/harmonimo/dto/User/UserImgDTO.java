package marimo.harmonimo.dto.User;

import lombok.Data;

@Data
public class UserImgDTO {
    private String uploadImg;

    public String getUploadImg() {
        return uploadImg;
    }

    public void setUploadImg(String uploadImg) {
        this.uploadImg = uploadImg;
    }
}
