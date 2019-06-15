package it.bartolomeotiralongo.shoppingCart.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import it.bartolomeotiralongo.shoppingCart.entities.Item;
import it.bartolomeotiralongo.shoppingCart.interfaces.TaxService;
import it.bartolomeotiralongo.shoppingCart.mapping.TaxExemption;

public class TaxStrategy implements TaxService{
	
	public static BigDecimal BASIC_TAX_RATE = new BigDecimal(0.10);
	public static BigDecimal IMPORT_TAX_RATE = new BigDecimal(0.05);

	private Item item;
	private BigDecimal taxes;
	
	public TaxStrategy(Item item) {
		this.item = item;
		this.taxes = BigDecimal.ZERO;
	}

	public BigDecimal calculateTaxes() {
		
		this.taxes = this.taxes.add(calculateImportTaxes(this.item)).add(calculateBasicTaxes(this.item));
		return this.taxes;
	}
	
	@Override
	public BigDecimal calculateImportTaxes(Item item) {
		
		BigDecimal importTax = BigDecimal.ZERO;
				
		if(item.getIsImported()) {
			importTax = importTax.add(IMPORT_TAX_RATE.multiply(item.getNetPrice()));
		}

		return roundToNearestFiveCent(importTax);	
	}

	@Override
	public BigDecimal calculateBasicTaxes(Item item) {
		BigDecimal basicTax = BigDecimal.ZERO;
		
		TaxExemption exemptions = new TaxExemption();
		
		if(!exemptions.getBasicSalesExemption().contains(item.getType())) {
			basicTax = basicTax.add(BASIC_TAX_RATE.multiply(item.getNetPrice()));
		}

		return roundToNearestFiveCent(basicTax);
	}
	
	private BigDecimal roundToNearestFiveCent(BigDecimal tax) {
		return tax.divide(BigDecimal.valueOf(0.05), 0, RoundingMode.UP).multiply(BigDecimal.valueOf(0.05)).setScale(2);
	}

}
