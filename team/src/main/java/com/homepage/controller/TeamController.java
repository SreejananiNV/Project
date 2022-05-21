package com.homepage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homepage.dto.TeamDto;
import com.homepage.exception.TeamException;
import com.homepage.model.TeamModel;
import com.homepage.service.TeamService;


@RestController
public class TeamController {
	@Autowired
	public TeamService createteamser;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addteamdetails")
	public TeamDto addteamdetails(@RequestBody TeamModel createteam) throws TeamException {
		return createteamser.saveDetails(createteam);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getteamdetails")
	public List<String> getDetails() {
		List<TeamModel> teamList = createteamser.getAll();
		List<String> teamNameList = new ArrayList();
		for (TeamModel team : teamList) {
			teamNameList.add(team.getTeamname());
		}
		return teamNameList;
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get/{teamname}")
	public TeamModel findByTeamName(@PathVariable("teamname") String teamname) {
		return createteamser.findByName(teamname);
	}


// 
}
