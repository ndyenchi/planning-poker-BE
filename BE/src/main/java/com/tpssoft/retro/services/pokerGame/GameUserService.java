package com.tpssoft.retro.services.pokerGame;

import com.tpssoft.retro.dto.pokerGame.GameUserDTO;
import com.tpssoft.retro.dto.pokerGame.TestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameUserService {
    public List<GameUserDTO> getChooseCard(String url);

    public void outGame(TestDTO testDTO);
}
