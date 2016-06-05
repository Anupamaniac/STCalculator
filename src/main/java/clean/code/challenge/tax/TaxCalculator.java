package clean.code.challenge.tax;

import java.math.BigDecimal;
import clean.code.challenge.product.Product;

public interface TaxCalculator
{

	BigDecimal calculate(Product product);

}
