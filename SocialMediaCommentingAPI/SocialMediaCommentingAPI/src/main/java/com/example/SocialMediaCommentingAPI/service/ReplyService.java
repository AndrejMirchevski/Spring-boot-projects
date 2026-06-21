package com.example.SocialMediaCommentingAPI.service;

import com.example.SocialMediaCommentingAPI.dto.CreateReplyRequest;
import com.example.SocialMediaCommentingAPI.entity.Comment;
import com.example.SocialMediaCommentingAPI.entity.Reply;
import com.example.SocialMediaCommentingAPI.exception.BusinessConflictException;
import com.example.SocialMediaCommentingAPI.repository.CommentRepository;
import com.example.SocialMediaCommentingAPI.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final CommentService commentService;

    //create a reply to a comment
    public Reply createReply(Long commentId, CreateReplyRequest request){
        Comment comment = commentService.getComment(commentId);
        if (!comment.getPost().getId().equals(request.getPostId())){
            throw new BusinessConflictException("reply must belong to the same post as the comment");
        }

        Reply reply = new Reply();
        reply.setAuthorName(request.getAuthorName());
        reply.setBody(request.getBody());
        reply.setComment(comment);
        reply.setPost(comment.getPost());

        return replyRepository.save(reply);
    }

}
