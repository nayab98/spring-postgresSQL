package com.springbootpostgreSQL.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Offer {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	private String investor;
	
	private float amount;
	
	private float equity;
	
	private String comment;
	
	@ManyToOne//(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "pitch_id")//, nullable = false)
	//@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonIgnore
	private Pitch pitch;

	public Offer(String investor, float amount, float equity, String comment, Pitch pitch) {
		super();
		this.investor = investor;
		this.amount = amount;
		this.equity = equity;
		this.comment = comment;
		this.pitch = pitch;
	}

	public Offer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int offerId) {
		this.id = offerId;
	}

	public String getInvestor() {
		return investor;
	}

	public void setInvestor(String investor) {
		this.investor = investor;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getEquity() {
		return equity;
	}

	public void setEquity(float equity) {
		this.equity = equity;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Pitch getPitch() {
		return pitch;
	}

	public void setPitch(Pitch pitch) {
		this.pitch = pitch;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id+ ", investor=" + investor + ", amount=" + amount + ", equity=" + equity
				+ ", comment=" + comment + ", pitch=" + pitch + "]";
	}
	
	

}