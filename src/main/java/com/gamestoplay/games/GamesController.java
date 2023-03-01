package com.gamestoplay.games;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class GamesController {
	RestTemplate restTemplate = new RestTemplate();
	RestTemplate gameTemplate = new RestTemplate();
	String url = "https://www.freetogame.com/api/games";
	JsonNode response = restTemplate.getForObject(url, JsonNode.class);
	
	String gameUrl = "https://www.freetogame.com/api/game?id=456";
	JsonNode gameResponse = gameTemplate.getForObject(gameUrl, JsonNode.class);
	
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("game", gameResponse);
		model.addAttribute("games", response);
		return "index";
	}
	@GetMapping("/categories")
	public String categories() {
		return "categories";
	}
}
