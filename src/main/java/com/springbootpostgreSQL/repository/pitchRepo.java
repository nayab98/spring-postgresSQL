package com.springbootpostgreSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootpostgreSQL.model.Pitch;

@Repository
public interface pitchRepo extends JpaRepository<Pitch, Integer>{
	
	//@Query
	
}
