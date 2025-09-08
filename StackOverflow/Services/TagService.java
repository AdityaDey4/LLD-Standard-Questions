package StackOverflow.Services;

import java.util.List;
import java.util.UUID;
import StackOverflow.Models.Tag;
import StackOverflow.Repos.TagRepo;

public class TagService {
    private final TagRepo tagRepo = new TagRepo();

    public Tag addTag(String name) {
        Tag tag = new Tag(UUID.randomUUID().toString(), name);
        tagRepo.save(tag);
        return tag;
    }

    public Tag getTagById(String id) { return tagRepo.findById(id); }

    public List<Tag> getAllTags() { return tagRepo.findAll(); }
}
