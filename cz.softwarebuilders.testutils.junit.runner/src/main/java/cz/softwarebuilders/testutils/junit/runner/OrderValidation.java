package cz.softwarebuilders.testutils.junit.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validation metadata for {@link OrderAwareRunner order aware runner}.
 * 
 * @author Jan Klimes
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OrderValidation {
	/**
	 * Turns validation on/off.
	 * 
	 * @return <code>true</code> if validation is on <code>false</code> if validation is off, defaults to
	 *         <code>true</code>
	 */
	boolean on() default true;

	/**
	 * Gets if each testing method has also set {@link Order order}.
	 * 
	 * @return <code>true</code> if each method must have order, <code>false</code> if not, defaults to
	 *         <code>true</code>
	 */
	boolean eachMethodMustHaveOrder() default true;

	/**
	 * Get if order value of a tests method is unique within tested class.
	 * 
	 * @return <code>true</code> if is, <code>false</code> if not, defaults to <code>true</code>
	 */
	boolean orderIsUnique() default true;
}
