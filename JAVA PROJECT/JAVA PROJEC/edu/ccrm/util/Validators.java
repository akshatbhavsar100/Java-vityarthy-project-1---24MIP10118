package edu.ccrm.util;

import java.util.regex.Pattern;

/**
 * Just a small utility for basic validations.
 * Might expand with more methods later (phone, ID, etc.).
 */
public final class Validators {

    // very simple email regex (doesn't cover all cases!)
    private static final Pattern EMAIL = Pattern.compile("^\\S+@\\S+\\.\\S+$");

    private Validators() {
        // prevent instantiation
    }

    /**
     * Quick and dirty email check.
     */
    public static boolean isEmail(String input) {
        if (input == null) {
            return false;
        }

        // trimming in case there's accidental whitespace
        String trimmed = input.trim();

        boolean matches = EMAIL.matcher(trimmed).matches();

        // could add logging here if needed
        return matches;
    }

    // TODO: add better validation rules later (this one is too naive)
}
