package edu.ccrm.service;

import edu.ccrm.domain.*;
import edu.ccrm.exceptions.DuplicateEnrollmentException;
import edu.ccrm.exceptions.MaxCreditLimitExceededException;

import java.util.*;

/**
 * Handles student enrollments into courses.
 * Note: very simple implementation, no persistence yet.
 */
public class EnrollmentService {

    // maybe we should switch this to a Set later, but keeping List for now
    private final List<Enrollment> enrollments = new ArrayList<>();

    private final CourseService courses;
    private final int maxCredits = 18; // arbitrary cap for now

    public EnrollmentService(CourseService courses) {
        this.courses = courses;
    }

    /**
     * Enrolls a student into a course, checking for duplicates and max credits.
     */
    public void enroll(Student student, String courseCode)
            throws DuplicateEnrollmentException, MaxCreditLimitExceededException {

        CourseCode cc = new CourseCode(courseCode);

        // Check if already enrolled in this course
        for (Enrollment e : enrollments) {
            if (e.studentId().equals(student.id()) && e.course().equals(cc)) {
                throw new DuplicateEnrollmentException("Student is already enrolled in course " + courseCode);
            }
        }

        // Calculate current credits (kinda verbose but easier to follow than streams)
        int totalCredits = 0;
        for (Enrollment e : enrollments) {
            if (e.studentId().equals(student.id())) {
                Course existing = courses.find(e.course());
                if (existing != null) {
                    totalCredits += existing.credits();
                }
            }
        }

        // Fetch the course we're trying to enroll into
        Course targetCourse = courses.find(cc);
        if (targetCourse == null) {
            // just skip silently for now – maybe should throw exception later?
            return;
        }

        // Enforce max credits
        if (totalCredits + targetCourse.credits() > maxCredits) {
            throw new MaxCreditLimitExceededException("Max credit limit (" + maxCredits + ") exceeded.");
        }

        // Create new enrollment
        Enrollment enrollment = new Enrollment(student.id(), cc);
        enrollments.add(enrollment);

        // Keep student in sync
        student.addCourse(cc);
    }

    /**
     * Returns all enrollments (unmodifiable).
     */
    public List<Enrollment> all() {
        // could just return List.copyOf, but using Collections.unmodifiableList instead
        return Collections.unmodifiableList(enrollments);
    }

    /**
     * Returns all enrollments for a specific student.
     */
    public List<Enrollment> forStudent(String studentId) {
        List<Enrollment> results = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.studentId().equals(studentId)) {
                results.add(e);
            }
        }
        return results;
    }
}
