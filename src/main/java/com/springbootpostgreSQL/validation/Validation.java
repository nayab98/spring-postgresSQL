package com.springbootpostgreSQL.validation;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.springbootpostgreSQL.DTO.OfferDTOWithId;
import com.springbootpostgreSQL.model.Pitch;
import com.springbootpostgreSQL.repository.pitchRepo;
import com.springbootpostgreSQL.service.PitchService;
//import org.json.simple.JSONObject;

public class Validation {
	
	private Pitch pitch;
	
	@Autowired
	private PitchService servicePitch;
	
	public Validation() {
		super();
	}

//	public boolean validatePitchBody(Pitch temp) {
//		
//		JSONObject containerObject = new  JSONObject(temp);
//		
//		//has method
//		if (containerObject.has("equity")) {
//		    //get Value of video
//		    return true;
//		}
//		try {
//			//pitch.setEntrepreneur(temp.getEntrepreneur());
//			
////			pitch.setPitchTitle(temp.getPitchTitle());
////			pitch.setPitchIdea(temp.getPitchIdea());
////			pitch.setAskAmount(temp.getAskAmount());
//			pitch.setEquity(temp.getEquity());
//			
//			//return true;
//		}
//		catch(Exception e){
//			return false;
//		}
//		finally {
//			
//		}
//		return false;
//	}

	public boolean validateEquity(Pitch pitch2) {
		// TODO Auto-generated method stub
		if(pitch2.getEquity()<=100) return true;
		return false;
	}
	
	public boolean validateEquityOffer(OfferDTOWithId offerDtoWithId) {
		// TODO Auto-generated method stub
		if(offerDtoWithId.getEquity()<=100) return true;
		return false;
	}

//	public boolean validateEntrepreneur(Pitch pitch2) {
//		// TODO Auto-generated method stub	
//		String string = pitch2.getEntrepreneur();
//		if(string == null || string.isEmpty() || string.trim().isEmpty()) return false;
//		else return true;
//	}
//	public boolean validateInvestor(OfferDTOWithId offerDtoWithId) {
//		// TODO Auto-generated method stub	
//		String string = offerDtoWithId.getInvestor();
//		if(string == null || string.isEmpty() || string.trim().isEmpty()) return false;
//		else return true;
//	}

	public boolean validateBody(Pitch pitch2) {
		
			float f = pitch2.getAskAmount();
			if(f==0) return false;
			String string =pitch2.getEntrepreneur();
			if(string == null || string.isEmpty() || string.trim().isEmpty()) return false;
			f = pitch2.getEquity();
			if(f==0) return false;
			string = pitch2.getPitchIdea();
			if(string == null) return false;
			string =pitch2.getPitchTitle();
			if(string == null) return false;
			return true;
	}
	
	public boolean validateBodyOffer(OfferDTOWithId offerDtoWithId) {
		try {
			String string = offerDtoWithId.getInvestor();
			if(string == null || string.isEmpty() || string.trim().isEmpty()) return false;
			float f = offerDtoWithId.getAmount();
			if(f==0) return false;
			f = offerDtoWithId.getEquity();
			if(f==0) return false;
			string = offerDtoWithId.getComment();
			if(string == null) return false;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

//	public boolean validatePitchId(int pitchId) {
//		// TODO Auto-generated method stub
//		PitchService s = new PitchService();
//		return s.getPitchById(pitchId);
//	}
}
