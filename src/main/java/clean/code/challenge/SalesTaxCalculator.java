package clean.code.challenge;

import java.math.BigDecimal;

public class SalesTaxCalculator implements TaxCalculator
{
	@Override
	public BigDecimal calculate(Product product)
	{
		return BigDecimal.valueOf(2);
	}
}
