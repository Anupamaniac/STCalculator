package clean.code.challenge.tax;

import java.math.BigDecimal;
import clean.code.challenge.RoundingUtil;
import clean.code.challenge.product.ImportedCommodity;
import clean.code.challenge.product.Product;

public class ImportDutyCalculator implements TaxCalculator
{
	private double IMPORT_DUTY = .05;
	@Override
	public Tax calculate(Product p)
	{
		if (p instanceof ImportedCommodity)
		{
			BigDecimal importDuty =  p.getPrice().multiply(BigDecimal.valueOf(IMPORT_DUTY));
			importDuty = RoundingUtil.round(importDuty);
			return new Tax(importDuty,TAX_TYPE.IMPORT_DUTY);
		}
		return null;
	}

}
