package com.tpssoft.retro.services.pokerGame;

import com.tpssoft.retro.dto.pokerGame.IssesRepository;
import com.tpssoft.retro.model.pokerGame.Issue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IssuesService {
    public void createIssue(IssesRepository issesRepository);
    public Issue issue();
    public List<Issue> issuesList(String url);
    public void delete();
    public void deleteAll();

}
