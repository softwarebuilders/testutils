package cz.softwarebuilders.testutils.junit.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to set an order of a invocation of testing method. The order is used by {@link OrderAwareRunner junit
 * runner}.
 * 
 * @author Jan Klimes
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Order {
	/**
	 * Order number of method.
	 * 
	 * @return order or 0 (zero) by default
	 */
	int order() default 0;
}
