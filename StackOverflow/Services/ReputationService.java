package StackOverflow.Services;

import StackOverflow.Models.*;

public class ReputationService {

    public void rewardForQuestion(User user) {
        user.addReputation(5);
    }

    public void rewardForAnswer(User user) {
        user.addReputation(10);
    }

    public void rewardUpvote(User postOwner, Post post) {
        if (post instanceof Answer) {
            postOwner.addReputation(15);
        } else if (post instanceof Question) {
            postOwner.addReputation(5);
        }
    }

    public void penalizeDownvote(User postOwner, User voter) {
        postOwner.reduceReputation(2);
        voter.reduceReputation(1);
    }

    public void rewardAcceptedAnswer(User answerOwner) {
        answerOwner.addReputation(50);
    }
}
