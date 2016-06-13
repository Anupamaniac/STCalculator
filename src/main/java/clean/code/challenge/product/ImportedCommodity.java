package clean.code.challenge.product;

import java.math.BigDecimal;
import clean.code.challenge.tax.Tax;

public class ImportedCommodity extends Product
{
	private Product product;
	
	public ImportedCommodity(Product product)
	{
		this.product = product;
	}

	@Override
	public PRODUCT_TYPE getProductType()
	{
		return product.getProductType();
	}

	@Override
	public BigDecimal getPrice()
	{
		return product.getPrice();
	}

	@Override
	public void applyTax(Tax salestax)
	{
		product.applyTax(salestax);
	}

	@Override
	public BigDecimal getFinalPrice()
	{
		return product.getFinalPrice();
	}

}
