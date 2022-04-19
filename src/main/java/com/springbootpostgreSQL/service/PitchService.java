package com.springbootpostgreSQL.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootpostgreSQL.DTO.OfferDTOWithId;
import com.springbootpostgreSQL.exception.ResourceNotFoundException;
import com.springbootpostgreSQL.model.Offer;
import com.springbootpostgreSQL.model.Pitch;
import com.springbootpostgreSQL.repository.offerRepo;
import com.springbootpostgreSQL.repository.pitchRepo;

@Service
public class PitchService {

	@Autowired
	private pitchRepo repoPitch;
	
	@Autowired
	private offerRepo repoOffer;
	
//	public List<Pitch> getAllPitches(){
//		//List<OfferDTOWithId> listOffers = this.repoOffer.findAllForParticularPitch();
//		List<Pitch> listPitches =  this.repoPitch.findAll();
//		Collections.reverse(listPitches);
//		return listPitches;
//	}
//	
//	public boolean getPitchById(int id){
//		//List<OfferDTOWithId> listOffers = this.repoOffer.findAllForParticularPitch(String.valueOf(id));
////		Pitch pitch = this.repoPitch.findById(id)
////				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
//		//pitch.setOffers(listOffers);
//		//return pitch;//ResponseEntity.ok().body(pitch);
//		//Pitch pitch1=null;
//		Optional<Pitch> pitch = this.repoPitch.findById(id);
//		if(pitch.isPresent()) return true;
//		return false;
//	}
	public String savePitch(Pitch pitch) {
		return String.valueOf(this.repoPitch.save(pitch).getId());
	}

	public String saveOffer(Offer offer) {
		// TODO Auto-generated method stub
		return String.valueOf(this.repoOffer.save(offer).getId());
	}
	
	public Pitch getPitchWithoutOffer(int pitchId) {
		Optional<Pitch> pitch =  this.repoPitch.findById(pitchId);
		Pitch temp = null;
		if(pitch.isPresent())
			temp = pitch.get();
		return temp;
		
	}
	
	public List<Pitch> getPitchesWithoutOffers(){
		return this.repoPitch.findAll();
	}
	
	public List<OfferDTOWithId> getAllOffersForParticularPitch(int pitchId){
		List<Offer> offers = this.repoOffer.findOfferWithPitchId(pitchId);
		List<OfferDTOWithId> oDtoWIdList = new ArrayList<>();
		OfferDTOWithId oDtoWId;
		for(Offer offer : offers) {
			oDtoWId = new OfferDTOWithId(String.valueOf(offer.getId()), offer.getInvestor(), offer.getAmount(), offer.getEquity(), offer.getComment());
			oDtoWIdList.add(oDtoWId);
		}
		return oDtoWIdList;
	}
//	public List<OfferDTOWithId> getOffersById(int id){
//		return this.repoOffer.findAllForParticularPitch("pitch_id");
//	}
}
