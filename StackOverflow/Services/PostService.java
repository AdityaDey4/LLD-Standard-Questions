package StackOverflow.Services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import StackOverflow.Models.*;
import StackOverflow.Enums.VoteType;
import StackOverflow.Repos.PostRepo;

public class PostService {

    private final PostRepo postRepo;
    private final VoteService voteService;
    private final ReputationService reputationService;

    public PostService(PostRepo postRepo, VoteService voteService, ReputationService reputationService) {
        this.postRepo = postRepo;
        this.voteService = voteService;
        this.reputationService = reputationService;
    }

    public Question postQuestion(User user, String content, List<Tag> tags) {
        Question question = new Question(UUID.randomUUID().toString(), content, user, tags);
        postRepo.save(question);
        reputationService.rewardForQuestion(user);
        return question;
    }

    public Answer postAnswer(User user, String content, Question parentQuestion) {
        Answer answer = new Answer(UUID.randomUUID().toString(), content, user, parentQuestion);
        postRepo.save(answer);
        reputationService.rewardForAnswer(user);
        return answer;
    }

    public Comment postComment(User user, String content, Post parentPost) {
        Comment comment = new Comment(UUID.randomUUID().toString(), content, user, parentPost);
        postRepo.save(comment);
        return comment;
    }

    public void votePost(User voter, Post post, VoteType voteType) {
        voteService.votePost(voter, post, voteType);
        User postOwner = post.getUser();

        if (voteType == VoteType.UP) {
            reputationService.rewardUpvote(postOwner, post);
        } else {
            reputationService.penalizeDownvote(postOwner, voter);
        }
    }

    public void acceptAnswer(User user, Answer answer) {
        Post parent = answer.getParentPost();
        if (!(parent instanceof Question)) return;

        Question question = (Question) parent;
        if (!question.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Only the question owner can accept an answer.");
        }
        answer.setAccepted(true);
        reputationService.rewardAcceptedAnswer(answer.getUser());
    }

    public List<Answer> getAnswersForQuestion(Question question) {
        return postRepo.findAll().stream()
                .filter(p -> p instanceof Answer && ((Answer) p).getParentPost().getId().equals(question.getId()))
                .map(p -> (Answer) p)
                .collect(Collectors.toList());
    }
}
