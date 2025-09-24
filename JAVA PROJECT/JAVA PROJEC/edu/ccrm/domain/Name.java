package edu.ccrm.domain;

import java.util.Objects;

/**
 * Simple wrapper for a person's name.
 * Might want to add middle name support later, not sure yet.
 */
public final class Name {

    private final String first;   // a.k.a. "given"
    private final String last;    // a.k.a. "family"

    public Name(String first, String last) {
        // not allowing nulls here, trims just in case user puts extra spaces
        this.first = Objects.requireNonNull(first, "First name required").trim();
        this.last = Objects.requireNonNull(last, "Last name required").trim();

        // TODO: maybe handle empty strings better? ("" isn't very useful...)
    }

    // return full display, e.g. "John Doe"
    public String getFullName() {
        // Using simple concat for now, should be fine
        return first + " " + last;
    }

    // probably could just use Lombok here... but eh
    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        // returning the same thing as full name (no reason to reinvent)
        return getFullName();
    }

    // Might want equals/hashCode later if this gets used in collections
    // @Override
    // public boolean equals(Object o) { ... }
}
