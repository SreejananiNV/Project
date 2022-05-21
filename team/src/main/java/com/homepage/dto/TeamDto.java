package com.homepage.dto;

public class TeamDto {
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private String  teamname;
	 private double totalmaxbudget; 
	 private double balancebudget;
	 private String msg;


}
