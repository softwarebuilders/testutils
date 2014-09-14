package cz.softwarebuilders.testutils.junit.runner;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import cz.softwarebuilders.testutils.junit.runner.exceptions.OrderValidationException;

/**
 *
 * A simple JUnit runner to execute test methods by their specific {@link Order order}.
 *
 * @author Jan Klimes
 *
 */
public class OrderAwareRunner extends BlockJUnit4ClassRunner {

	public OrderAwareRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected List<FrameworkMethod> computeTestMethods() {
		List<FrameworkMethod> methods = super.computeTestMethods();
		validateMethodsIfNecessary(methods);
		List<FrameworkMethod> result = new ArrayList<FrameworkMethod>(methods);
		Collections.sort(result, new Comparator<FrameworkMethod>() {

			public int compare(FrameworkMethod o1, FrameworkMethod o2) {
				Order ord1 = findOrder(o1);
				Order ord2 = findOrder(o2);

				return ord1.order() - ord2.order();
			}
		});

		return Collections.unmodifiableList(result);
	}

	private void validateMethodsIfNecessary(List<FrameworkMethod> methods) {
		OrderValidation validation = getTestClass().getAnnotation(OrderValidation.class);
		if (validation != null && validation.on()) {
			if (validation.eachMethodMustHaveOrder()) {
				validateEachMethodHasSetOrder(methods);
			}

			if (validation.orderIsUnique()) {
				validateUniquenessOfOrder(methods);
			}
		}
	}

	private void validateEachMethodHasSetOrder(List<FrameworkMethod> methods) {
		for (FrameworkMethod m : methods) {
			if (m.getAnnotation(Order.class) == null) {
				throw new OrderValidationException("Each method must have set order but method " + m + " hasn't.");
			}
		}
	}

	private void validateUniquenessOfOrder(List<FrameworkMethod> methods) {
		Set<Integer> orders = new HashSet<Integer>();
		for (FrameworkMethod m : methods) {
			Order order = m.getAnnotation(Order.class);
			if (order != null) {
				if (orders.contains(order.order())) {
					throw new OrderValidationException("Order values must be unique but value " + order.order()
							+ " is used more than once.");
				}
				orders.add(order.order());
			}
		}
	}

	private Order findOrder(FrameworkMethod fwMethod) {
		Order order = fwMethod.getAnnotation(Order.class);
		if (order != null) {
			return order;
		} else {
			return new Order() {

				public Class<? extends Annotation> annotationType() {
					return Order.class;
				}

				public int order() {
					return 0;
				}
			};
		}
	}

}
