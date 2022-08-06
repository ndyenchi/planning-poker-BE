package com.tpssoft.retro.repository.boardRetrospective;

import com.tpssoft.retro.model.boardRetrospective.BoardColunm;
import com.tpssoft.retro.model.boardRetrospective.BoardRetrospective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardColunmReponsitory extends JpaRepository<BoardColunm,Long> {

}