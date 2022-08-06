package com.tpssoft.retro.services.RetrospectiveGame;

import com.tpssoft.retro.dto.BoardRetrospectiveDTO;
import com.tpssoft.retro.dto.retro.DiscussionDTO1;
import com.tpssoft.retro.model.boardRetrospective.BoardColunm;
import com.tpssoft.retro.model.boardRetrospective.BoardRetrospective;
import com.tpssoft.retro.model.boardRetrospective.Discussion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardRetroService {

    List<BoardRetrospective>findAllBoardByUserId(Long user_id);
    public BoardRetrospective findBoardByUrl(String url) throws Exception;
    BoardRetrospective createBoard(BoardRetrospectiveDTO boardRetrospectiveDTO) throws Exception;
    BoardRetrospective editBoard(BoardRetrospective boardRetrospective,long id) throws Exception;
    BoardRetrospective deleteBoard(String url) throws Exception;
    public List<BoardColunm> findBoardByUrl1(String url)throws Exception ;
}
