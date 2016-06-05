package clean.code.challenge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import clean.code.challenge.product.Product;
import clean.code.challenge.tax.SalesTax;
import clean.code.challenge.tax.SalesTaxCalculator;
import clean.code.challenge.tax.TaxCalculator;
import lombok.Data;

public @Data class Cart
{
	private List<Product> products = new ArrayList<Product>();
	private TaxCalculator taxCalculator;
	private BigDecimal netSalesTax = BigDecimal.ZERO;

	public Cart()
	{
		taxCalculator = new SalesTaxCalculator();
	}
	public void put(Product product)
	{	
		SalesTax salesTax = new SalesTax(taxCalculator.calculate(product));
		product.applyTax(salesTax);
		products.add(product);
		netSalesTax = netSalesTax.add(salesTax.getBaseTax());
	}

	public void printCart()
	{
		products.forEach(product -> System.out.println(product.getFinalPrice()));
		System.out.println(netSalesTax);
	}
	
	public BigDecimal netCartValue()
	{
		BigDecimal netSale = BigDecimal.ZERO;
		products.forEach(product -> netSale.add(product.getFinalPrice()));
		return netSale;
	}
	
}
