package com.tnas.assignment.ordersystem;

public class SweetsBasket extends Gift {

	public static final int ID_TYPE = 1;
	private static final String PREFIX_ID = "SB";
	
	private boolean hasNuts;

	public SweetsBasket(GiftSize size, boolean hasNuts) {
		super(PREFIX_ID.concat(String.valueOf(Gift.ID++)), size);
		this.hasNuts = hasNuts;
	}

	public boolean hasNuts() {
		return hasNuts;
	}

	public void setHasNuts(boolean hasNuts) {
		this.hasNuts = hasNuts;
	}
	
	@Override
	public String toString() {
		return "SweetsBasket [haveNuts=" + hasNuts + ", size=" + getSize().id() 
				+ ", id=" + getId() + ", price=" + getPrice() + "]";
	}
}
