package edu.ccrm.domain;

/**
 * Academic semesters — keeping it very basic for now.
 * Might need WINTER later if the school decides to split the calendar differently.
 */
public enum Semester {
    SPRING,
    SUMMER,
    FALL;

    // could add labels here if we ever want "Spring 2025" style formatting
    public String displayName() {
        // This is kinda redundant but more human-readable
        switch (this) {
            case SPRING: return "Spring";
            case SUMMER: return "Summer";
            case FALL:   return "Fall";
            default:     return this.name(); // shouldn't happen
        }
    }

    // TODO: maybe map these to months (e.g., SPRING -> March-May)?
}
