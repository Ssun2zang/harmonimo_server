package marimo.harmonimo.domain;

import lombok.Getter;
import lombok.Setter;
import marimo.harmonimo.dto.User.UserDTO;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;

    @Column(name = "name")
    private String name;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "gender")
    private int gender;

    @Column(name = "old")
    private int old;

    @Column(name = "profileImg")
    private String profileImg;

    @Column(name = "AccountId")
    private String accountId;

    @Column(name = "password")
    private String password;

    public static User toUserEntity(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setNickname(userDTO.getNickname());
        user.setGender(userDTO.getGender());
        user.setOld(userDTO.getOld());
        user.setProfileImg(userDTO.getProfileImg());
        user.setAccountId(userDTO.getAccountId());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
