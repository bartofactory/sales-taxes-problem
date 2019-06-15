package it.bartolomeotiralongo.shoppingCart.logic;

import java.math.BigDecimal;

import it.bartolomeotiralongo.shoppingCart.entities.Order;

public class ReceiptPrinter {

	private CheckoutStrategy checkout;
	
	public ReceiptPrinter(CheckoutStrategy checkout) {
		this.checkout = checkout;
	}
	
	public String print() {
		String receipt = "";
		
		for(Order order : checkout.getShoppingCart().getAllOrders()) {
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
