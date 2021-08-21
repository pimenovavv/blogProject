package main.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TagsToPost",
            joinColumns = @JoinColumn(name = "tagId"),
            inverseJoinColumns = @JoinColumn(name = "postId"))
    private List<Post> posts;
}
