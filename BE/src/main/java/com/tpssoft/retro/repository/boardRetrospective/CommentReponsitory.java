package com.tpssoft.retro.repository.boardRetrospective;

import com.tpssoft.retro.model.boardRetrospective.Comment;
import com.tpssoft.retro.model.boardRetrospective.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentReponsitory extends JpaRepository<Comment,Long> {
    public List<Comment> findBydiscussionId(Long discussionId);
}