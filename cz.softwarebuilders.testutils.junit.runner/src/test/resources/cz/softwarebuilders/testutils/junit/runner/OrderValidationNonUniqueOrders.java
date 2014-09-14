package cz.softwarebuilders.testutils.junit.runner;

import org.junit.Test;
import org.junit.runner.RunWith;

import cz.softwarebuilders.testutils.junit.runner.Order;
import cz.softwarebuilders.testutils.junit.runner.OrderAwareRunner;
import cz.softwarebuilders.testutils.junit.runner.OrderValidation;

@RunWith(OrderAwareRunner.class)
@OrderValidation()
public class OrderValidationNonUniqueOrders {

	@Test
	@Order(order = 0)
	public void a() {

	}

	@Test
	@Order(order = 1)
	public void b() {

	}

	@Test
	@Order(order = 2)
	public void c() {

	}

	@Test
	@Order(order = 3)
	public void d() {

	}

	@Test
	@Order(order = 4)
	public void e() {

	}

	@Test
	@Order(order = 5)
	public void f() {

	}

	@Test
	@Order(order = 6)
	public void g() {

	}

	@Test
	@Order(order = 7)
	public void aa() {

	}

	@Test
	@Order(order = 8)
	public void ba() {

	}

	@Test
	@Order(order = 9)
	public void ca() {

	}

	@Test
	@Order(order = 10)
	public void da() {

	}

	@Test
	@Order(order = 11)
	public void ea() {

	}

	@Test
	@Order(order = 12)
	public void fa() {

	}

	@Test
	@Order(order = 13)
	public void ga() {

	}

	@Test
	@Order(order = 14)
	public void aA() {

	}

	@Test
	@Order(order = 15)
	public void bA() {

	}

	@Test
	@Order(order = 16)
	public void cA() {

	}

	@Test
	@Order(order = 17)
	public void dA() {

	}

	@Test
	@Order(order = 18)
	public void eA() {

	}

	@Test
	@Order(order = 19)
	public void fA() {

	}

	@Test
	@Order(order = 10)
	public void gA() {

	}
}
