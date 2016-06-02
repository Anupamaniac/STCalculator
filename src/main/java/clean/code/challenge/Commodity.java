package clean.code.challenge;

import java.math.BigDecimal;
import lombok.Data;


public @Data class Commodity extends Product
{
	private SalesTax salesTax;

	public Commodity(PRODUCT_TYPE productType, BigDecimal price)
	{
		this.price = price;
		this.productType = productType;
	}

	@Override
	public BigDecimal getPrice()
	{
		return this.price;
	}

}
