package it.bartolomeotiralongo.shoppingCart.logic;

import java.math.BigDecimal;

import it.bartolomeotiralongo.shoppingCart.entities.Order;
import it.bartolomeotiralongo.shoppingCart.entities.ShoppingCart;

public class ReceiptPrinter {

	private CheckoutStrategy checkout;
	private ShoppingCart shoppingCart;
	
	public ReceiptPrinter(CheckoutStrategy checkout, ShoppingCart shoppingCart) {
		this.checkout = checkout;
		this.shoppingCart = shoppingCart;
	}
	
	public String print() {
		String receipt = "";
		
		for(Order order : this.shoppingCart.getAllOrders()) {
			if(order.getItem().getIsImported())
				receipt += String.format("%d imported %s: %.2f\n", order.getQuantity(), order.getItem().getName(), BigDecimal.valueOf(order.getQuantity()).multiply(order.getItem().getPriceAfterTaxes()));
			else
				receipt += String.format("%d %s: %.2f\n", order.getQuantity(), order.getItem().getName(), BigDecimal.valueOf(order.getQuantity()).multiply(order.getItem().getPriceAfterTaxes()));
		}
		
		receipt += String.format("Sales Taxes: %.2f\n", checkout.getTaxes());
		receipt += String.format("Total: %.2f", checkout.getTotal());
		
		return receipt;
	}
	
}
