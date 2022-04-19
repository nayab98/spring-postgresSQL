package com.springbootpostgreSQL.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.springbootpostgreSQL.repository.OfferRepo;
//import com.springbootpostgreSQL.repository.pitchRepo;
import com.springbootpostgreSQL.service.PitchService;
import com.springbootpostgreSQL.validation.Validation;
import com.springbootpostgreSQL.DTO.OfferDTOWithId;
import com.springbootpostgreSQL.DTO.PitchWithOffers;
import com.springbootpostgreSQL.DTO.SingleString;
import com.springbootpostgreSQL.exception.ResourceNotFoundException;
import com.springbootpostgreSQL.model.Offer;
import com.springbootpostgreSQL.model.Pitch;


@RestController
@RequestMapping("/")
public class PitchController {
	
	@Autowired
	private PitchService servicePitch;
	
	@GetMapping("pitches")
	public ResponseEntity<List<PitchWithOffers>> getAllPitches(){
		List<Pitch> pitcheswithoutoffers = this.servicePitch.getPitchesWithoutOffers();
		List<PitchWithOffers> pitcheswithoffers = new ArrayList<>();
		PitchWithOffers pwo;
		for(Pitch temp : pitcheswithoutoffers) {
			pwo = new PitchWithOffers(String.valueOf(temp.getId()), temp.getEntrepreneur(),temp.getPitchTitle(), temp.getPitchIdea(), temp.getAskAmount(), temp.getEquity());
			pwo.setOffers(this.servicePitch.getAllOffersForParticularPitch(temp.getId()));
			pitcheswithoffers.add(pwo);
		}
		//return pitcheswithoffers;
		Collections.reverse(pitcheswithoffers);
		return ResponseEntity.status(HttpStatus.OK).body(pitcheswithoffers);
	}
//	
	//get by Id
	@GetMapping("/pitches/{pitchId}")
	public ResponseEntity<PitchWithOffers> getPitchById(@PathVariable int pitchId) {
		Pitch temp = this.servicePitch.getPitchWithoutOffer(pitchId);
		if(temp==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		PitchWithOffers pwo = new PitchWithOffers(String.valueOf(temp.getId()), temp.getEntrepreneur(),temp.getPitchTitle(), temp.getPitchIdea(), temp.getAskAmount(), temp.getEquity());;
		pwo.setOffers(this.servicePitch.getAllOffersForParticularPitch(pitchId));
		//return pwo;
		return ResponseEntity.status(HttpStatus.OK).body(pwo);
//	
	}
	
	//save pitch
	@PostMapping("pitches")
	 public ResponseEntity<SingleString> createPitch(@RequestBody Optional<Pitch> pitch1) {
		//return this.servicePitch.savePitch(pitch);
		//if body is empty
		if(!pitch1.isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		Pitch pitch = pitch1.get();
	
		//check field names
		Validation v = new Validation();
		if(!v.validateBody(pitch)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		if(!v.validateEquity(pitch)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		//if(!v.validateEntrepreneur(pitch)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		//main logic
		SingleString ss = new SingleString(this.servicePitch.savePitch(pitch));
		return ResponseEntity.status(HttpStatus.CREATED).body(ss);
	}
	
	//make offer
	@PostMapping("pitches/{pitchId}/makeOffer")
	 public ResponseEntity<SingleString> createOffer(@PathVariable int pitchId, @RequestBody Optional<OfferDTOWithId> offerDtoWithId1) {
		//if body is empty
		if(!offerDtoWithId1.isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		OfferDTOWithId offerDtoWithId = offerDtoWithId1.get();
		//validate body of offer
		Validation v = new Validation();
		if(!v.validateBodyOffer(offerDtoWithId)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		//validate equity and investor
		if(!v.validateEquityOffer(offerDtoWithId)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		//if(!v.validateInvestor(offerDtoWithId)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		//validate pitch id
		Pitch temp1 = this.servicePitch.getPitchWithoutOffer(pitchId);
		if(temp1==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		//main logic
		Pitch temp = new Pitch();
		temp.setId(pitchId);
		Offer offer = new Offer(offerDtoWithId.getInvestor(), offerDtoWithId.getAmount(), offerDtoWithId.getEquity(), offerDtoWithId.getComment(), temp);
		//return this.servicePitch.saveOffer(offer);
		SingleString ss = new SingleString(this.servicePitch.saveOffer(offer));
		return ResponseEntity.status(HttpStatus.CREATED).body(ss);
	}
	@GetMapping("offers/{pitchId}")
	public List<OfferDTOWithId> getOffersForPitch(@PathVariable int pitchId){
		return this.servicePitch.getAllOffersForParticularPitch(pitchId);
	}
}






