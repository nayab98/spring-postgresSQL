package com.springbootpostgreSQL.DTO;

public class SingleString {
	
	private String id;

	public SingleString(String id) {
		super();
		this.id = id;
	}

	public SingleString() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SingleString [id=" + id + "]";
	}
	
	

}
