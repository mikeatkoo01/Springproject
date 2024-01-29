package com.LBG.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LBG.demo.domain.Items;
import com.LBG.demo.repo.ItemsRepo;

@Service
public class ItemsService {

	private ItemsRepo repo;

	public ItemsService(ItemsRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Items> ceateItem(Items newItems) {
		Items created = this.repo.save(newItems);
		return new ResponseEntity<Items>(created, HttpStatus.CREATED);

	}

	public ResponseEntity<Items> readItem(int id) {
		Optional<Items> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Items>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Items body = found.get();

		return ResponseEntity.ok(body);

	}

	public ResponseEntity<Items> updateItems(int id, Items newItems) {
		Optional<Items> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Items>(HttpStatus.NOT_FOUND);
		}

		Items existing = found.get();

		if (newItems.getType() != null) {
			existing.setType(newItems.getType());
		}

		if (newItems.getTitle() != null) {
			existing.setTitle(newItems.getTitle());
		}

		if (newItems.getPeople() != null)
			existing.setAvailable(false);

		Items updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

	public boolean deleteItem(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

	public List<Items> getItems() {
		return this.repo.findAll();
	}

//	public ResponseEntity<Items> checkOutitem(int id, Items newItems) {
//		Optional<Items> rented = this.repo.findById(id);
//		
//		if(rented.isEmpty()) {
//			return new ResponseEntity<Items>(HttpStatus.NOT_FOUND);
//		}
//		
//		
//		Items existing = rented.get();
//		
//		if (newitems.is)

}
