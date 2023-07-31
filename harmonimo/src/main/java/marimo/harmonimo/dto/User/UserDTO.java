package marimo.harmonimo.dto.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import marimo.harmonimo.domain.User;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    private Long  userId;
    private String name;
    private String nickname;
    private int gender;
    private int old;
    private String profileImg = "url1";
    private String accountId;
    private String password;

    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setNickname(user.getNickname());
        userDTO.setGender(user.getGender());
        userDTO.setOld(user.getOld());
        userDTO.setProfileImg(user.getProfileImg());
        userDTO.setAccountId(user.getAccountId());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String id) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //lombok 어노테이션으로 getter,setter,생성자,toString 메서드 생략 가능



}
