package com.cric.cricket_ranking_system.repository;

import com.cric.cricket_ranking_system.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlayerRepository extends JpaRepository<Player,Long> {

}
