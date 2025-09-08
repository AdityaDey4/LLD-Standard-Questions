package StackOverflow.Models;

import java.time.LocalDateTime;

import StackOverflow.Enums.PostType;

public class Answer implements Post {
    private final String id;
    private final String content;
    private final User user;
    private final LocalDateTime createdAt;
    private final Post parentPost;
    private boolean isAccepted;

    public Answer(String id, String content, User user, Post parentPost) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.parentPost = parentPost;
        this.createdAt = LocalDateTime.now();
        this.isAccepted = false;
    }

    @Override public String getId() { return id; }
    @Override public String getContent() { return content; }
    @Override public User getUser() { return user; }
    @Override public LocalDateTime getCreatedAt() { return createdAt; }
    @Override public PostType getPostType() { return PostType.ANSWER; }

    public Post getParentPost() { return parentPost; }
    public boolean isAccepted() { return isAccepted; }
    public void setAccepted(boolean accepted) { isAccepted = accepted; }
}
