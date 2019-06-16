package it.bartolomeotiralongo.shoppingCart.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.bartolomeotiralongo.shoppingCart.logic.CheckoutStrategy;

public class ShoppingCartTest {

	ShoppingCart shoppingCart;
		
	@Before
	public void setUp() throws Exception {
		shoppingCart = new ShoppingCart(new CheckoutStrategy());
	}

	@Test
	public void testShoppingCart() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllOrders() {
		fail("Not yet implemented");
	}

}
