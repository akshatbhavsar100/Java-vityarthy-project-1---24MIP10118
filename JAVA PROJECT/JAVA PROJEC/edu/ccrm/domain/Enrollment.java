package edu.ccrm.domain;

import java.time.LocalDate;

/**
 * Represents a student enrolled in a course.
 * Could be extended later with semester/year, etc.
 */
public class Enrollment {

    private final String studentRef;    // just storing ID, not object (for now)
    private final CourseCode courseCode;
    private final LocalDate dateEnrolled;

    private Grade assignedGrade;

    public Enrollment(String studentRef, CourseCode courseCode) {
        this.studentRef = studentRef;
        this.courseCode = courseCode;
        this.dateEnrolled = LocalDate.now();
        this.assignedGrade = Grade.PASS;   // defaulting to PASS for now (kinda arbitrary)
    }

    // getters (slightly verbose, yeah)
    public String getStudentId() {
        return studentRef;
    }

    public CourseCode getCourse() {
        return courseCode;
    }

    public LocalDate getEnrolledOn() {
        return dateEnrolled;
    }

    public Grade getGrade() {
        return assignedGrade;
    }

    // mutator for grade
    public void assignGrade(Grade g) {
        if (g != null) {
            this.assignedGrade = g;
        }
        // TODO: maybe disallow downgrading from PASS to FAIL?
    }

    @Override
    public String toString() {
        // Using simple concat instead of String.format
        return studentRef + " -> " + courseCode
                + " (enrolled " + dateEnrolled + ")"
                + " grade=" + assignedGrade;
    }

    // Might add equals/hashCode here if enrollment is unique by (student, course)
}
