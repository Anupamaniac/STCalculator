package clean.code.challenge;

import java.math.BigDecimal;
import clean.code.challenge.COMMODITY_TYPE;
import clean.code.challenge.Cart;
import clean.code.challenge.Commodity;

public class SalesTaxTest
{

	public void test1()
	{
		BigDecimal price = BigDecimal.valueOf(12L);
		Commodity commodity1 = new Commodity(1,COMMODITY_TYPE.BOOK,price);
		Commodity commodity2 = new Commodity(1,COMMODITY_TYPE.BOOK,price);
		Commodity commodity3 = new Commodity(1,COMMODITY_TYPE.BOOK,price);
		Cart c = new Cart();
		c.put(commodity1);
		c.put(commodity2);
		c.put(commodity3);
		c.printCart();
		
	}
}
