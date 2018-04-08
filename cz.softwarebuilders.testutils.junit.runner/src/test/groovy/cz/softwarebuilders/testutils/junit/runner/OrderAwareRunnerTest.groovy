package cz.softwarebuilders.testutils.junit.runner

import groovy.transform.CompileStatic

import org.junit.Assert
import org.junit.Test
import org.junit.runners.model.FrameworkMethod
import org.junit.runners.model.InitializationError

import cz.softwarebuilders.testutils.junit.runner.exceptions.OrderValidationException

@CompileStatic
class OrderAwareRunnerTest extends Assert {
    List<String> methodNames = [
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "aa",
            "ba",
            "ca",
            "da",
            "ea",
            "fa",
            "ga",
            "aA",
            "bA",
            "cA",
            "dA",
            "eA",
            "fA",
            "gA"
    ];

    @Test(expected = InitializationError.class)
    void failForClassWithoutTests() {
        new OrderAwareRunner(ClassWithoutTestMethod.class);
    }

    @Test
    void computeTestMethodsForOrderAwareClass() {
        OrderAwareRunner runner = new OrderAwareRunner(OrderAwareTestClass.class);
        assertOrderedComputedMethods(runner.computeTestMethods());
    }

    @Test
    void computeTestMethodsForOrderAwareParentClass() {
        OrderAwareRunner runner = new OrderAwareRunner(OrderedAwareTestParentClass.class);
        assertOrderedComputedMethods(runner.computeTestMethods());
    }

    @Test
    void computeTestMethodsForOrderAwareParentClassChild() {
        OrderAwareRunner runner = new OrderAwareRunner(OrderAwareTestParentClassChild.class);
        assertOrderedComputedMethods(runner.computeTestMethods());
    }

    @Test
    void computeTestMethodsForOrderAwareClassWithStepByTen() {
        OrderAwareRunner runner = new OrderAwareRunner(OrderAwareTestClassWithOrderStepBy10.class);
        assertOrderedComputedMethods(runner.computeTestMethods());
    }


    @Test
    void computeMethodsForOrderUnawareClass() {
        OrderAwareRunner runner = new OrderAwareRunner(OrderUnawareTestClass.class);
        assertUnorderedComputedMethods(runner.computeTestMethods());
    }

    private assertUnorderedComputedMethods(List<FrameworkMethod> methods) {
        assertEquals("number of method names and computed methods is not same", methodNames.size(), methods.size());
        methods.each { FrameworkMethod m ->
            String mtdName = methodNames.find { String name -> name == m.name; }
            assertNotNull("method ${m?.name} not found", mtdName)
        }
    }

    @Test
    void computeTestMethodsWithOrderValidation() {
        OrderAwareRunner runner = new OrderAwareRunner(OrderAwareTestClassWithOrderValidation.class);
        assertOrderedComputedMethods(runner.computeTestMethods());
    }

    @Test(expected = OrderValidationException.class)
    void computeTestMethodsWithOrderValidationFailForNonUnique() {
        new OrderAwareRunner(OrderValidationNonUniqueOrders.class);
    }

    @Test(expected = OrderValidationException.class)
    void computeTestMethodsWithOrderValidationFailForNotAllMethodsHaveSetOrder() {
        new OrderAwareRunner(OrderValidationNotSetOrder.class);
    }

    @Test
    void computeTestMethodsWithOrderValidationNonUniqueOrderAllowed() {
        OrderAwareRunner runner = new OrderAwareRunner(OrderValidationNonUniqueOrdersAllowed.class);
        assertUnorderedComputedMethods(runner.computeTestMethods());
    }

    @Test
    void computeTestMethodsWithOrderValidationNotSetOrderAllowed() {
        OrderAwareRunner runner = new OrderAwareRunner(OrderValidationNotSetOrderAllowed.class);
        assertUnorderedComputedMethods(runner.computeTestMethods());
    }

    @Test
    void computeTestMethodsWithOrderValidationNotSetOrderIgnoredNonUniqueOrderIngnored() {
        OrderAwareRunner runner = new OrderAwareRunner(OrderValidationNotSetOrderNonUniqueOrders.class);
        assertUnorderedComputedMethods(runner.computeTestMethods());
    }


    private assertOrderedComputedMethods(List<FrameworkMethod> methods) {
        assertEquals("number of method names and computed methods is not same", methodNames.size(), methods.size());
        for (int i = 0; i < methodNames.size(); i++) {
            assertEquals("unexpected method name on index " + i, methodNames[i], methods[i].name);
        }
    }
}
