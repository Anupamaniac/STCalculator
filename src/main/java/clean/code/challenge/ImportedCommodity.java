package clean.code.challenge;

import java.math.BigDecimal;
import lombok.Data;

public @Data class ImportedCommodity extends Product implements ImportedProduct
{
	Product product;
	TaxCalculator importDutyCalculator;
	
	public ImportedCommodity(Product product)
	{
		this.product = product;
		importDutyCalculator = new ImportDutyCalculator();
		BigDecimal tax = calculateImportDuty(importDutyCalculator);
		product.applyTax(tax);
	}
	
	@Override
	public BigDecimal calculateImportDuty(TaxCalculator calculator)
	{
		return null;
	}
}
