package edu.ccrm.util;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;

import java.util.Comparator;

/**
 * A few handy comparators for sorting.
 * Might add more later if needed.
 */
public final class Comparators {

    private Comparators() {
        // utility class, don't instantiate
    }

    /**
     * Compares students by their full name.
     */
    public static Comparator<Student> byName() {
        // not the most efficient, but clearer to read
        return new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                String n1 = s1.name().full();
                String n2 = s2.name().full();
                return n1.compareTo(n2);
            }
        };
    }

    /**
     * Compares courses by their course code.
     */
    public static Comparator<Course> byCode() {
        // could just do Comparator.comparing(c -> c.code().code()), but writing it long-form
        return (c1, c2) -> {
            String code1 = c1.code().code();
            String code2 = c2.code().code();
            return code1.compareTo(code2);
        };
    }

    // TODO: maybe add byCredits or bySemester later
}
