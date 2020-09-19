package com.laundry.washer.controller;

import com.laundry.washer.model.PostRequest;
import com.laundry.washer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


// Post controller class handles all customers post and directs request flow
@Controller
public class PostController {


    @Autowired
    PostService postService;


//    Method that adds form input to the database and redirects to viewPost method handler
    @PostMapping("/addPost")
    public String addPost(PostRequest post) {
        postService.savePost(post);
        return "redirect:/viewPost";
    }


//    Method handler retrieves all data from table and adds it to a model
    @GetMapping("/viewPost")
    public String viewAllPost(Model model){
        model.addAttribute("posts", postService.getAllPost());
        return "pickup";
    }

// Method handle enables launderer to delete specific customer entry
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
        return "redirect:/viewPost";
    }

// Method handler enbles the launderer to edit a specific customer entry
    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable ("id") long id, Model model){
        model.addAttribute("post", postService.getPostById(id));
        postService.deletePost(id);
        return "edit";
    }

// Method handler for saving back edited post
    @PostMapping("/editpost")
    public String editUser( PostRequest post) {
        postService.savePost(post);
        return "redirect:/viewPost";
    }

}
