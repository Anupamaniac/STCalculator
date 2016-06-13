package clean.code.challenge.tax;

import java.math.BigDecimal;
import lombok.Data;

public @Data class Tax
{
	private BigDecimal taxValue;
	private TAX_TYPE taxType;
	
	public Tax(BigDecimal taxValue, TAX_TYPE taxType)
	{
		this.taxValue = taxValue;
		this.taxType = taxType;
	}
	
}
