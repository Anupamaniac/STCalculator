package clean.code.challenge.cart;

import java.util.stream.IntStream;
import clean.code.challenge.product.Commodity;
import clean.code.challenge.product.ImportedCommodity;
import clean.code.challenge.product.Product;

public class CartBuilder
{

	private final CartItemParser parser;

	public CartBuilder()
	{
		this.parser = new CartItemParser();
	}

	private Product createCartItemFrom(String input)
	{
		Product commodity = new Commodity(parser.readDescription(input), parser.readProductType(input),
				parser.readPrice(input));
		if(commodity.getDescription().toLowerCase().contains("imported"))
		{
			commodity = new ImportedCommodity(commodity);
		}
		return commodity;
	}

	public Cart createShoppingCartFrom(String[] order)
	{
		Cart cart = new Cart();
		for (String orderItem : order)
		{
			int quantity = parser.readQuantity(orderItem);
			IntStream.range(0, quantity).forEach(i -> cart.put(createCartItemFrom(orderItem)));
		}
		return cart;
	}
}