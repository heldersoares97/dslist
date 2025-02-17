package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListrepository;
	
	
	@Transactional(readOnly = true)
	public GameListDTO findAll(){	
	List<GameList> result = gameListrepository.findAll();
	return (GameListDTO) result.stream().map(x -> new GameListDTO(x)).toList();
		
}

	
}
