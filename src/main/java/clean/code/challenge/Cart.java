package clean.code.challenge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import clean.code.challenge.product.Product;
import clean.code.challenge.tax.Tax;
import clean.code.challenge.tax.TaxCalculator;
import clean.code.challenge.tax.TaxCalculatorBuilder;
import lombok.Data;

public @Data class Cart
{
	private List<Product> products = new ArrayList<Product>();
	private List<TaxCalculator> taxCalculators;
	private BigDecimal netSalesTax = BigDecimal.ZERO;

	public Cart()
	{
		taxCalculators = TaxCalculatorBuilder.allApplicableTaxCalculators();
	}

	public void put(Product product)
	{
		taxCalculators.stream().forEach(calculator -> {
			Tax tax = calculator.calculate(product);
			if (tax != null)
			{
				product.applyTax(tax);
				netSalesTax = netSalesTax.add(tax.getTaxValue());
			}
		});
		products.add(product);
	}

	public void printCart()
	{
		products.forEach(product -> System.out.println(product.getFinalPrice()));
		System.out.println(netSalesTax);
	}

	public BigDecimal netCartValue()
	{
		BigDecimal netSale = BigDecimal.ZERO;
		for (Product product : products)
		{
			netSale = netSale.add(product.getFinalPrice());
		}
		this.netSalesTax = netSale;
		return this.netSalesTax;
	}

}
