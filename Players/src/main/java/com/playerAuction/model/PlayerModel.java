package com.playerAuction.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity

@Table(name="player")
public class PlayerModel {
	

	@Id
	private  String name;
	private double budgetprice;
	

	@ManyToOne
	@JoinColumn(name="teamname")
	 public  TeamModel team;
	
	public TeamModel getTeam() {
		return team;
	}

	public void setTeam(TeamModel team) {
		this.team = team;
	}

	public PlayerModel(TeamModel createteam) {
		super();
		this.team = createteam;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBudgetprice() {
		return budgetprice;
	}
	public void setBudgetprice(double budgetprice) {
		this.budgetprice = budgetprice;
	}
	public PlayerModel( String name, double budgetprice,TeamModel team) {
		super();
		
		this.name = name;
		this.budgetprice = budgetprice;
		this.team=team;
	}
	public PlayerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CreatePlayerModel [name=" + name + ", budgetprice=" + budgetprice + ", team=" + team + "]";
	}

	

}
