package it.bartolomeotiralongo.shoppingCart.interfaces;

public interface CheckoutService {
	public abstract void calculateTotal();
	public abstract String printReceipt();
}
