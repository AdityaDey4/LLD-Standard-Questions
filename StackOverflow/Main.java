package StackOverflow;

import StackOverflow.Models.*;
import StackOverflow.Enums.VoteType;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        StackOverflowSystem soSystem = new StackOverflowSystem();

        User user1 = soSystem.registerUser("Aditya", "aditya@example.com");
        User user2 = soSystem.registerUser("Rudra", "rudra@example.com");

        Tag javaTag = new Tag("1", "Java");
        Tag lldTag = new Tag("2", "LLD");

        Question question = soSystem.postQuestion(user1, "How to design a StackOverflow?",
                Arrays.asList(javaTag, lldTag));

        Answer answer1 = soSystem.postAnswer(user2, "You should use facade and service layers.", question);
        Answer answer2 = soSystem.postAnswer(user2, "Also use repository pattern for storage.", question);

        // Question owner accepts an answer
        soSystem.acceptAnswer(user1, answer1);

        // Voting
        soSystem.votePost(user1, answer1, VoteType.UP);
        soSystem.votePost(user2, question, VoteType.UP);

        // Get all answers for a question
        soSystem.getAnswersForQuestion(question).forEach(a -> {
            String accepted = a.isAccepted() ? "Yes" : "No";
            System.out.println("Answer: " + a.getContent() + " | Accepted: " + accepted);
        });


        
        System.out.println(user1.getName() + " Reputation: " + user1.getReputation()); 
        System.out.println(user2.getName() + " Reputation: " + user2.getReputation()); 
    }
}
