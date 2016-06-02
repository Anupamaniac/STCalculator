package clean.code.challenge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;


public @Data class Commodity extends Product
{
	private SalesTax salesTax;
	private List<BigDecimal> commodityTaxes;
	private List<TaxCalculator> taxCalculators = new ArrayList<TaxCalculator>();

	public Commodity(int i, COMMODITY_TYPE book, BigDecimal price)
	{
		// TODO Auto-generated constructor stub
	}

	public BigDecimal calculateTax()
	{
		BigDecimal tax = BigDecimal.ZERO;
		taxCalculators.forEach(calculator -> tax.add(calculator.calculate()));
		return null;
	}
}
