package edu.ccrm.domain;

import java.util.Objects;

/**
 * Represents a course code like "CS101" or "MATH-200".
 * Keeping it very simple for now.
 */
public final class CourseCode {

    private final String rawCode;

    public CourseCode(String rawCode) {
        // not allowing nulls and also normalizing
        String tmp = Objects.requireNonNull(rawCode, "course code required");
        this.rawCode = tmp.trim().toUpperCase();
    }

    public String getCode() {
        // Maybe later add some validation logic (regex for format, etc.)
        return rawCode;
    }

    @Override
    public String toString() {
        // just return the normalized code, no fancy stuff
        return rawCode;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;   // quick check
        if (!(other instanceof CourseCode)) {
            return false;
        }
        CourseCode cc = (CourseCode) other;
        return this.rawCode.equals(cc.rawCode);
    }

    @Override
    public int hashCode() {
        // just delegate to string hash
        return rawCode.hashCode();
    }

    // Note: maybe add compareTo() later if we want sorting by code
    // public int compareTo(CourseCode o) {
    //     return this.rawCode.compareTo(o.rawCode);
    // }
}
