package com.example.SocialMediaCommentingAPI.controller;

import com.example.SocialMediaCommentingAPI.dto.CreateCommentRequest;
import com.example.SocialMediaCommentingAPI.entity.Comment;
import com.example.SocialMediaCommentingAPI.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //posting a comment on a post /post/{postid}/comment

    @PostMapping("/{postId}/comments")
    public Comment createComment(
            @PathVariable Long postId,
            @Valid @RequestBody CreateCommentRequest request){
        return commentService.createComment(postId, request);
    }

    //GET comments on a post
    @GetMapping("/{postId}/comments")
    public Page<Comment> getComments(
            @PathVariable Long postId,
            Pageable pageable){
        return commentService.getComments(postId, pageable);
    }

    //3 getting single comment
    @GetMapping("/comments/{id}")
    public Comment singleComment(@PathVariable Long id){
        return commentService.getComment(id);
    }

    //4 Like a comment
    @PostMapping("/comments/{id}/like")
    public Comment likeComment(@PathVariable Long id){
        return commentService.likeAComment(id);
    }

    //5 hide a comment
    @PatchMapping("/comments/{id}")
    public Comment hideAComment(@PathVariable Long id){
        return commentService.hideComment(id);
    }

    //6 Soft delete a comment
    @DeleteMapping("/comments/{id}")
    public void deleteAComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }
}
