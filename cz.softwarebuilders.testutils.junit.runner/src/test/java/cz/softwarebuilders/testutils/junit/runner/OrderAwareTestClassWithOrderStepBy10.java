package cz.softwarebuilders.testutils.junit.runner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(OrderAwareRunner.class)
public class OrderAwareTestClassWithOrderStepBy10 {

	@Test
	@Order(-100)
	public void a() {

	}

	@Test
	@Order(-90)
	public void b() {

	}

	@Test
	@Order(-80)
	public void c() {

	}

	@Test
	@Order(-70)
	public void d() {

	}

	@Test
	@Order(-60)
	public void e() {

	}

	@Test
	@Order(-50)
	public void f() {

	}

	@Test
	@Order(-40)
	public void g() {

	}

	@Test
	@Order(-30)
	public void aa() {

	}

	@Test
	@Order(-20)
	public void ba() {

	}

	@Test
	@Order(-10)
	public void ca() {

	}

	@Test
	@Order(0)
	public void da() {

	}

	@Test
	@Order(10)
	public void ea() {

	}

	@Test
	@Order(20)
	public void fa() {

	}

	@Test
	@Order(30)
	public void ga() {

	}

	@Test
	@Order(40)
	public void aA() {

	}

	@Test
	@Order(50)
	public void bA() {

	}

	@Test
	@Order(60)
	public void cA() {

	}

	@Test
	@Order(70)
	public void dA() {

	}

	@Test
	@Order(80)
	public void eA() {

	}

	@Test
	@Order(90)
	public void fA() {

	}

	@Test
	@Order(100)
	public void gA() {

	}
}
