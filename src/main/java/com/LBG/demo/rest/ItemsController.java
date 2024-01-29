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

import com.LBG.demo.domain.Items;
import com.LBG.demo.service.ItemsService;

@RestController
@RequestMapping("/items")
public class ItemsController {

	private ItemsService service;

	public ItemsController(ItemsService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Items> createItems(@RequestBody Items newItems) {
		return this.service.ceateItem(newItems);

	}

	@GetMapping("/read")
	public List<Items> readItems() {
		return this.service.getItems();
	}

	@PutMapping("update/{id}")
	public ResponseEntity<Items> updateItems(@PathVariable int id, Items newItems) {
		return this.service.updateItems(id, newItems);

	}

	@DeleteMapping("delete/{id}")
	public boolean deleteItems(@PathVariable int id) {
		return this.service.deleteItem(id);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Items> getItems(@PathVariable int id) {
		return this.service.readItem(id);
	}

}
