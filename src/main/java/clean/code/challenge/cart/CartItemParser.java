package clean.code.challenge.cart;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import clean.code.challenge.product.PRODUCT_TYPE;

public class CartItemParser
{

	public static final int DESCRIPTION = 2;
	public static final int PRICE = 3;
	// "1 imported box of chocolates: 10.50"
	private final String regexPattern = "(\\d+)\\s([\\w\\s]+)\\sat\\s(\\d+\\.\\d+)";
	private final Pattern inputPattern;

	public CartItemParser()
	{
		inputPattern = Pattern.compile(regexPattern);
	}

	public int readQuantity(final String input)
	{
		String[] parts = input.split(" ");
		return Integer.parseInt(parts[0]);
	}

	public PRODUCT_TYPE readProductType(final String input)
	{
		return PRODUCT_TYPE.getValueOF(input);
	}

	public String readDescription(final String input)
	{
		return read(input, DESCRIPTION);
	}

	public BigDecimal readPrice(final String input)
	{
		return new BigDecimal(read(input, PRICE));
	}

	private String read(final String input, final int groupNumber)
	{
		Matcher m = inputPattern.matcher(input);
		m.find();
		return m.group(groupNumber);
	}
}