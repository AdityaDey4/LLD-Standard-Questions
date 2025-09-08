package StackOverflow.Repos;

import java.util.*;
import StackOverflow.Models.Tag;

public class TagRepo {
    private final Map<String, Tag> tags = new HashMap<>();

    public void save(Tag tag) { tags.put(tag.getId(), tag); }
    public Tag findById(String id) { return tags.get(id); }
    public List<Tag> findAll() { return new ArrayList<>(tags.values()); }
}
