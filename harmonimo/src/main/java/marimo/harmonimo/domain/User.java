package marimo.harmonimo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "Id")
    private String Id;

    @Column(name = "password")
    private String password;


}
