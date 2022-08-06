package com.tpssoft.retro.services.RetrospectiveGame;

import com.tpssoft.retro.dto.VoteDiscussionDTO;
import com.tpssoft.retro.model.boardRetrospective.VoteDiscussion;
import org.springframework.stereotype.Service;

@Service
public interface VoteDiscussionService {
    public VoteDiscussion saveDownUpVote(VoteDiscussionDTO voteDiscussionDTO) throws Exception;
    public VoteDiscussion saveDownVote(VoteDiscussionDTO voteDiscussionDTO) throws Exception;
    public VoteDiscussion saveUpVote(VoteDiscussionDTO voteDiscussionDTO) throws Exception;
    public Long countVoteByDiscussion(Long discussionId);
    public Long countUnVoteByDiscussion(Long discussionId);
}
