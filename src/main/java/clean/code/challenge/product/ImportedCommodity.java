package clean.code.challenge.product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import clean.code.challenge.tax.ImortDuty;
import clean.code.challenge.tax.ImportDutyCalculator;
import clean.code.challenge.tax.Tax;
import clean.code.challenge.tax.TaxCalculator;

public class ImportedCommodity extends Product
{
	private Product product;
	private ImortDuty duty;
	private TaxCalculator calculator;
	
	public ImportedCommodity(Product product)
	{
		this.product = product;
		calculator = new ImportDutyCalculator();
		duty = new ImortDuty(calculator.calculate(product));
		this.product.price = this.product.price.add(duty.getTaxValue());
	}

	public BigDecimal getPrice()
	{
		return this.product.getPrice();
	}

	@Override
	public PRODUCT_TYPE getProductType()
	{
		return this.product.getProductType();
	}

	@Override
	public void applyTax(Tax tax)
	{
		this.product.applyTax(tax);
	}

	@Override
	public BigDecimal getFinalPrice()
	{
		return this.product.getFinalPrice().setScale(2, RoundingMode.HALF_UP);
	}

}
