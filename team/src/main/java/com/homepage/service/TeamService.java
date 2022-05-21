package com.homepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homepage.dto.TeamDto;

import com.homepage.exception.TeamException;
import com.homepage.model.TeamModel;
import com.homepage.repository.TeamRepository;


@Service
public class TeamService {
	
	
	@Autowired
	public TeamRepository createteamrepo;
	
	public TeamDto saveDetails(TeamModel createteam) throws TeamException {
		TeamDto teamDTO = new TeamDto();
		if (createteamrepo.existsById(createteam.getTeamname() )) {
			teamDTO.setMsg("Team Name Already Exists!!!");
			// throw new CreateTeamException("Team Name Already exsist");
		} else {
			createteam.setBalancebudget(createteam.getTotalmaxbudget());
			TeamModel team = createteamrepo.save(createteam);
			if (team != null) {
				teamDTO.setMsg("Team is created SuccessFully!!!");
			}
		}
		teamDTO.setTeamname(createteam.getTeamname());
		teamDTO.setTotalmaxbudget(createteam.getTotalmaxbudget());
		teamDTO.setBalancebudget(createteam.getBalancebudget());
	

		return teamDTO;
	}

	public List<TeamModel> getAll() {

		return createteamrepo.findAll();
	}

	public TeamModel findByName(String teamname) {

		return createteamrepo.findByteamname(teamname);
	}

}



