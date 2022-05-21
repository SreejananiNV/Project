package com.playerAuction.dto;

public class PlayerDto {
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
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	private  String name;
	private double budgetprice;
	private String teamname;
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
