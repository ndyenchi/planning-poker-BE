package com.tpssoft.retro.controller.RetrosectiveGame;

import com.tpssoft.retro.dto.CommentDisDTO;
import com.tpssoft.retro.model.boardRetrospective.Comment;
import com.tpssoft.retro.model.boardRetrospective.Discussion;
import com.tpssoft.retro.repository.boardRetrospective.CommentReponsitory;
import com.tpssoft.retro.repository.boardRetrospective.DiscussionReponsitory;
import com.tpssoft.retro.services.RetrospectiveGame.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/retrospective/comments")
public class CommentController {
    @Autowired
    private CommentReponsitory commentReponsitory;
    @Autowired
    DiscussionReponsitory discussionReponsitory;
    @Autowired
    CommentService commentService;

    @GetMapping("/discussions/{discussion_id}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable long discussion_id) throws Exception {
        Discussion discussion = discussionReponsitory.findById(discussion_id)
                .orElseThrow(() -> new Exception("Not find Discussion"));
        return ResponseEntity.ok(commentReponsitory.findBydiscussionId(discussion.getId()));
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getComments() {
        return ResponseEntity.ok(commentService.listComment());
    }
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentDisDTO commentDisDTO) throws Exception {
        return ResponseEntity.ok(commentService.createComment(commentDisDTO));
    }
}
