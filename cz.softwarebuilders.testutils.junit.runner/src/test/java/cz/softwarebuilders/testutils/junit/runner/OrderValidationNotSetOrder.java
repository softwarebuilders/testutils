package cz.softwarebuilders.testutils.junit.runner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(OrderAwareRunner.class)
@OrderValidation
@Ignore
public class OrderValidationNotSetOrder {

    @Test
    @Order(0)
    public void a() {

    }

    @Test
    @Order(1)
    public void b() {

    }

    @Test
    @Order(2)
    public void c() {

    }

    @Test
    @Order(3)
    public void d() {

    }

    @Test
    @Order(4)
    public void e() {

    }

    @Test
    @Order(5)
    public void f() {

    }

    @Test
    @Order(6)
    public void g() {

    }

    @Test
    @Order(7)
    public void aa() {

    }

    @Test
    @Order(8)
    public void ba() {

    }

    @Test
    @Order(9)
    public void ca() {

    }

    @Test
    public void da() {

    }

    @Test
    @Order(11)
    public void ea() {

    }

    @Test
    @Order(12)
    public void fa() {

    }

    @Test
    @Order(13)
    public void ga() {

    }

    @Test
    @Order(14)
    public void aA() {

    }

    @Test
    @Order(15)
    public void bA() {

    }

    @Test
    @Order(16)
    public void cA() {

    }

    @Test
    @Order(17)
    public void dA() {

    }

    @Test
    @Order(18)
    public void eA() {

    }

    @Test
    @Order(19)
    public void fA() {

    }

    @Test
    @Order(20)
    public void gA() {

    }
}
