package StackOverflow.Models;

import java.time.LocalDateTime;

import StackOverflow.Enums.PostType;

public interface Post {
    String getId();
    String getContent();
    User getUser();
    LocalDateTime getCreatedAt();
    PostType getPostType();
}