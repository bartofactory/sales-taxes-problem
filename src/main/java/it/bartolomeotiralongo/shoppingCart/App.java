package it.bartolomeotiralongo.shoppingCart;

import java.math.BigDecimal;

import it.bartolomeotiralongo.shoppingCart.entities.Item;
import it.bartolomeotiralongo.shoppingCart.entities.Order;
import it.bartolomeotiralongo.shoppingCart.entities.ShoppingCart;
import it.bartolomeotiralongo.shoppingCart.enums.ItemType;
import it.bartolomeotiralongo.shoppingCart.logic.CheckoutStrategy;

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
    	
    	Item item1 = new Item("book", BigDecimal.valueOf(12.49), ItemType.BOOK).applyTaxes();
    	Item item2 = new Item("music CD", BigDecimal.valueOf(14.99), ItemType.OTHER).applyTaxes();
    	Item item3 = new Item("chocolate bar", BigDecimal.valueOf(0.85), ItemType.FOOD).applyTaxes();
    	
    	Order order1 = new Order(item1, 2);
    	Order order2 = new Order(item2);
    	Order order3 = new Order(item3);
    	
    	ShoppingCart shoppingCart = new ShoppingCart();
    	shoppingCart.addOrder(order1);
    	shoppingCart.addOrder(order2);
    	shoppingCart.addOrder(order3);
    	
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
    	
    	item1 = new Item("box of chocolates", BigDecimal.valueOf(10.00), ItemType.FOOD, true).applyTaxes();
    	item2 = new Item("bottle of perfume", BigDecimal.valueOf(47.50), ItemType.OTHER, true).applyTaxes();
    	
    	order1 = new Order(item1);
    	order2 = new Order(item2);
    	
    	shoppingCart = new ShoppingCart();
    	shoppingCart.addOrder(order1);
    	shoppingCart.addOrder(order2);
    	
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
    	
    	item1 = new Item("bottle of perfume", BigDecimal.valueOf(27.99), ItemType.OTHER, true).applyTaxes();
    	item2 = new Item("bottle of perfume", BigDecimal.valueOf(18.99), ItemType.OTHER).applyTaxes();
    	item3 = new Item("headache pills", BigDecimal.valueOf(9.75), ItemType.MEDICAL).applyTaxes();
    	Item item4 = new Item("chocolates", BigDecimal.valueOf(11.25), ItemType.FOOD, true).applyTaxes();
    	
    	order1 = new Order(item1);
    	order2 = new Order(item2);
    	order3 = new Order(item3);
    	Order order4 = new Order(item4, 3);
    	
    	shoppingCart = new ShoppingCart();
    	shoppingCart.addOrder(order1);
    	shoppingCart.addOrder(order2);
    	shoppingCart.addOrder(order3);
    	shoppingCart.addOrder(order4);
    	
    	checkout = new CheckoutStrategy(shoppingCart);
    	checkout.calculateTotal();
    	System.out.println(checkout.printReceipt());
    	
    }
}
