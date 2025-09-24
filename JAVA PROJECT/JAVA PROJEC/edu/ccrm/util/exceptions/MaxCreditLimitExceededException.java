package edu.ccrm.util.exceptions;

/**
 * Thrown when a student tries to enroll in courses
 * beyond the maximum allowed credit limit.
 */
public class MaxCreditLimitExceededException extends Exception {

    private static final long serialVersionUID = 42L; // arbitrary id, not sure if needed

    public MaxCreditLimitExceededException(String message) {
        super(message);
    }

    // a no-arg version with a generic message
    public MaxCreditLimitExceededException() {
        super("Maximum credit limit exceeded");
    }

    // handy if we ever want to chain exceptions
    public MaxCreditLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    // NOTE: Might not need all these constructors, but adding for flexibility
}
