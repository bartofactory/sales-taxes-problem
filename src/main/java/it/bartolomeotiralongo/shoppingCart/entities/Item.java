package it.bartolomeotiralongo.shoppingCart.entities;

import java.math.BigDecimal;

import it.bartolomeotiralongo.shoppingCart.enums.ItemType;
import it.bartolomeotiralongo.shoppingCart.logic.TaxStrategy;

/***
 * Single item present in the store
 * 
 * @author Bartolomeo Tiralongo
 *
 */

public class Item {

	private String name;
	private BigDecimal netPrice;
	private ItemType type;
	private Boolean isImported;
	private BigDecimal taxes;

	public Item(String name, BigDecimal netPrice) {
		super();
		this.name = name;
		this.netPrice = netPrice;
		this.type = ItemType.OTHER;
		this.isImported = false;
		this.taxes = BigDecimal.ZERO;
	}
	
	public Item(String name, BigDecimal netPrice, ItemType type) {
		super();
		this.name = name;
		this.netPrice = netPrice;
		this.type = type;
		this.isImported = false;
		this.taxes = BigDecimal.ZERO;
	}
	
	public Item(String name, BigDecimal netPrice, ItemType type, Boolean isImported) {
		super();
		this.name = name;
		this.netPrice = netPrice;
		this.type = type;
		this.isImported = isImported;
		this.taxes = BigDecimal.ZERO;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getNetPrice() {
		return netPrice;
	}
	
	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}
	
	public ItemType getType() {
		return type;
	}
	
	public void setType(ItemType type) {
		this.type = type;
	}
	
	public Boolean getIsImported() {
		return isImported;
	}

	public void setIsImported(Boolean isImported) {
		this.isImported = isImported;
	}

	public BigDecimal getTaxes() {
		return taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}
	
	public BigDecimal getPriceAfterTaxes() {
		return netPrice.add(taxes);
	}
	
	public void applyTaxes() {
		TaxStrategy taxStrategy = new TaxStrategy(this);
		this.taxes = this.taxes.add(taxStrategy.calculateTaxes());
	}
	
}