package com.playerAuction.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="team")
public class TeamModel {
	@Id
	  private String  teamname;
	  private double totalmaxbudget; 
	  private double balancebudget;

public TeamModel(String teamname, double totalmaxbudget, double balancebudget) {
	super();
	this.teamname = teamname;
	this.totalmaxbudget = totalmaxbudget;
	this.balancebudget = balancebudget;
}

public TeamModel(String teamname){
	super();
	this.teamname = teamname;
}
public String getTeamname() {
	return teamname;
}
public void setTeamname(String teamname) {
	this.teamname = teamname;
}
public double getTotalmaxbudget() {
	return totalmaxbudget;
}
public void setTotalmaxbudget(double totalmaxbudget) {
	this.totalmaxbudget = totalmaxbudget;
}
public double getBalancebudget() {
	return balancebudget;
}
public void setBalancebudget(double balancebudget) {
	this.balancebudget = balancebudget;
}
public TeamModel() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "CreateTeamModel [teamname=" + teamname + ", totalmaxbudget=" + totalmaxbudget + ", balancebudget="
			+ balancebudget +  "]";
}



}
