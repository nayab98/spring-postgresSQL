package com.springbootpostgreSQL.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Pitch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String entrepreneur;
	
	private String pitchTitle;
	
	private String pitchIdea;
	
	private float askAmount;
	
	private float equity;
	
	@OneToMany(mappedBy="pitch")
	private List<Offer> offers;
	
	
	public Pitch() {
		super();
	}

	public Pitch(String entrepreneur, String pitchTitle, String pitchIdea, float askAmount, float equity) {
		super();
		this.entrepreneur = entrepreneur;
		this.pitchTitle = pitchTitle;
		this.pitchIdea = pitchIdea;
		this.askAmount = askAmount;
		this.equity = equity;
	}

	public Pitch(int id, String entrepreneur, String pitchTitle, String pitchIdea, float askAmount, float equity,
			List<Offer> offers) {
		super();
		this.id = id;
		this.entrepreneur = entrepreneur;
		this.pitchTitle = pitchTitle;
		this.pitchIdea = pitchIdea;
		this.askAmount = askAmount;
		this.equity = equity;
		this.offers = offers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Pitch [id=" + id + ", entrepreneur=" + entrepreneur + ", pitchTitle=" + pitchTitle + ", pitchIdea="
				+ pitchIdea + ", askAmount=" + askAmount + ", equity=" + equity + ", offers=" + offers + "]";
	}

	

//	public Set<OfferDTOWithId> getOffers() {
//		return offers;
//	}
//
//	public void setOffers(Set<OfferDTOWithId> offers) {
//		this.offers = offers;
//	}
	
	
	
}













