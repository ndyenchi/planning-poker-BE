package com.tpssoft.retro.services.pokerGame.impl;

import com.tpssoft.retro.dto.pokerGame.IssesRepository;
import com.tpssoft.retro.model.pokerGame.Game;
import com.tpssoft.retro.model.pokerGame.Issue;
import com.tpssoft.retro.repository.UserRepository;
import com.tpssoft.retro.repository.pokerGame.GameRepository;
import com.tpssoft.retro.repository.pokerGame.GameUserRepository;
import com.tpssoft.retro.repository.pokerGame.IssuesRepository;
import com.tpssoft.retro.services.pokerGame.GameService;
import com.tpssoft.retro.services.pokerGame.GameUserService;
import com.tpssoft.retro.services.pokerGame.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuesServiceImpl implements IssuesService {
    @Autowired
    private GameService gameService;
    @Autowired private GameRepository gameRepository;

    @Autowired private UserRepository userRepository;

    @Autowired private GameUserRepository gameUserRepository;

    @Autowired private GameUserService gameUserService;

    @Autowired private IssuesRepository issuesRepo;
    @Override
    public void createIssue(IssesRepository issesRepository) {
        Game getGameId = gameRepository.findByUrl(issesRepository.getUrl());
        Issue issue = new Issue(issesRepository.getKey(), issesRepository.getTitle(), getGameId);
        issuesRepo.save(issue);
    }

    @Override
    public Issue issue() {
        return null;
    }

    @Override
    public List<Issue> issuesList(String url) {
       return issuesRepo.findByIsDeleteAndGame_UrlOrderByIdAsc(false,url);

    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteAll() {

    }
}
