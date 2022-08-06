package com.tpssoft.retro.services.pokerGame;

import com.tpssoft.retro.model.pokerGame.Game;
import com.tpssoft.retro.repository.pokerGame.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{
    @Autowired
    private GameRepository gameRepository;
    @Override
    public Game FindGameByUrl(String url) throws Exception {
        Game game = gameRepository.findByUrl(url);
        if (game!= null){
            return game;
        }
      else {
           throw new Exception("Not find game by url "+ url);
        }
    }
}
