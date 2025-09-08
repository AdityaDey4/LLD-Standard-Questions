package StackOverflow;

import StackOverflow.Models.*;
import StackOverflow.Enums.VoteType;
import StackOverflow.Repos.*;
import StackOverflow.Services.*;

import java.util.List;

public class StackOverflowSystem {

    private final UserService userService;
    private final PostService postService;
    private final VoteService voteService;
    private final ReputationService reputationService;

    public StackOverflowSystem() {
        UserRepo userRepo = new UserRepo();
        PostRepo postRepo = new PostRepo();
        VoteRepo voteRepo = new VoteRepo();

        this.reputationService = new ReputationService();
        this.voteService = new VoteService(voteRepo);
        this.postService = new PostService(postRepo, voteService, reputationService);
        this.userService = new UserService(userRepo);
    }

    // User methods
    public User registerUser(String name, String email) {
        return userService.addUser(name, email);
    }

    // Post methods
    public Question postQuestion(User user, String content, List<Tag> tags) {
        return postService.postQuestion(user, content, tags);
    }

    public Answer postAnswer(User user, String content, Question question) {
        return postService.postAnswer(user, content, question);
    }

    public Comment postComment(User user, String content, Post parentPost) {
        return postService.postComment(user, content, parentPost);
    }

    public void votePost(User user, Post post, VoteType voteType) {
        postService.votePost(user, post, voteType);
    }

    public void acceptAnswer(User user, Answer answer) {
        postService.acceptAnswer(user, answer);
    }

    public List<Answer> getAnswersForQuestion(Question question) {
        return postService.getAnswersForQuestion(question);
    }
}
