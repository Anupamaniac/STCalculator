package clean.code.challenge.tax;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorBuilder
{
 
	public static List<TaxCalculator> allApplicableTaxCalculators()
	{
		List<TaxCalculator> taxCalculators = new ArrayList<TaxCalculator>();
		taxCalculators.add(new SalesTaxCalculator());
		taxCalculators.add(new ImportDutyCalculator());
		return taxCalculators;
	}
}
