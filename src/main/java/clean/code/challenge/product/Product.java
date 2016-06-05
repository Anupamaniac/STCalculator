package clean.code.challenge.product;

import java.math.BigDecimal;
import clean.code.challenge.tax.Tax;

public abstract class Product
{
	protected String description;
	protected BigDecimal price = BigDecimal.ZERO;
	protected PRODUCT_TYPE productType;
	
	abstract public PRODUCT_TYPE getProductType();

	abstract public BigDecimal getPrice();
	
	abstract public void applyTax(Tax salestax);

	abstract public BigDecimal getFinalPrice();


}
