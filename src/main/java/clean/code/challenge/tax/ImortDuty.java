package clean.code.challenge.tax;

import java.math.BigDecimal;
import lombok.Data;

public @Data class ImortDuty implements Tax
{
	private BigDecimal taxValue;

	public ImortDuty(BigDecimal tax)
	{
		taxValue = tax;
	}

}
