package clean.code.challenge.tax;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

public @Data class SalesTax implements Tax
{
	private BigDecimal baseTax;
	private List<BigDecimal> otherTaxes;
	
	public SalesTax(BigDecimal tax)
	{
		baseTax = tax; 
	}
}
