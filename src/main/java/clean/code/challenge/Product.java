package clean.code.challenge;

import java.math.BigDecimal;

public abstract class Product
{

	protected BigDecimal price = BigDecimal.ZERO;
	protected PRODUCT_TYPE productType;
	
	abstract public BigDecimal getPrice();


}
