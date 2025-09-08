package StackOverflow.Models;

import java.util.List;

import StackOverflow.Enums.PostType;

import java.time.LocalDateTime;

public class Question implements Post {

    private final String id;
    private final String content;
    private final User user;
    private final LocalDateTime createdAt;
    private final List<Tag> tags;

    public Question(String id, String content, User user, List<Tag> tags) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.tags = tags;
        this.createdAt = LocalDateTime.now();
    }

    @Override public String getId() { return id; }
    @Override public String getContent() { return content; }
    @Override public User getUser() { return user; }
    @Override public LocalDateTime getCreatedAt() { return createdAt; }
    @Override public PostType getPostType() { return PostType.QUESTION; }

    public List<Tag> getTags() { return tags; }
}
