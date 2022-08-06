package com.tpssoft.retro.repository.pokerGame;

import com.tpssoft.retro.model.pokerGame.Issue;
import com.tpssoft.retro.model.pokerGame.IssueHistory;
import com.tpssoft.retro.model.pokerGame.IssueHistoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueHistoryRepository extends JpaRepository<IssueHistory, IssueHistoryPK> {
    List<IssueHistory> findByIssue_Game_Url(String url);

    public Boolean existsByIssueHistoryPK_IdIssue(Long idIssue);


}