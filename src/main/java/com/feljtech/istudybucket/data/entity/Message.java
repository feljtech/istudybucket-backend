package com.feljtech.istudybucket.data.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author Andrew Tatah
 *
 * Modified By: Elroy Kanye
 * Modified Date: 07-09-2021
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;

    @Column(name = "content")
    private String content;

    @Column(name = "sender_id")
    private Long senderId;

    // many to one relationship to Chat entity
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chat_id", nullable = false)
    @ToString.Exclude
    private Chat chat;

    // many to one relationship with user
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User user;

}
