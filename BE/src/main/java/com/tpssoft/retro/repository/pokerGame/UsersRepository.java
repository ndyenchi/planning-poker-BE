package com.tpssoft.retro.repository.pokerGame;

import com.tpssoft.retro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

}
