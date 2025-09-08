package StackOverflow.Models;

import java.time.LocalDateTime;

import StackOverflow.Enums.PostType;

public class Comment implements Post {
    private final String id;
    private final String content;
    private final User user;
    private final LocalDateTime createdAt;
    private final Post parentPost;

    public Comment(String id, String content, User user, Post parentPost) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.parentPost = parentPost;
        this.createdAt = LocalDateTime.now();
    }

    @Override public String getId() { return id; }
    @Override public String getContent() { return content; }
    @Override public User getUser() { return user; }
    @Override public LocalDateTime getCreatedAt() { return createdAt; }
    @Override public PostType getPostType() { return PostType.COMMENT; }

    public Post getParentPost() { return parentPost; }
}
