package com.springbootpostgreSQL.DTO;

import java.util.List;

import com.springbootpostgreSQL.model.Pitch;

public class PitchWithOffers {
	
	private String id;

	private String entrepreneur;
	
	private String pitchTitle;
	
	private String pitchIdea;
	
	private float askAmount;
	
	private float equity;
	
	private List<OfferDTOWithId> offers;

	public PitchWithOffers(String id, String entrepreneur, String pitchTitle, String pitchIdea, float askAmount,
			float equity, List<OfferDTOWithId> offers) {
		super();
		this.id = id;
		this.entrepreneur = entrepreneur;
		this.pitchTitle = pitchTitle;
		this.pitchIdea = pitchIdea;
		this.askAmount = askAmount;
		this.equity = equity;
		this.offers = offers;
	}

	
	public PitchWithOffers(String id, String entrepreneur, String pitchTitle, String pitchIdea, float askAmount,
			float equity) {
		super();
		this.id = id;
		this.entrepreneur = entrepreneur;
		this.pitchTitle = pitchTitle;
		this.pitchIdea = pitchIdea;
		this.askAmount = askAmount;
		this.equity = equity;
	}


	public PitchWithOffers() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntrepreneur() {
		return entrepreneur;
	}

	public void setEntrepreneur(String entrepreneur) {
		this.entrepreneur = entrepreneur;
	}

	public String getPitchTitle() {
		return pitchTitle;
	}

	public void setPitchTitle(String pitchTitle) {
		this.pitchTitle = pitchTitle;
	}

	public String getPitchIdea() {
		return pitchIdea;
	}

	public void setPitchIdea(String pitchIdea) {
		this.pitchIdea = pitchIdea;
	}

	public float getAskAmount() {
		return askAmount;
	}

	public void setAskAmount(float askAmount) {
		this.askAmount = askAmount;
	}

	public float getEquity() {
		return equity;
	}

	public void setEquity(float equity) {
		this.equity = equity;
	}

	public List<OfferDTOWithId> getOffers() {
		return offers;
	}

	public void setOffers(List<OfferDTOWithId> offers) {
		this.offers = offers;
	}

	@Override
	public String toString() {
		return "PitchWithOffers [id=" + id + ", entrepreneur=" + entrepreneur + ", pitchTitle=" + pitchTitle
				+ ", pitchIdea=" + pitchIdea + ", askAmount=" + askAmount + ", equity=" + equity + ", offers=" + offers
				+ "]";
	}
	
	

}