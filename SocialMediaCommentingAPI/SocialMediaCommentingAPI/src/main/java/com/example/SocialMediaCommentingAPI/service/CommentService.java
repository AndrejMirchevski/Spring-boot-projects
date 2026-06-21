package com.example.SocialMediaCommentingAPI.service;

import com.example.SocialMediaCommentingAPI.dto.CreateCommentRequest;
import com.example.SocialMediaCommentingAPI.entity.Comment;
import com.example.SocialMediaCommentingAPI.entity.Post;
import com.example.SocialMediaCommentingAPI.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    // comment creating
    public Comment createComment(Long postId, CreateCommentRequest request){
        Post post = postService.getPostById(postId);

        Comment comment = new Comment();
        comment.setAuthorName(request.getAuthorName());
        comment.setBody(request.getBody());
        comment.setPost(post);

        return commentRepository.save(comment);
    }

    //Get comments (with pagination)
    public Page<Comment> getComments(Long postId, Pageable pageable) {
        return commentRepository.findByPostIdAndDeletedAtNull(postId, pageable);
    }

    //Get single comment
    public Comment getComment(Long id){
        return commentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Comment by that id is not found"));
    }

    //Hide a comment
    public Comment hideComment(Long id){
        Comment comment = getComment(id);
        comment.setHidden(true);
        return commentRepository.save(comment);
    }

    //soft delete
    public Comment deleteComment(Long id){
        Comment comment = getComment(id);
        comment.setDeletedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    //Like a comment
    public Comment likeAComment(Long id){
        Comment comment = getComment(id);
        comment.setLikes(comment.getLikes() + 1);
        return commentRepository.save(comment);
    }
}
