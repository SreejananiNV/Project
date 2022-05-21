package com.playerAuction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.playerAuction.controller.PlayerController;
import com.playerAuction.dto.PlayerDto;
import com.playerAuction.exception.PlayerException;
import com.playerAuction.model.PlayerModel;
import com.playerAuction.model.TeamModel;

@SpringBootTest
class PlayersApplicationTests {
	@Autowired
	PlayerController pCon;

	
	@Test
	public void getAllTest() {
		assertNotNull(pCon.getDetails());
	}

	@Test
	public void showTeamDetailsTest() {
		TeamModel team = new TeamModel();
		team.setTeamname("Team");
		team.setTotalmaxbudget(200000.00);
		team.setBalancebudget(1000.00);
		assertNotNull(pCon.showteam(team));
	}

	@Test
	public void showPlayerDetailsTest() {
		assertNotNull(pCon.showplayer("Player"));
	}

	

}
