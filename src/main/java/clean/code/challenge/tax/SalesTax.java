package clean.code.challenge.tax;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

public @Data class SalesTax 
{
	private BigDecimal baseTax;
	private List<BigDecimal> otherTaxes;
	
	public SalesTax(BigDecimal tax)
	{
		baseTax = tax; 
	}
}
