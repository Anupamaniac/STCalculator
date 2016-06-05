package clean.code.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingUtil
{

	public static BigDecimal round(BigDecimal value)
	{
		BigDecimal increment = 	BigDecimal.valueOf(.05);
		BigDecimal divided = value.divide(increment, 0, RoundingMode.UP);
		BigDecimal result = divided.multiply(increment);
		return result;
	}

}
