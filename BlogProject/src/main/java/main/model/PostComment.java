package main.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name="post_comments")
public class PostComment {
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

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name="post_id", insertable = false, updatable = false)
    private Post post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private PostComment commentsForComment;
}
