package clean.code.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.Test;
import clean.code.challenge.cart.Cart;
import clean.code.challenge.product.Commodity;
import clean.code.challenge.product.ImportedCommodity;
import clean.code.challenge.product.PRODUCT_TYPE;
import clean.code.challenge.product.Product;
import junit.framework.Assert;

public class SalesTaxTest
{
	
	/*Input 3:
		1 imported bottle of perfume at 27.99
		1 bottle of perfume at 18.99
		1 packet of headache pills at 9.75
		1 box of imported chocolates at 11.25


	Output 3:
		1 imported bottle of perfume: 32.19
		1 bottle of perfume: 20.89
		1 packet of headache pills: 9.75
		1 imported box of chocolates: 11.85
		Sales Taxes: 6.70
		Total: 74.68*/
	@Test
	public void test4()    
	{
		BigDecimal price =  BigDecimal.valueOf(27.99);
		Product commodity1 = new Commodity("Perfume",PRODUCT_TYPE.OTHER,price);
		commodity1 = new ImportedCommodity(commodity1);
		
		
		price =  BigDecimal.valueOf(18.99);
		Product commodity2 = new Commodity("Perfume",PRODUCT_TYPE.OTHER,price);
		
		price = BigDecimal.valueOf(9.75);
		Product commodity3 = new Commodity("Head ache pill",PRODUCT_TYPE.MEDICAL,price);
		
		price = BigDecimal.valueOf(11.25);
		Product commodity4 = new Commodity("Chocolates",PRODUCT_TYPE.FOOD,price);
		commodity4 = new ImportedCommodity(commodity4);
		
		
		Cart c = new Cart();
		c.put(commodity1);
		c.put(commodity2);
		c.put(commodity3);
		c.put(commodity4);
		c.printCart();
		
		Assert.assertEquals(new BigDecimal("32.19"), commodity1.getFinalPrice());
		Assert.assertEquals(BigDecimal.valueOf(20.89), commodity2.getFinalPrice());    
		Assert.assertEquals(BigDecimal.valueOf(9.75), commodity3.getFinalPrice());    
		Assert.assertEquals(BigDecimal.valueOf(11.85), commodity4.getFinalPrice());    
		
		Assert.assertEquals(new BigDecimal("6.70"), c.getNetSalesTax());
		
		Assert.assertEquals(new BigDecimal("74.68"), c.getNetSaleValue());
		
		
	}
	
	
	/*
	
	Input 2:
		1 imported box of chocolates at 10.00
		1 imported bottle of perfume at 47.50
		
		
	Output 2:
		1 imported box of chocolates: 10.50
		1 imported bottle of perfume: 54.65
	Sales Taxes: 7.65
	Total: 65.15


*/ 
	
	@Test
	public void test2()    
	{
		BigDecimal price =  BigDecimal.valueOf(47.50);
		Product commodity1 = new Commodity("Perfume",PRODUCT_TYPE.OTHER,price);
		commodity1 = new ImportedCommodity(commodity1);
		price = BigDecimal.valueOf(10.00);
		Product commodity2 = new Commodity("Chocolate",PRODUCT_TYPE.FOOD,price);
		commodity2 = new ImportedCommodity(commodity2);
		Cart c = new Cart();
		c.put(commodity1);
		c.put(commodity2);
		c.printCart();
		
		Assert.assertEquals(BigDecimal.valueOf(10.50).setScale(2, RoundingMode.HALF_UP), commodity2.getFinalPrice());
		Assert.assertEquals(BigDecimal.valueOf(54.65), commodity1.getFinalPrice());    
		Assert.assertEquals(new BigDecimal("7.65"), c.getNetSalesTax());
		
		Assert.assertEquals(new BigDecimal("65.15"), c.getNetSaleValue());
	}

	
/*  Input 1:
		1 book at 12.49
		1 music CD at 14.99
		1 chocolate bar at 0.85

	Output 1:
		1 book : 12.49
		1 music CD: 16.49
		1 chocolate bar: 0.85
		Sales Taxes: 1.50
		Total: 29.83*/
	@Test
	public void test1() 
	{
		BigDecimal price = BigDecimal.valueOf(12.49);
		Product commodity1 = new Commodity("book",PRODUCT_TYPE.BOOK,price);
		price = BigDecimal.valueOf(14.99);
		Product commodity2 = new Commodity("music CD",PRODUCT_TYPE.OTHER,price);
		price = BigDecimal.valueOf(.85);
		Product commodity3 = new Commodity("Chocolate",PRODUCT_TYPE.FOOD,price);
		Cart c = new Cart();
		c.put(commodity1);
		c.put(commodity2);
		c.put(commodity3);
		c.printCart();
		Assert.assertEquals(new BigDecimal("12.49"), commodity1.getFinalPrice());
		Assert.assertEquals(BigDecimal.valueOf(16.49), commodity2.getFinalPrice());    
		Assert.assertEquals(BigDecimal.valueOf(.85), commodity3.getFinalPrice());   
		
		Assert.assertEquals(new BigDecimal("1.50"), c.getNetSalesTax());
		
		Assert.assertEquals(new BigDecimal("29.83"), c.getNetSaleValue());
	}
	
	
}