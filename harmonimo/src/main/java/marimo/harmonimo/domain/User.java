package marimo.harmonimo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
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

    @Column(name = "Id")
    private String Id;

    @Column(name = "password")
    private String password;


    // 생성자, 게터 및 세터 등 필요한 메서드들 추가

    // 기본 생성자
    public User() {
    }

    // 생성자 (모든 필드)
    public User(long userId, String name, String nickname, int gender, int old, String profileImg, String Id, String password) {
        this.userId = userId;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.old = old;
        this.profileImg = profileImg;
        this.Id = Id;
        this.password = password;
    }

    // 게터 및 세터 (getter and setter) 메서드들 추가

    public long getUserId() {
        return userId;
    }
}
