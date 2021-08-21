package main.model;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name="tag2post")
public class TagToPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="post_id")
    private int postId;
    @Column(name="tag_id")
    private int tagId;
}
