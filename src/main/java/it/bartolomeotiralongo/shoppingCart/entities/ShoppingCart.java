package it.bartolomeotiralongo.shoppingCart.entities;

import java.util.HashSet;

import it.bartolomeotiralogno.shoppingCart.exceptions.ZeroQuantityException;

public class ShoppingCart {
	
	private HashSet<Order> shoppingCart;
	
	public ShoppingCart() {
		this.shoppingCart = new HashSet<>();
	}
	
	public void addOrder(Order order) {
		
		// Check if an element is already present in shopping cart
		if(this.shoppingCart.contains(order)) {
			
			// Add quantity
			for(Order orderInCart : this.shoppingCart) {
				if(orderInCart.equals(order)) {
					orderInCart.addItem();
				}
			}
			
		}else {
			
			// Add new Order
			this.shoppingCart.add(order);
			
		}
	}
	
	public boolean removeOrder(Order order) {
		
		boolean status = false;
		
		// Check if an element is already present in shopping cart
		if(this.shoppingCart.contains(order)) {
			
			// Reduce quantity
			for(Order orderInCart : this.shoppingCart) {
				if(orderInCart.equals(order)) {
					try {
						orderInCart.removeItem();
					}catch (ZeroQuantityException e) {
						status = this.shoppingCart.remove(orderInCart);
					}
				}
			}
		}

		return status;
		
	}
	
	public HashSet<Order> getAllOrders(){
		return this.shoppingCart;
	}
	
}
