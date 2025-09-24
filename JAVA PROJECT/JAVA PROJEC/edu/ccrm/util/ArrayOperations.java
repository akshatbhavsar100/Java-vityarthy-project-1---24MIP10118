package edu.ccrm.util;

import java.util.Arrays;

/**
 * A couple of small array helper methods.
 * Might add more later if we end up needing them.
 */
public final class ArrayOperations {

    private ArrayOperations() {
        // don't let anyone instantiate this
    }

    /**
     * Joins an array of strings with a separator.
     * If the array is null/empty, returns an empty string.
     */
    public static String join(String[] arr, String sep) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        if (sep == null) {
            sep = ","; // default to comma just in case
        }

        // using built-in join, could also do a loop
        String result = String.join(sep, arr);
        return result;
    }

    /**
     * Returns a new array without the first element.
     */
    public static String[] tail(String[] arr) {
        if (arr == null || arr.length <= 1) {
            return new String[0]; // safer than throwing
        }

        // not super efficient, but fine for now
        String[] sliced = Arrays.copyOfRange(arr, 1, arr.length);
        return sliced;
    }

    // TODO: maybe add "head" or "concat" methods later
}
