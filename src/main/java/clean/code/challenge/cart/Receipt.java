package clean.code.challenge.cart;

public class Receipt
{

	private Cart cart;
	
	public Receipt(Cart cart)
	{
		this.cart = cart;
	}

	@Override
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		s.append("***********************Receipt***********************\n");
		cart.getProducts().forEach(product -> s.append( product.getDescription() +" : "+ product.getFinalPrice()+"\n"));
		s.append("Sales Tax : " + cart.getNetSalesTax()+"\n");
		s.append("Total : " + cart.netCartValue()+"\n");
		return s.toString();
	}
	
	

}
