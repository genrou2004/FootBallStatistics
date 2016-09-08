package com.football.springmvc.model;

public class Player {
	long id;
	
	String[] player={"",""};
	public Player()
	{
		
	}
	public Player(long id, String[] row)
	{
		this.player=row;
		this.id=id;
		
	}
	
	public String[] getPlayers() {
		return player;
	}
	public void setPlayers(String[] players) {
		this.player = players;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String[] getPlayer() {
		return player;
	}
	public void setPlayer(String[] player) {
		this.player = player;
	}

}
