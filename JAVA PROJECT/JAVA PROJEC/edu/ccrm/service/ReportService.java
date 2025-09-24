package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;

import java.util.List;

/**
 * Very simple reporting service.
 * Just spits out summaries for now — might evolve into proper report objects later.
 */
public class ReportService {

    /**
     * Creates a text summary of a student with their enrollment count.
     */
    public String studentSummary(Student student, List<Enrollment> enrollments) {
        if (student == null) {
            return "No student data available";
        }

        // using size directly, no fancy calculation for now
        int totalEnrollments = (enrollments == null) ? 0 : enrollments.size();

        // could be formatted nicer, but just keeping it string-based
        return student.summary() + " | enrollments=" + totalEnrollments;
    }

    /**
     * Creates a text summary for a course with its enrollment count.
     */
    public String courseSummary(Course course, List<Enrollment> enrollments) {
        if (course == null) {
            return "No course data available";
        }

        long enrolledCount = 0;
        if (enrollments != null) {
            // doing it the old-fashioned way instead of stream count
            for (Enrollment e : enrollments) {
                // a little clunky, but comparing string forms for now
                if (e.course().toString().equals(course.code().toString())) {
                    enrolledCount++;
                }
            }
        }

        // returning a very plain summary, might want to JSONify this later
        return course.toString() + " | enrolled=" + enrolledCount;
    }

    // TODO: maybe add a "full report" generator (per student/per course)
}
