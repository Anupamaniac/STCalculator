package clean.code.challenge;

import java.math.BigDecimal;

public class ImportDutyCalculator implements TaxCalculator
{

	@Override
	public BigDecimal calculate(Product p)
	{
		return BigDecimal.TEN;
	}

}
