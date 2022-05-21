package com.playerAuction.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.playerAuction.dto.PlayerDto;
import com.playerAuction.exception.PlayerException;
import com.playerAuction.model.PlayerModel;
import com.playerAuction.model.TeamModel;
import com.playerAuction.repository.PlayerRepository;
import com.playerAuction.repository.TeamRepository;

@Service
public class PlayerService {
	@Autowired
	public PlayerRepository playrepo;

	@Autowired
	public TeamRepository teamRepo;
	
	@Autowired
	public RestTemplate restTemplate;

	public PlayerDto saveDetails(PlayerModel createplayer) throws PlayerException {
  
		TeamModel teamobj=this.restTemplate.getForObject("http://localhost:2345/get/"+createplayer.getTeam().getTeamname(),TeamModel.class);
		  
	
		System.out.println("teamobj.getTeamname() "+teamobj.getTeamname());
		PlayerDto playerDTO = new PlayerDto();
		if (playrepo.existsById(createplayer.getName())) {
			playerDTO.setMsg("Player already assigned !!");
			//throw new PlayerException("player already exist");
		}
		else {
			System.out.println("checkBalance(player) "+checkBalance(createplayer));
			if (checkBalance(createplayer)) {
				playrepo.save(createplayer);
				playerDTO.setMsg("Player Successfully created and assigned to the team !!!");
				int updateFlag = updateBalance(createplayer);
				System.out.println("updateFlag : " + updateFlag);
			} 
			else {
				playerDTO.setMsg("Player budget exceeds the Team Balance Budget");
				//throw new PlayerException("player budget exceeds");
			}
			playerDTO.setBudgetprice(createplayer.getBudgetprice());
			playerDTO.setName(createplayer.getName());
		playerDTO.setTeamname(createplayer.getTeam().getTeamname());
			playerDTO.setTeamname(teamobj.getTeamname());
		}
		
		
		return playerDTO;

	}

	public List<PlayerModel> getAll() {

		return playrepo.findAll();
	}

	public List<PlayerDto> showTeamDetails(TeamModel team) {

		List<PlayerDto> playerDTOList = new ArrayList<PlayerDto>();
		List<PlayerModel> playerList = playrepo.findByName(team);
		for (PlayerModel p : playerList) {
			PlayerDto playerDTO = new PlayerDto();
			playerDTO.setName(p.getName());
			playerDTO.setBudgetprice(p.getBudgetprice());
			playerDTO.setTeamname(p.getTeam().getTeamname());
			playerDTOList.add(playerDTO);
		}

		return playerDTOList;

	}

	public List<PlayerDto> showPlayerDetails(String name) {
		List<PlayerDto> playersList = new ArrayList<PlayerDto>();
		List<PlayerModel> playList = playrepo.findByPlayerName(name);
		for (PlayerModel p : playList) {
			PlayerDto playerDTO = new PlayerDto();
			playerDTO.setName(p.getName());
			playerDTO.setBudgetprice(p.getBudgetprice());
			playerDTO.setTeamname(p.getTeam().getTeamname());
			playersList.add(playerDTO);
		}
		
		return playersList;
	}

	public boolean checkBalance(PlayerModel player) throws  PlayerException {
		double playerBudget = player.getBudgetprice();
		
		//System.out.println(playerBudget+":"+player.getTeam().GET);
		//teamRepo.findById(player.team.getTeamname()).get().
		
		double teamBalanceBudget = teamRepo.findById(player.team.getTeamname()).get().getBalancebudget();
		
		//double teamBalanceBudget=player.getTeam().getBalancebudget();
//		System.out.println(player);
//System.out.println(teamBalanceBudget);
		
	
		System.out.println(playerBudget+":"+teamBalanceBudget);
		if (playerBudget < teamBalanceBudget) {
			return true;

		}
		return false;
	}

	public int updateBalance(PlayerModel update) {
		double playerBudget = update.getBudgetprice();
		
		//System.out.println("getBudgetprice"+playerBudget);
		
		double teamBudget = teamRepo.findByteamname(update.team.getTeamname()).getBalancebudget();
		
		//System.out.println("getteamBalance"+teamBudget);
		
		double updatedBalance = teamBudget - playerBudget;
		
		//System.out.println("updatedBalance"+updatedBalance);

		return teamRepo.updateTeamBalanceBudget(updatedBalance, update.team.getTeamname());
	}




}
