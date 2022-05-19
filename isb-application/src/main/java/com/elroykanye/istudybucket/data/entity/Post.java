package com.elroykanye.istudybucket.data.entity;

import com.elroykanye.istudybucket.data.enums.PostType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elroy Kanye
 *
 * Modified By: Elroy Kanye
 * Modified Date: 12/05/2022
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "post_title", length = 32)
    private String postTitle;

    @Column(name = "content", length = 512)
    private String content;

    @Column(name = "post_type", length = 16)
    private PostType postType;

    @Builder.Default
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now(); //set created date to today's date by default

    // many to one relationship to User entity (author)
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User author;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    @ToString.Exclude
    @Builder.Default
    private List<Vote> votes = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "source_post_post_id")
    private Post sourcePost;

    @OneToMany(mappedBy = "sourcePost", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @Builder.Default
    private List<Post> comments = new ArrayList<>();
}
