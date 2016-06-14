package clean.code.challenge;

import java.math.BigDecimal;
import org.junit.Test;
import clean.code.challenge.util.RoundingUtil;
import junit.framework.Assert;

public class RoundingUtilTest
{

	@Test
	public void test3()
	{
		Assert.assertEquals(BigDecimal.valueOf(1.05), RoundingUtil.round(BigDecimal.valueOf(1.03)));
		Assert.assertEquals(new BigDecimal("1.10"), RoundingUtil.round(BigDecimal.valueOf(1.051)));
		Assert.assertEquals(BigDecimal.valueOf(1.05), RoundingUtil.round(BigDecimal.valueOf(1.05)));
		Assert.assertEquals(BigDecimal.valueOf(1.95), RoundingUtil.round(BigDecimal.valueOf(1.900001)));
	}
}
