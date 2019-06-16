package it.bartolomeotiralongo.shoppingCart.logic;

import java.math.BigDecimal;

import it.bartolomeotiralongo.shoppingCart.entities.Item;
import it.bartolomeotiralongo.shoppingCart.entities.Order;
import it.bartolomeotiralongo.shoppingCart.entities.ShoppingCart;
import it.bartolomeotiralongo.shoppingCart.interfaces.CheckoutService;

public class CheckoutStrategy implements CheckoutService{
	
	private BigDecimal taxes;
	private BigDecimal total;
		
	public CheckoutStrategy() {
		this.taxes = BigDecimal.ZERO;
		this.total = BigDecimal.ZERO;
	}

	@Override
	public void calculateTotal(ShoppingCart shoppingCart) {		
		for(Order order : shoppingCart.getAllOrders()) {
			Item item = order.getItem();
			BigDecimal costQuantityItem = item.getPriceAfterTaxes().multiply(BigDecimal.valueOf(order.getQuantity()));
			BigDecimal taxesQuantityItem = item.getTaxes().multiply(BigDecimal.valueOf(order.getQuantity()));
			this.total = this.total.add(costQuantityItem);
			this.taxes = this.taxes.add(taxesQuantityItem);
		}
	}

	@Override
	public String printReceipt(ShoppingCart shoppingCart){
		ReceiptPrinter printer = new ReceiptPrinter(this, shoppingCart);
		return printer.print();
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
