package com.laundry.washer.serviceImpl;

import com.laundry.washer.model.PostRequest;
import com.laundry.washer.repository.PostRepository;
import com.laundry.washer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service class for implementing business logic on the post data
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

//    implementation of save post to database
    @Override
    public void savePost(PostRequest post) {
    postRepository.save(post);
    }

    //    implementation of fetching post from database
    @Override
    public List<PostRequest> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Optional<PostRequest> getPostById(Long id) {
        return postRepository.findById(id);
    }


}
