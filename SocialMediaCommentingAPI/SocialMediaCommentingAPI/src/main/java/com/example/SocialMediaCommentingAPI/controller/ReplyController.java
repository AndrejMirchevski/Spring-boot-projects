package com.example.SocialMediaCommentingAPI.controller;

import com.example.SocialMediaCommentingAPI.dto.CreateReplyRequest;
import com.example.SocialMediaCommentingAPI.entity.Reply;
import com.example.SocialMediaCommentingAPI.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    //POST posting a reply on a comment
    @PostMapping("/{commentId}/replies")
    public Reply createReply(
            @PathVariable Long commentId,
            @Valid @RequestBody CreateReplyRequest request){
        return replyService.createReply(commentId, request);
    }

    /*@GetMapping("/{commentId}/replies")
    public Object getReplies(@PathVariable Long commentId){
        return replyServ
    }*/

}
