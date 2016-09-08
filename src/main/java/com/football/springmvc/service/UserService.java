package com.football.springmvc.service;

import java.util.List;

import com.football.springmvc.model.Player;



public interface UserService {
	
	Player findPlayerById(long id);
	List<Player> findAllPlayers(); 
	
}
