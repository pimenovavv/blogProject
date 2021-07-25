package main.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name="Post_comments")
public class PostComments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="parent_id")
    private int parentId;
    @Column(name="post_id")
    private int postId;
    @Column(name="user_id")
    private int userId;
    private Date time;
    private String text;

}
