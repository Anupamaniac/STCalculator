package clean.code.challenge.tax;

import java.math.BigDecimal;
import org.apache.commons.lang3.EnumUtils;
import clean.code.challenge.product.Product;
import clean.code.challenge.util.RoundingUtil;

public class SalesTaxCalculator implements TaxCalculator
{
	private double SALES_TAX_RATE = .1;
	@Override
	public Tax calculate(Product product)
	{
		BigDecimal salesTax = BigDecimal.ZERO;
		if (!EnumUtils.isValidEnum(EXEMPTED_PRODUCT.class, product.getProductType().toString()))
		{
			salesTax = product.getPrice().multiply(BigDecimal.valueOf(SALES_TAX_RATE));
			salesTax = RoundingUtil.round(salesTax);
			return new Tax(salesTax,TAX_TYPE.SALES_TAX);
		}
		return null;
	}
}
