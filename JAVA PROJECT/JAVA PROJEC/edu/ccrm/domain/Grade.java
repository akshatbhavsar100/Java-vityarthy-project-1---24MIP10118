package edu.ccrm.domain;

/**
 * Letter grades with associated point values.
 * Using a simple 10–0 scale for now.
 */
public enum Grade {
    A_PLUS(10),
    A(9),
    B(8),
    C(7),
    D(6),
    PASS(5),
    FAIL(0);

    private final int pointValue;

    Grade(int pointValue) {
        this.pointValue = pointValue;
    }

    public int getPoints() {
        return pointValue;
    }

    // quick helper for "is passing?"
    public boolean isPassing() {
        return this != FAIL;
    }

    @Override
    public String toString() {
        // slightly redundant but makes it clearer in logs
        return name() + "(" + pointValue + ")";
    }

    // TODO: maybe add fromPoints(int) or fromString(String) later
    // public static Grade fromPoints(int pts) { ... }
}
