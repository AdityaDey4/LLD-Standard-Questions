package StackOverflow.Models;

import StackOverflow.Enums.VoteType;

public class Vote {
    private final String id;
    private final User user;
    private final Post post;
    private final VoteType voteType;

    public Vote(String id, User user, Post post, VoteType voteType) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.voteType = voteType;
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public Post getPost() { return post; }
    public VoteType getVoteType() { return voteType; }
}
