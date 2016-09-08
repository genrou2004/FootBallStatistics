package com.football.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.football.springmvc.model.Player;
import com.football.springmvc.model.SearchResult;
import com.football.springmvc.service.UserService;

@RestController
public class FootballRestController {

	@Autowired
	UserService userService;  //Service which will do all data retrieval/manipulation work


	//-------------------Retrieve All Players--------------------------------------------------------
	
		@RequestMapping(value = "/players/", method = RequestMethod.GET)
		public ResponseEntity<SearchResult> listAllPlayers() {
			List<Player> players = userService.findAllPlayers();
			if(players.isEmpty()){
				return new ResponseEntity<SearchResult>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			}
			
			//SearchResult2 result = new SearchResult2(users,users.size());
			SearchResult result = new SearchResult(players,players.size());
			
			return new ResponseEntity<SearchResult>(result,HttpStatus.OK);
		}

	
	//-------------------Retrieve Single player--------------------------------------------------------
	
	@RequestMapping(value = "/player/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Player> getPlayer(@PathVariable("id") long id) {
		System.out.println("Fetching Player with id " + id);
		Player player = userService.findPlayerById(id);
		if (player == null) {
			System.out.println("Player with id " + id + " not found");
			return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Player>(player, HttpStatus.OK);
	}

}
