package com.thehecklers.sburrestdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thehecklers.sburrestdemo.model.Card;
import com.thehecklers.sburrestdemo.model.Habilidade;

@SpringBootApplication
public class SburRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SburRestDemoApplication.class, args);
	}

}
@CrossOrigin(origins = {"http://localhost:8070", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/coffees")
class RestApiDemoController {
	private List<Card> cartas = new ArrayList<>();

	public RestApiDemoController() {
		cartas.addAll(List.of( new Card("25743537.jpg","1","Cachorro caramelo", "Uma combinação unica de amor, carinho, malandragem e loucura, coisa de brasilehiro né? ", "É do Tipo amor", new Habilidade(40,50,80,90,20,40)),
			new Card("bolsonaro-hang-moto.jpg","2","Dois caras em uma moto", "Você não quer encontrar esse monstro na rua a noite", "É do tipo Loucura", new Habilidade(50,80,90,20,40,40)),
			new Card("download.jpg","3", "Lampião", "Dalhe peixada", "É do tipo Ataque", new Habilidade(80,90,20,40,40,50))));
	}

	@GetMapping
	Iterable<Card> getCarta() {
		return cartas;
	}

	@GetMapping("/{id}")
	Optional<Card> getCardById(@PathVariable String id) {
		for (Card c: cartas) {
			if (c.getId().equals(id)) {
				return Optional.of(c);
			}
		}

		return Optional.empty();
	}

	@PostMapping
	Card postCard(@RequestBody Card carta) {
		cartas.add(carta);
		return carta;
	}

	@PutMapping("/{id}")
	ResponseEntity<Card> putCoffee(@PathVariable String id,
	@RequestBody Card carta) {
		int cardIndex = -1;

		for (Card c: cartas) {
			if (c.getId().equals(id)) {
				cardIndex = cartas.indexOf(c);
				cartas.set(cardIndex, carta);
			}
		}

		return (cardIndex == -1) ?
				new ResponseEntity<>(postCard(carta), HttpStatus.CREATED) :
				new ResponseEntity<>(carta, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteCoffee(@PathVariable String id) {
		cartas.removeIf(c -> c.getId().equals(id));
	}
}