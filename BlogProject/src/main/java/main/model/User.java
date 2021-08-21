package main.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="is_moderator")
    private boolean isModerator;
    @Column(name="reg_time")
    private Date regTime;
    private String name;
    private String email;
    private String password;
    private int code;
    private String photo;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PostVotes> postVotes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PostComment> comments;


}
