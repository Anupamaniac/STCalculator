package clean.code.challenge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart
{
	private List<Product> products = new ArrayList<Product>();
	private TaxCalculator taxCalculator;

	public Cart()
	{
		taxCalculator = new SalesTaxCalculator();
	}
	public void put(Product product)
	{
		products.add(product);
	}

	public void printCart()
	{
		products.forEach(product -> System.out.println(product.getPrice()));
		System.out.println(calculateSalesTax());
	}
	
	public BigDecimal calculateSalesTax()
	{
		BigDecimal tax = BigDecimal.ZERO;
		for (Product product : products)
		{
			tax = tax.add(taxCalculator.calculate(product));
		}
		return tax;
	}

}
