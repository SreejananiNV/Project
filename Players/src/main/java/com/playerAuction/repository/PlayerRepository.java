package com.playerAuction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.playerAuction.model.PlayerModel;
import com.playerAuction.model.TeamModel;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel,String>{
	
	
	
	@Query("select a from PlayerModel a where a.team=:team")
	List<PlayerModel> findByName(@Param("team")TeamModel team);
	 
	
@Query("select a from PlayerModel a where a.name=:name")
    List<PlayerModel> findByPlayerName(@Param("name")String name);


}
