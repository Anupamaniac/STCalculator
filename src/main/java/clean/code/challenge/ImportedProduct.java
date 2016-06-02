package clean.code.challenge;

import java.math.BigDecimal;

public interface ImportedProduct
{
	BigDecimal calculateImportDuty(TaxCalculator calculator);
}
