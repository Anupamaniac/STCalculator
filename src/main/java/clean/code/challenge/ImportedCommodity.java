package clean.code.challenge;

import java.math.BigDecimal;
import lombok.Data;

public @Data class ImportedCommodity extends Product
{
	Product product;
	
	private TaxCalculator calculator;
	
	public ImportedCommodity(Product product)
	{
		this.product = product;
		calculator = new ImportDutyCalculator();
		product.price = product.price.add(calculator.calculate(product));
	}

	public BigDecimal getPrice()
	{
		return this.product.getPrice();
	}

}
