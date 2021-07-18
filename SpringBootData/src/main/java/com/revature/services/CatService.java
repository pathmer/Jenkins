package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Cat;

public interface CatService {
	
	public Cat getCat(int id);
	
	public List<Cat> getAllCats();
	
	public Cat addCat(Cat c);
	
	public Cat updateCat(Cat c);
	
	public boolean deleteCat(int id);

}
