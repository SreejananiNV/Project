package com.homepage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.homepage.controller.TeamController;
import com.homepage.model.TeamModel;

@SpringBootTest
class TeamApplicationTests {

	@Autowired
	TeamController tCon;

	@Test
	public void saveDetailsTest() {
		TeamModel team = new TeamModel();
		team.setTeamname("Team 01");
		team.setTotalmaxbudget(200000.00);
		team.setBalancebudget(88000.00);

		assertNotNull(team);
	}

	@Test
	public void getAllTest() {
		assertNotNull(tCon.getDetails());
	}

	@Test
	public void findByNameTest() {
		TeamModel team = tCon.findByTeamName("CSK");

		assertNotNull(team);
	}
}