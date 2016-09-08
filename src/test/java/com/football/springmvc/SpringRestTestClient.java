package com.football.springmvc;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.football.springmvc.model.Player;

public class SpringRestTestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/FootballStatistics";
	
	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllPlayers(){
		System.out.println("Testing listAllPlayers API-----------");
		
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> playersMap = restTemplate.getForObject(REST_SERVICE_URI+"/players/", List.class);
		
		if(playersMap!=null){
			for(LinkedHashMap<String, Object> map : playersMap){
	            System.out.println("Player : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", TeamName="+map.get("TeamName"));;
	        }
		}else{
			System.out.println("No Player exist----------");
		}
	}
	
	/* GET */
	private static void getPlayer(){
		System.out.println("Testing getPlayer API----------");
		RestTemplate restTemplate = new RestTemplate();
        Player player = restTemplate.getForObject(REST_SERVICE_URI+"/player/1", Player.class);
        System.out.println(player);
	}
    public static void main(String args[]){
		listAllPlayers();
		getPlayer();
    }
}