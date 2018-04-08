package cz.softwarebuilders.testutils.junit.runner.exceptions;

/**
 * Exception to indicate order validation failures.
 *
 * @author Jan Klimes
 */
public class OrderValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public OrderValidationException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public OrderValidationException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public OrderValidationException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public OrderValidationException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public OrderValidationException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
