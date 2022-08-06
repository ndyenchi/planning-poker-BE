package com.tpssoft.retro.repository.boardRetrospective;

import com.tpssoft.retro.model.boardRetrospective.BoardRetrospective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BoardRetroReponsitory extends JpaRepository<BoardRetrospective,Long> {
    public BoardRetrospective findByUrl(String url);

    public List<BoardRetrospective> findByUser_id(Long user_id);
}