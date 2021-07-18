package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Cat;
import com.revature.services.CatServiceImpl;

@RestController
@RequestMapping(path = "/cats")
public class CatController {

	private CatServiceImpl cs;
	
	@Autowired
	public CatController(CatServiceImpl cs) {
		this.cs = cs;
	}
	
	// GET -> localhost:8080/cats
	@GetMapping(produces="application/json")
	public List<Cat> getAllCats() {
		return cs.getAllCats();
	}
	
	// GET -> localhost:8080/cats/9
	@GetMapping(path="/{id}")
	public Cat getCat(@PathVariable("id") int id) {
		return cs.getCat(id);
	}
	
	
	// POST -> localhost:8080/cats/add
	@PostMapping(path="/add", consumes="application/json", produces="application/json")
	public Cat addCat(@RequestBody Cat c) {
		return cs.addCat(c);
	}
	
	// UPDATE -> localhost:8080/cats/7
	@PutMapping(path="/{id}")
	public Cat updateCat(@PathVariable("id") int id, @RequestBody Cat c) {
//		if (id == c.getId()) {
//			return cs.updateCat(c);
//		}
//		return new Cat();
		
		return cs.updateCat(c);
	}
	
	// DELETE -> localhost:8080/cats/4
	@DeleteMapping(path="/{id}")
	public void deleteCat(@PathVariable("id") int id, @RequestBody Cat c) {
		if (id == c.getId()) {
			cs.deleteCat(id);
		}
	}
	
	
	
}
