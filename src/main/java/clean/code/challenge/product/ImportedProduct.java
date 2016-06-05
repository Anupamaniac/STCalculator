package clean.code.challenge.product;

import java.math.BigDecimal;
import clean.code.challenge.tax.TaxCalculator;

public interface ImportedProduct
{
	BigDecimal calculateImportDuty(TaxCalculator calculator);
}
