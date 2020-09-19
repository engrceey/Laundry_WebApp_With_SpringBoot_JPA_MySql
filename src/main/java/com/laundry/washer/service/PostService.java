package com.laundry.washer.service;

import com.laundry.washer.model.PostRequest;

import java.util.List;
import java.util.Optional;

// PostService interface that states methods to be used on data
public interface PostService {

//    method signature for handling saving of data
    void savePost(PostRequest post);

//    method signature for handling the fetching of our datas
    List<PostRequest> getAllPost();

//    method signature for deleting a specific post
    void deletePost(Long id);

//    method signature for seleting a specific post
    Optional<PostRequest> getPostById(Long id);

}
