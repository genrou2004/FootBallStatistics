package com.football.springmvc.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.football.springmvc.model.Player;
import com.football.springmvc.model.SearchResult;
import com.opencsv.CSVReader;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Player> users;
	private static List<Player> players;
	
	static{
		players= populateDummyUsers();
	}

	public List<Player> findAllPlayers()
	{
		return players;
	}
	
	public Player findPlayerById(long id) {
		for(Player player : players){
			if(player.getId() == id){
				return player;
			}
		}
		return null;
	}

	private static List<Player> populateDummyUsers(){
		
		
		CSVReader reader = null;
		List<Player> players = new ArrayList<Player>();
		Player test = new Player();
		String path = test.getClass().getClassLoader().getResource("").getPath();
		String fullPath = null;
		try {
			fullPath = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String csv = "";
		// to read a file from web content
				csv = new File(fullPath).getPath() + File.separatorChar + "players.csv";
		try {
			
			reader = new CSVReader(new FileReader(csv));
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     try {
			List myEntries = reader.readAll();
		
			for(int i =0; i<myEntries.size();++i)
			{
				players.add(new Player(counter.incrementAndGet(),(String[])myEntries.get(i)));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	     
		return players;//users;
	}

	public void deleteAllUsers() {
		users.clear();
	}

}

