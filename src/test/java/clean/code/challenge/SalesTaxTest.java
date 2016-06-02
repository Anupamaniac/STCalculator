package clean.code.challenge;

import java.math.BigDecimal;
import org.junit.Test;

public class SalesTaxTest
{

	@Test
	public void test1()
	{
		BigDecimal price = BigDecimal.valueOf(12L);
		Product commodity1 = new Commodity(PRODUCT_TYPE.BOOK,price);
		commodity1 = new ImportedCommodity(commodity1);
		Product commodity2 = new Commodity(PRODUCT_TYPE.BOOK,price);
		Product commodity3 = new Commodity(PRODUCT_TYPE.BOOK,price);
		Cart c = new Cart();
		c.put(commodity1);
		c.put(commodity2);
		c.put(commodity3);
		c.printCart();
		
	}
}
