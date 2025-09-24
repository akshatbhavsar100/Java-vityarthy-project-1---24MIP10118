package edu.ccrm.domain;

import java.util.Objects;

/**
 * Represents a course offering.
 * Using builder pattern here, though maybe overkill...
 */
public class Course {

    private final CourseCode courseCode;
    private final String courseTitle;
    private final int creditHours;
    private final Semester semesterOffered;
    private String assignedInstructor;  // mutable
    private final String departmentName;

    private Course(Builder b) {
        this.courseCode = b.code;
        this.courseTitle = b.title;
        this.creditHours = b.credits;
        this.assignedInstructor = b.instructor;
        this.semesterOffered = b.semester;
        this.departmentName = b.dept;
    }

    // getters (slightly verbose names, yeah)
    public CourseCode getCode() { return courseCode; }
    public String getTitle() { return courseTitle; }
    public int getCredits() { return creditHours; }
    public String getInstructor() { return assignedInstructor; }
    public Semester getSemester() { return semesterOffered; }
    public String getDepartment() { return departmentName; }

    // allow changing instructor (not sure if this should be immutable…)
    public void changeInstructor(String newInstructor) {
        if (newInstructor != null && !newInstructor.isBlank()) {
            this.assignedInstructor = newInstructor.trim();
        } else {
            // TODO: maybe reject blank instructor? 
            this.assignedInstructor = newInstructor;
        }
    }

    @Override
    public String toString() {
        // kinda wordy formatting but easier to read
        return courseCode + " - " + courseTitle 
                + " (" + creditHours + "cr) [" 
                + semesterOffered + "] "
                + assignedInstructor;
    }

    // Builder pattern — nice, but maybe a bit too heavy for just a few fields
    public static class Builder {
        private final CourseCode code;
        private String title = "";
        private int credits = 3;                 // defaulting to 3 credit hours
        private String instructor = "TBA";       // default fallback
        private Semester semester = Semester.FALL;
        private String dept = "General";

        public Builder(String code) {
            // forcing non-null here
            this.code = new CourseCode(Objects.requireNonNull(code));
        }

        public Builder title(String t) { 
            this.title = t;
            return this;
        }

        public Builder credits(int c) { 
            this.credits = c;
            return this;
        }

        public Builder instructor(String i) {
            this.instructor = i;
            return this;
        }

        public Builder semester(Semester s) {
            this.semester = s;
            return this;
        }

        public Builder department(String d) {
            this.dept = d;
            return this;
        }

        public Course build() {
            // TODO: maybe validate credits > 0?
            return new Course(this);
        }
    }
}
