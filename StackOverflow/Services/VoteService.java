package StackOverflow.Services;

import java.util.UUID;

import StackOverflow.Models.Post;
import StackOverflow.Models.User;
import StackOverflow.Models.Vote;
import StackOverflow.Enums.VoteType;
import StackOverflow.Repos.VoteRepo;

public class VoteService {

    private final VoteRepo voteRepo;

    public VoteService(VoteRepo voteRepo) {
        this.voteRepo = voteRepo;
    }

    public Vote votePost(User user, Post post, VoteType voteType) {
        Vote vote = new Vote(UUID.randomUUID().toString(), user, post, voteType);
        voteRepo.save(vote);
        return vote;
    }
}
