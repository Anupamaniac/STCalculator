package clean.code.challenge.product;

import java.util.Arrays;
import java.util.List;

public enum PRODUCT_TYPE
{
	BOOK("book"),
	MEDICAL("pills"),
	FOOD("chocolate"),
	OTHER;

	PRODUCT_TYPE(String... args)
	{
		this.productList = Arrays.asList(args);
	}

	private final List<String> productList;

	public boolean match(String productDescription)
	{
		return productList.stream().anyMatch((desc) -> (productDescription.toLowerCase().contains(desc.toLowerCase())));
	}

	public static PRODUCT_TYPE getValueOF(String productDescription)
	{
		for (PRODUCT_TYPE type : PRODUCT_TYPE.values())
		{
			if (type.match(productDescription))
			{
				return type;
			}
		}
		return OTHER;
	}
}
