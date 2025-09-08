package StackOverflow.Repos;

import java.util.*;
import StackOverflow.Models.Vote;

public class VoteRepo {
    private final Map<String, Vote> votes = new HashMap<>();

    public void save(Vote vote) { votes.put(vote.getId(), vote); }
    public List<Vote> findAll() { return new ArrayList<>(votes.values()); }
}
