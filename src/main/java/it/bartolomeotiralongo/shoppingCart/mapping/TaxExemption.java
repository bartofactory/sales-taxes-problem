package it.bartolomeotiralongo.shoppingCart.mapping;

import java.util.ArrayList;
import java.util.List;

import it.bartolomeotiralongo.shoppingCart.enums.ItemType;

public class TaxExemption {

	public List<ItemType> basicSalesExemption;
	
	public TaxExemption() {
		basicSalesExemption = new ArrayList<>();
		basicSalesExemption.add(ItemType.BOOK);
		basicSalesExemption.add(ItemType.FOOD);
		basicSalesExemption.add(ItemType.MEDICAL);
	}
	
	public List<ItemType> getBasicSalesExemption() {
		return basicSalesExemption;
	}
	
}
