package com.tpssoft.retro.repository;

import com.tpssoft.retro.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: dao.nduytan on 04/06/2022
 */
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
