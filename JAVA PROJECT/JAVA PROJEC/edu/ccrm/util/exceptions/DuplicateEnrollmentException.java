package edu.ccrm.util.exceptions;

/**
 * Thrown when a student tries to enroll in the same course twice.
 */
public class DuplicateEnrollmentException extends Exception {

    // default serialVersionUID, probably should add one...
    private static final long serialVersionUID = 1L;

    public DuplicateEnrollmentException(String message) {
        super(message);
    }

    // sometimes it's nice to have a no-arg constructor too
    public DuplicateEnrollmentException() {
        super("Duplicate enrollment not allowed");
    }

    // and one that takes a cause, just in case we chain
    public DuplicateEnrollmentException(String message, Throwable cause) {
        super(message, cause);
    }

    // TODO: decide if we actually need all these constructors
}
