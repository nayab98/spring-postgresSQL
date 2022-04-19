package com.springbootpostgreSQL.DTO;

public class OfferDTOWithId {
	
	private String id;
	
	private String investor;
	
	private float amount;
	
	private float equity;
	
	private String comment;

	public OfferDTOWithId(String id, String investor, float amount, float equity, String comment) {
		super();
		this.id = id;
		this.investor = investor;
		this.amount = amount;
		this.equity = equity;
		this.comment = comment;
	}

	public OfferDTOWithId() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "OfferDTOWithId [id=" + id + ", investor=" + investor + ", amount=" + amount + ", equity="
				+ equity + ", comment=" + comment + "]";
	}

	

}
