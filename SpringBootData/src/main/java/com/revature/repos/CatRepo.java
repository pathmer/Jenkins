package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {

}
