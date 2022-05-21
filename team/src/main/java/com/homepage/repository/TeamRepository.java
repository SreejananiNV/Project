package com.homepage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.homepage.model.TeamModel;

@Repository
public interface TeamRepository extends JpaRepository<TeamModel,String>{


	TeamModel findByteamname(String teamname);

	
	
	
	@Transactional
	@Modifying
	@Query("UPDATE TeamModel t SET t.balancebudget=:balance  WHERE t.teamname = :teamname")
	int updateTeamBalanceBudget(@Param("balance")double balance,@Param("teamname")String teamName);

	
}
