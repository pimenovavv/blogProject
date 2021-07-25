package main.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean is_active;
    @Enumerated(EnumType.STRING)
    private ModerationStatus moderation_status;
    private int moderator_id;
    private int user_id;
    private Date time;
    private String title;
    private String text;
    private int view_count;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<PostVotes> postVotes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<TagToPost> tagsToPost;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<PostComments> comments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TagsToPost",
            joinColumns = @JoinColumn(name = "postId"),
            inverseJoinColumns = @JoinColumn(name = "tagId"))
    private List<Tags> tags;

}
