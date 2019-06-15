package it.bartolomeotiralongo.shoppingCart.logic;

import java.math.BigDecimal;

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
		
		taxes.add(calculateImportTaxes(this.item));
		taxes.add(calculateBasicTaxes(this.item));
		
		return taxes;
	}
	
	@Override
	public BigDecimal calculateImportTaxes(Item item) {
		
		BigDecimal importTax = BigDecimal.ZERO;
				
		if(item.getIsImported()) {
			importTax = IMPORT_TAX_RATE.multiply(item.getNetPrice());
		}
		
		return importTax.setScale(2, BigDecimal.ROUND_HALF_UP);	
	}

	@Override
	public BigDecimal calculateBasicTaxes(Item item) {
		BigDecimal basicTax = BigDecimal.ZERO;
		
		TaxExemption exemptions = new TaxExemption();
		
		if(!exemptions.getBasicSalesExemption().contains(item.getType())) {
			basicTax = BASIC_TAX_RATE.multiply(item.getNetPrice());
		}
		
		return basicTax.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}
