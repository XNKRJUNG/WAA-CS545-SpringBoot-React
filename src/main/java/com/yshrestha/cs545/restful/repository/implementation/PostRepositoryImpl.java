package com.yshrestha.cs545.restful.repository.implementation;

import com.yshrestha.cs545.restful.entity.Post;
import com.yshrestha.cs545.restful.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private static final List<Post> posts;
    private static long postId;

    static {
        posts = new ArrayList<>();
        Post p1 = new Post(1000, "Winter in Iowa", "The weather has reached to -28°C. It is very cold outside", "IowaNews");
        Post p2 = new Post(1001, "Using MRI scans to massage brain 'could ease depression symptoms for up to SIX months'", "Depressed patients could see their symptoms eased for up to six months through targeted brain stimulation using MRI scans. Transcranial magnetic stimulation (TMS) has been used to treat severe depression since the 1980s.It involves targeting areas of the brain linked with depression with magnetic pulses and was previously found to ease symptoms for up to three months", "EMILY CRAIG");

        posts.add(p1);
        posts.add(p2);
        postId = posts.get(posts.size() - 1).getId();
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Post p) {
        p.setId(++postId);
        posts.add(p);
    }
}
