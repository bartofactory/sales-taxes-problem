package it.bartolomeotiralongo.shoppingCart.interfaces;

import it.bartolomeotiralongo.shoppingCart.entities.ShoppingCart;

public interface CheckoutService {
	public abstract void calculateTotal(ShoppingCart shoppingCart);
	public abstract String printReceipt(ShoppingCart shoppingCart);
}
