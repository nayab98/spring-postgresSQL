package com.springbootpostgreSQL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springbootpostgreSQL.DTO.OfferDTOWithId;
import com.springbootpostgreSQL.model.Offer;

public interface offerRepo extends JpaRepository<Offer, Integer>{

//	@Query("SELECT new com.springbootpostgreSQL.DTO.OfferDTOWithId(o.offerId, o.investor, o.amount, o.equity, o.comment) from Offer o WHERE o.pitch_id =: id ")
//	List<OfferDTOWithId> findAllForParticularPitch(@Param("id") String id);
	
	@Query(value = "SELECT * FROM offer where pitch_id = ?1", nativeQuery = true)
	List<Offer> findOfferWithPitchId(int id);
}
