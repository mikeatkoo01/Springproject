package com.LBG.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LBG.demo.domain.People;
import com.LBG.demo.repo.PeopleRepo;

@Service
public class PeopleService {

	private PeopleRepo repo;

	public PeopleService(PeopleRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<People> ceatePeople(People newPeople) {
		People created = this.repo.save(newPeople);
		return new ResponseEntity<People>(created, HttpStatus.CREATED);

	}

	public ResponseEntity<People> readPeople(int id) {
		Optional<People> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		People body = found.get();

		return ResponseEntity.ok(body);

	}

	public ResponseEntity<People> updatePeople(int id, People newPeople) {
		Optional<People> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
		}

		People existing = found.get();

		if (newPeople.getName() != null) {
			existing.setName(newPeople.getName());
		}

		if (newPeople.getCity() != null) {
			existing.setCity(newPeople.getCity());
		}

		People updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

	public boolean deletePeople(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

	public List<People> getPeople() {
		return this.repo.findAll();
	}

}
