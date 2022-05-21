package com.playerAuction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playerAuction.dto.PlayerDto;
import com.playerAuction.exception.PlayerException;
import com.playerAuction.model.PlayerModel;
import com.playerAuction.model.TeamModel;
import com.playerAuction.service.PlayerService;



@RestController
public class PlayerController {
	
	@Autowired
	public PlayerService playser;
	
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addplaydetails")
	public PlayerDto addteamdetails(@RequestBody PlayerDto createplay) throws PlayerException  {
  
		
		PlayerModel player=new PlayerModel();
		TeamModel team=new TeamModel();
		team.setTeamname(createplay.getTeamname());
		player.setBudgetprice(createplay.getBudgetprice());
		player.setName(createplay.getName());
		player.setTeam(team);
		return playser.saveDetails(player);	
		
	}
	@GetMapping("/getplaydetails")
	public List<PlayerModel> getDetails(){
		return playser.getAll();
		
	}
	

	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/showteam/{team}")
	public  List<PlayerDto> showteam(@PathVariable TeamModel team){
		//System.out.println("---"+team.getTeamname());
		return playser.showTeamDetails(team);
		
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/showplayer/{name}")
	public List<PlayerDto> showplayer(@PathVariable String name){
		System.out.println("----"+name);
		return playser.showPlayerDetails(name);
	}
	
	

}
