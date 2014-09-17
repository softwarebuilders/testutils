package cz.softwarebuilders.testutils.junit.runner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(OrderAwareRunner.class)
public class OrderAwareTestClassWithOrderStepBy10 {

	@Test
	@Order(order = -100)
	public void a() {

	}

	@Test
	@Order(order = -90)
	public void b() {

	}

	@Test
	@Order(order = -80)
	public void c() {

	}

	@Test
	@Order(order = -70)
	public void d() {

	}

	@Test
	@Order(order = -60)
	public void e() {

	}

	@Test
	@Order(order = -50)
	public void f() {

	}

	@Test
	@Order(order = -40)
	public void g() {

	}

	@Test
	@Order(order = -30)
	public void aa() {

	}

	@Test
	@Order(order = -20)
	public void ba() {

	}

	@Test
	@Order(order = -10)
	public void ca() {

	}

	@Test
	@Order(order = 0)
	public void da() {

	}

	@Test
	@Order(order = 10)
	public void ea() {

	}

	@Test
	@Order(order = 20)
	public void fa() {

	}

	@Test
	@Order(order = 30)
	public void ga() {

	}

	@Test
	@Order(order = 40)
	public void aA() {

	}

	@Test
	@Order(order = 50)
	public void bA() {

	}

	@Test
	@Order(order = 60)
	public void cA() {

	}

	@Test
	@Order(order = 70)
	public void dA() {

	}

	@Test
	@Order(order = 80)
	public void eA() {

	}

	@Test
	@Order(order = 90)
	public void fA() {

	}

	@Test
	@Order(order = 100)
	public void gA() {

	}
}
