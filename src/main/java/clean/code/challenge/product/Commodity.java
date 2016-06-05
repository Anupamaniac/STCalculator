package clean.code.challenge.product;

import java.math.BigDecimal;
import clean.code.challenge.RoundingUtil;
import clean.code.challenge.tax.SalesTax;
import clean.code.challenge.tax.Tax;


public class Commodity extends Product
{
	private SalesTax salesTax;

	public Commodity(String description,PRODUCT_TYPE productType, BigDecimal price)
	{
		this.description = description;
		this.price = price;
		this.productType = productType;
	}

	@Override
	public BigDecimal getPrice()
	{
		return this.price;
	}
	
	@Override
	public BigDecimal getFinalPrice()
	{
		return RoundingUtil.round(this.price.add(this.salesTax.getBaseTax()));
	}

	@Override
	public PRODUCT_TYPE getProductType()
	{
		return this.productType;
	}

	@Override
	public void applyTax(Tax salestax)
	{
		this.salesTax = (SalesTax) salestax;
	}

}
