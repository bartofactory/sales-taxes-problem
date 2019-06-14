package it.bartolomeotiralongo.shoppingCart.entities;

import exceptions.ZeroQuantityException;

/**
 * Order of the user
 * 
 * @author BartolomeoTiralongo
 *
 */
public class Order {

	private Item item;
	private int quantity;
	
	public Order(Item item) {
		super();
		this.item = item;
		this.quantity = 1;
	}
	
	public Order(Item item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void addItem() {
		this.quantity += 1;
	}
	
	public void removeItem() throws ZeroQuantityException {
		if(--this.quantity <= 0)
			throw new ZeroQuantityException();
		
		this.quantity -= 1;
	}
	
}
