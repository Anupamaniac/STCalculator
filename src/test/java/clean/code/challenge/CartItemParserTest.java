package clean.code.challenge;

import java.math.BigDecimal;
import org.junit.Test;
import clean.code.challenge.cart.CartItemParser;
import clean.code.challenge.product.Commodity;
import clean.code.challenge.product.PRODUCT_TYPE;
import junit.framework.Assert;

public class CartItemParserTest
{
	@Test
	public void testParser()
	{
		String testInput = "1 imported box of chocolates at 10.50";
		CartItemParser parser = new CartItemParser();
		Commodity commodity = new Commodity(parser.readDescription(testInput),parser.readProductType(testInput),parser.readPrice(testInput));
		Assert.assertEquals(PRODUCT_TYPE.FOOD, commodity.getProductType());
		Assert.assertEquals(new BigDecimal("10.50"), commodity.getPrice());
		Assert.assertEquals("imported box of chocolates", commodity.getDescription());
	}
}
