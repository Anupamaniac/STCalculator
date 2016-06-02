package clean.code.challenge;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

public @Data class SalesTax
{
	private BigDecimal baseTax;
	private List<BigDecimal> otherTaxes;
}
