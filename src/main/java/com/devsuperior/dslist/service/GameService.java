package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gamerepository;
	
	
	public List<GameMinDTO> findAll(){	
	List<Game> result = gamerepository.findAll();
	return result.stream().map(x -> new GameMinDTO(x)).toList();
		
}
	
}
