package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Cat;
import com.revature.repos.CatRepo;


@Service
public class CatServiceImpl implements CatService {
	
	// We haven't implemented this, but all of the methods we are using are coming from the CrudRepository
	private CatRepo cr;
	
	@Autowired
	public CatServiceImpl(CatRepo cr) {
		this.cr = cr;
	}

	@Override
	public Cat getCat(int id) {
		return cr.findById(id).get();
	}

	@Override
	public List<Cat> getAllCats() {
		return (List<Cat>) cr.findAll();
	}

	@Override
	public Cat addCat(Cat c) {
		return cr.save(c);
	}

	@Override
	public Cat updateCat(Cat c) {
		return cr.save(c); // this save is coming from CrudRepository -> works the same as saveOrUpdate();
	}

	@Override
	public boolean deleteCat(int id) {
		try {
			cr.deleteById(id);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
