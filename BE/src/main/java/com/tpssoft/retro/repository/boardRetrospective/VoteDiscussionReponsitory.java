package com.tpssoft.retro.repository.boardRetrospective;
import com.tpssoft.retro.model.boardRetrospective.VoteDiscussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface VoteDiscussionReponsitory extends JpaRepository<VoteDiscussion,Long> {
    VoteDiscussion findVoteDiscussionByDiscussionIdAndUserId(Long discussionId, Long userId);
    @Query("SELECT COUNT(u.vote) FROM VoteDiscussion u WHERE u.vote=true and  u.discussion.id=?1")
    Long countByVote(Long discussionId);

    @Query("SELECT COUNT(u.unvote) FROM VoteDiscussion u WHERE u.unvote=true and  u.discussion.id=?1")
    Long countByUnvote(Long discussionId);
}
