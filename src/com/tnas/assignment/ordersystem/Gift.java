package com.tnas.assignment.ordersystem;

public class Gift {

	protected static int ID = 3150;
	
	private String id;
	
	private GiftSize size;
	
	public Gift(String id, GiftSize size) {
		this.id = id;
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public GiftSize getSize() {
		return size;
	}

	public void setSize(GiftSize size) {
		this.size = size;
	}

	protected float getPrice() {
		return this.size.flatFee();
	}

}
