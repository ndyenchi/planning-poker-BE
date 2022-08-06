package com.tpssoft.retro.services.pokerGame;

import com.tpssoft.retro.model.pokerGame.Game;
import org.springframework.stereotype.Service;

@Service
public interface GameService {

    public Game FindGameByUrl(String url) throws Exception;
}
