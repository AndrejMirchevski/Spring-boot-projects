package com.example.SocialMediaCommentingAPI.controller;

import com.example.SocialMediaCommentingAPI.entity.Post;
import com.example.SocialMediaCommentingAPI.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postRepository.save(post);
    }
}