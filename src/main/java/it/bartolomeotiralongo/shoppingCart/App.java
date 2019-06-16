package it.bartolomeotiralongo.shoppingCart;

import it.bartolomeotiralongo.shoppingCart.entities.Order;
import it.bartolomeotiralongo.shoppingCart.entities.ShoppingCart;
import it.bartolomeotiralongo.shoppingCart.logic.CheckoutStrategy;
import it.bartolomeotiralongo.shoppingCart.logic.OrderStringParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	Input 1:
    		2 book at 12.49
    		1 music CD at 14.99
    		1 chocolate bar at 0.85
    		
		Output 1:
			2 book: 24.98
			1 music CD: 16.49
			1 chocolate bar: 0.85
			Sales Taxes: 1.50
			Total: 42.32
		*/
    	
    	String orders = "2 book at 12.49\n" + 
    			"    		1 music CD at 14.99\n" + 
    			"    		1 chocolate bar at 0.85";
    	ShoppingCart shoppingCart = new ShoppingCart();
    	
    	for(String line : orders.split("\n")) {
    		OrderStringParser parser = new OrderStringParser(line);
    		Order o = parser.parse();
    		o.applyTaxes();
    		shoppingCart.addOrder(o);
    	}
    	
    	CheckoutStrategy checkout = new CheckoutStrategy(shoppingCart);
    	checkout.calculateTotal();
    	System.out.println(checkout.printReceipt());
    	
    	System.out.println("");
    	System.out.println(" ======================== ");
    	System.out.println("");
    	
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
    	
    	orders = "1 imported box of chocolates at 10.00\n" + 
    			"			1 imported bottle of perfume at 47.50";
    	shoppingCart = new ShoppingCart();
    	
    	for(String line : orders.split("\n")) {
    		OrderStringParser parser = new OrderStringParser(line);
    		Order o = parser.parse();
    		o.applyTaxes();
    		shoppingCart.addOrder(o);
    	}
    	
    	checkout = new CheckoutStrategy(shoppingCart);
    	checkout.calculateTotal();
    	System.out.println(checkout.printReceipt());
    	
    	System.out.println("");
    	System.out.println(" ======================== ");
    	System.out.println("");
    	
    	/*
    	Input 3:
    		1 imported bottle of perfume at 27.99
    		1 bottle of perfume at 18.99
    		1 packet of headache pills at 9.75
    		3 box of imported chocolates at 11.25
    		
		Output 3:
			1 imported bottle of perfume: 32.19
			1 bottle of perfume: 20.89
			1 packet of headache pills: 9.75
			3 imported box of chocolates: 35.55
			Sales Taxes: 7.90
			Total: 98.38
    	*/
    	
    	orders = "1 imported bottle of perfume at 27.99\n" + 
    			"    		1 bottle of perfume at 18.99\n" + 
    			"    		1 packet of headache pills at 9.75\n" + 
    			"    		3 box of imported chocolates at 11.25";
    	shoppingCart = new ShoppingCart();
    	
    	for(String line : orders.split("\n")) {
    		OrderStringParser parser = new OrderStringParser(line);
    		Order o = parser.parse();
    		o.applyTaxes();
    		shoppingCart.addOrder(o);
    	}
    	
    	checkout = new CheckoutStrategy(shoppingCart);
    	checkout.calculateTotal();
    	System.out.println(checkout.printReceipt());
    	
    }
}
