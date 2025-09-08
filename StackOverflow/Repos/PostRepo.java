package StackOverflow.Repos;

import java.util.*;
import StackOverflow.Models.Post;

public class PostRepo {
    private final Map<String, Post> posts = new HashMap<>();

    public void save(Post post) { posts.put(post.getId(), post); }
    public Post findById(String id) { return posts.get(id); }
    public List<Post> findAll() { return new ArrayList<>(posts.values()); }
}
