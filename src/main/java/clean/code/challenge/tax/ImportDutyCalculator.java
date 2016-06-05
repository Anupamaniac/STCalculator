package clean.code.challenge.tax;

import java.math.BigDecimal;
import clean.code.challenge.RoundingUtil;
import clean.code.challenge.product.Product;

public class ImportDutyCalculator implements TaxCalculator
{
	private double IMPORT_DUTY = .05;
	@Override
	public BigDecimal calculate(Product p)
	{
		BigDecimal importDuty =  p.getPrice().multiply(BigDecimal.valueOf(IMPORT_DUTY));
//		importDuty = RoundingUtil.round(importDuty);
		return importDuty;
	}

}
