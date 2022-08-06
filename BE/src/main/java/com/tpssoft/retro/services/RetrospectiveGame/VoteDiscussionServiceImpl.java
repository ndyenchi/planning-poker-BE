package com.tpssoft.retro.services.RetrospectiveGame;

import com.tpssoft.retro.dto.VoteDiscussionDTO;
import com.tpssoft.retro.model.User;
import com.tpssoft.retro.model.boardRetrospective.Discussion;
import com.tpssoft.retro.model.boardRetrospective.VoteDiscussion;
import com.tpssoft.retro.repository.UserRepository;
import com.tpssoft.retro.repository.boardRetrospective.DiscussionReponsitory;
import com.tpssoft.retro.repository.boardRetrospective.VoteDiscussionReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteDiscussionServiceImpl implements VoteDiscussionService {
    @Autowired
    private VoteDiscussionReponsitory voteDiscussionReponsitory;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DiscussionReponsitory discussionReponsitory;

    @Override
    public VoteDiscussion saveDownUpVote(VoteDiscussionDTO voteDiscussionDTO) throws Exception {
        VoteDiscussion voteDiscussion1 = null;
        if (voteDiscussionDTO.getDiscussionId() != null && voteDiscussionDTO.getUserId() != null) {
            VoteDiscussion findVoteDiscussionByDiscussionIdAndUserId = voteDiscussionReponsitory
                    .findVoteDiscussionByDiscussionIdAndUserId(voteDiscussionDTO.getDiscussionId(),
                            voteDiscussionDTO.getUserId());
            if (findVoteDiscussionByDiscussionIdAndUserId != null) {
                findVoteDiscussionByDiscussionIdAndUserId.setVote(voteDiscussionDTO.isLike());
                findVoteDiscussionByDiscussionIdAndUserId.setUnvote(voteDiscussionDTO.isUnlike());
                voteDiscussion1 = voteDiscussionReponsitory.save(findVoteDiscussionByDiscussionIdAndUserId);
                //
                Discussion discussionNumberVote=discussionReponsitory.findById(voteDiscussionDTO.getDiscussionId())
                        .orElseThrow(()->new Exception("not find discussion id =" + voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberVote(countVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberUnvote(countUnVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionReponsitory.save(discussionNumberVote);
                //
                return voteDiscussion1;
            } else {
                VoteDiscussion voteDiscussion = new VoteDiscussion();
                voteDiscussion.setVote(voteDiscussionDTO.isLike());
                voteDiscussion.setUnvote(voteDiscussionDTO.isUnlike());

                Discussion discussion = discussionReponsitory.findById(voteDiscussionDTO.getDiscussionId())
                        .orElseThrow(() -> new Exception("not find discussion id =" + voteDiscussionDTO.getDiscussionId()));
                voteDiscussion.setDiscussion(discussion);
                User user = userRepository.findById(voteDiscussionDTO.getUserId())
                        .orElseThrow(() -> new Exception("not find user id =" + voteDiscussionDTO.getUserId()));
                voteDiscussion.setUser(user);
                voteDiscussion1= voteDiscussionReponsitory.save(voteDiscussion);
                 //
                Discussion discussionNumberVote=discussionReponsitory.findById(voteDiscussionDTO.getDiscussionId())
                        .orElseThrow(()->new Exception("not find discussion id =" + voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberVote(countVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberUnvote(countUnVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionReponsitory.save(discussionNumberVote);
                return voteDiscussion1;
            }

        }
        return voteDiscussion1;
    }
    @Override
    public Long countVoteByDiscussion(Long discussionId){
        Long count =voteDiscussionReponsitory.countByVote(discussionId);
        return count;
    }

    @Override
    public Long countUnVoteByDiscussion(Long discussionId) {
        Long count =voteDiscussionReponsitory.countByUnvote(discussionId);
        return count;
    }
    //
    //
    //
    @Override
    public VoteDiscussion saveUpVote(VoteDiscussionDTO voteDiscussionDTO) throws Exception {
        VoteDiscussion voteDiscussion1 = null;
        if (voteDiscussionDTO.getDiscussionId() != null && voteDiscussionDTO.getUserId() != null) {
            VoteDiscussion findVoteDiscussionByDiscussionIdAndUserId = voteDiscussionReponsitory
                    .findVoteDiscussionByDiscussionIdAndUserId(voteDiscussionDTO.getDiscussionId(),
                            voteDiscussionDTO.getUserId());
            if (findVoteDiscussionByDiscussionIdAndUserId != null) {
                findVoteDiscussionByDiscussionIdAndUserId.setVote(voteDiscussionDTO.isLike());
                voteDiscussion1 = voteDiscussionReponsitory.save(findVoteDiscussionByDiscussionIdAndUserId);
                //
                Discussion discussionNumberVote=discussionReponsitory.findById(voteDiscussionDTO.getDiscussionId())
                        .orElseThrow(()->new Exception("not find discussion id =" + voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberVote(countVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberUnvote(countUnVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionReponsitory.save(discussionNumberVote);
                //
                return voteDiscussion1;
            } else {
                VoteDiscussion voteDiscussion = new VoteDiscussion();
                voteDiscussion.setVote(voteDiscussionDTO.isLike());

                Discussion discussion = discussionReponsitory.findById(voteDiscussionDTO.getDiscussionId())
                        .orElseThrow(() -> new Exception("not find discussion id =" + voteDiscussionDTO.getDiscussionId()));
                voteDiscussion.setDiscussion(discussion);
                User user = userRepository.findById(voteDiscussionDTO.getUserId())
                        .orElseThrow(() -> new Exception("not find user id =" + voteDiscussionDTO.getUserId()));
                voteDiscussion.setUser(user);
                voteDiscussion1= voteDiscussionReponsitory.save(voteDiscussion);
                //
                Discussion discussionNumberVote=discussionReponsitory.findById(voteDiscussionDTO.getDiscussionId())
                        .orElseThrow(()->new Exception("not find discussion id =" + voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberVote(countVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberUnvote(countUnVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionReponsitory.save(discussionNumberVote);
                return voteDiscussion1;
            }

        }
        return voteDiscussion1;
    }
    ///////
    @Override
    public VoteDiscussion saveDownVote(VoteDiscussionDTO voteDiscussionDTO) throws Exception {
        VoteDiscussion voteDiscussion1 = null;
        if (voteDiscussionDTO.getDiscussionId() != null && voteDiscussionDTO.getUserId() != null) {
            VoteDiscussion findVoteDiscussionByDiscussionIdAndUserId = voteDiscussionReponsitory
                    .findVoteDiscussionByDiscussionIdAndUserId(voteDiscussionDTO.getDiscussionId(),
                            voteDiscussionDTO.getUserId());
            if (findVoteDiscussionByDiscussionIdAndUserId != null) {
                findVoteDiscussionByDiscussionIdAndUserId.setUnvote(voteDiscussionDTO.isUnlike());
                voteDiscussion1 = voteDiscussionReponsitory.save(findVoteDiscussionByDiscussionIdAndUserId);
                //
                Discussion discussionNumberVote=discussionReponsitory.findById(voteDiscussionDTO.getDiscussionId())
                        .orElseThrow(()->new Exception("not find discussion id =" + voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberVote(countVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberUnvote(countUnVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionReponsitory.save(discussionNumberVote);
                //
                return voteDiscussion1;
            } else {
                VoteDiscussion voteDiscussion = new VoteDiscussion();
                voteDiscussion.setUnvote(voteDiscussionDTO.isUnlike());
                Discussion discussion = discussionReponsitory.findById(voteDiscussionDTO.getDiscussionId())
                        .orElseThrow(() -> new Exception("not find discussion id =" + voteDiscussionDTO.getDiscussionId()));
                voteDiscussion.setDiscussion(discussion);
                User user = userRepository.findById(voteDiscussionDTO.getUserId())
                        .orElseThrow(() -> new Exception("not find user id =" + voteDiscussionDTO.getUserId()));
                voteDiscussion.setUser(user);
                voteDiscussion1= voteDiscussionReponsitory.save(voteDiscussion);
                //
                Discussion discussionNumberVote=discussionReponsitory.findById(voteDiscussionDTO.getDiscussionId())
                        .orElseThrow(()->new Exception("not find discussion id =" + voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberVote(countVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionNumberVote.setNumberUnvote(countUnVoteByDiscussion(voteDiscussionDTO.getDiscussionId()));
                discussionReponsitory.save(discussionNumberVote);
                return voteDiscussion1;
            }

        }
        return voteDiscussion1;
    }
}
