package com.example.SocialMediaCommentingAPI.service;

import com.example.SocialMediaCommentingAPI.entity.Post;
import com.example.SocialMediaCommentingAPI.exception.ResourceNotFoundException;
import com.example.SocialMediaCommentingAPI.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post getPostById(Long id){
        return postRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("missing post by id: " + id));
    }
}
