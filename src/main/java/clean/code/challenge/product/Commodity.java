package clean.code.challenge.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import clean.code.challenge.tax.Tax;


public class Commodity extends Product
{
	private List<Tax> taxes = new ArrayList<Tax>();

	public Commodity(String description,PRODUCT_TYPE productType, BigDecimal price)
	{
		this.description = description;
		this.price = price;
		this.productType = productType;
	}

	public BigDecimal getPrice()
	{
		return this.price;
	}
	
	public BigDecimal getFinalPrice()
	{
		BigDecimal totalTax = BigDecimal.ZERO;
		for (Tax tax : taxes)
		{
			totalTax = totalTax.add(tax.getTaxValue());
		}
		return this.price.add(totalTax);
	}

	public PRODUCT_TYPE getProductType()
	{
		return this.productType;
	}

	public void applyTax(Tax tax)
	{
		taxes.add(tax);
	}
	
	public String getDescription()
	{
		return this.description;
	}

}
