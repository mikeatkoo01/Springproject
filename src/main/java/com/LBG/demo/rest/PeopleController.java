package com.LBG.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LBG.demo.domain.People;
import com.LBG.demo.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {

	private PeopleService service;

	public PeopleController(PeopleService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<People> createPeople(@RequestBody People newPeople) {
		return this.service.ceatePeople(newPeople);

	}

	@GetMapping("/read")
	public List<People> readPeople() {
		return this.service.getPeople();
	}

	@PutMapping("update/{id}")
	public ResponseEntity<People> updatePeople(@PathVariable int id, People newPeople) {
		return this.service.updatePeople(id, newPeople);

	}

	@DeleteMapping("delete/{id}")
	public boolean deletePeople(@PathVariable int id) {
		return this.service.deletePeople(id);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<People> getItems(@PathVariable int id) {
		return this.service.readPeople(id);
	}

}
