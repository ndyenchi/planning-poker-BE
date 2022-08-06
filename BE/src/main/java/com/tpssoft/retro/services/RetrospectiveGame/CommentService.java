package com.tpssoft.retro.services.RetrospectiveGame;

import com.tpssoft.retro.dto.CommentDisDTO;
import com.tpssoft.retro.model.boardRetrospective.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    public List<Comment>listComment();
    public List<Comment> listCommentByDiscussionId(Long discussion_id) throws Exception;
    public Comment createComment(CommentDisDTO commentDisDTO) throws Exception;
}
