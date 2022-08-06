package com.tpssoft.retro.services.pokerGame.impl;

import com.tpssoft.retro.dto.pokerGame.GameUserDTO;
import com.tpssoft.retro.dto.pokerGame.TestDTO;
import com.tpssoft.retro.model.pokerGame.GameUser;
import com.tpssoft.retro.repository.pokerGame.GameUserRepository;
import com.tpssoft.retro.services.pokerGame.GameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameUserServiceImpl  implements GameUserService {
    @Autowired
    GameUserRepository gameUserRepository;

    @Override
    public List<GameUserDTO> getChooseCard(String url) {
        List<GameUser> list= gameUserRepository.findByGame_Url(url);
        List<GameUserDTO> dto=new ArrayList<>();
        for(GameUser gu:list){
            GameUserDTO a = new GameUserDTO(gu.getUser().getId(), gu.getFlipCard());
            dto.add(a);
        }
        return dto;
    }

    @Override
    public void outGame(TestDTO testDTO) {
        System.out.println(testDTO.getUrl());
        System.out.println(testDTO.getIdUser());
        GameUser gameUser=gameUserRepository.findByGameUrlAndUserID(testDTO.getUrl(),testDTO.getIdUser()).get();
        gameUserRepository.delete(gameUser);

    }
}
