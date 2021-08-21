package main.model;


import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean is_active;
    @Enumerated(EnumType.STRING)
    private ModerationStatu moderation_status;
    private int moderator_id;
    private int user_id;
    private Date time;
    private String title;
    private String text;
    private int view_count;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostVotes> postVotes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<TagToPost> tagsToPost;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostComment> comments;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User moderatorUser;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TagsToPost",
            joinColumns = @JoinColumn(name = "postId"),
            inverseJoinColumns = @JoinColumn(name = "tagId"))
    private List<Tag> tags;

}
