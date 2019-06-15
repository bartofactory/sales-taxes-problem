package it.bartolomeotiralongo.shoppingCart.logic;

import java.math.BigDecimal;

import it.bartolomeotiralongo.shoppingCart.entities.Item;
import it.bartolomeotiralongo.shoppingCart.entities.Order;
import it.bartolomeotiralongo.shoppingCart.entities.ShoppingCart;
import it.bartolomeotiralongo.shoppingCart.interfaces.CheckoutService;

public class CheckoutStrategy implements CheckoutService{
	
	private ShoppingCart shoppingCart;
	private BigDecimal taxes;
	private BigDecimal total;
	
	public CheckoutStrategy(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
		this.taxes = BigDecimal.ZERO;
		this.total = BigDecimal.ZERO;
	}

	@Override
	public void calculateTotal() {
		for(Order order : this.shoppingCart.getAllOrders()) {
			Item item = order.getItem();
			BigDecimal costQuantityItem = item.getPriceAfterTaxes().multiply(BigDecimal.valueOf(order.getQuantity()));
			BigDecimal taxesQuantityItem = item.getTaxes().multiply(BigDecimal.valueOf(order.getQuantity()));
			this.total = this.total.add(costQuantityItem);
			this.taxes = this.taxes.add(taxesQuantityItem);
		}
	}

	@Override
	public String printReceipt() {
		ReceiptPrinter printer = new ReceiptPrinter(this);
		return printer.print();
	}

	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public BigDecimal getTaxes() {
		return taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
}
