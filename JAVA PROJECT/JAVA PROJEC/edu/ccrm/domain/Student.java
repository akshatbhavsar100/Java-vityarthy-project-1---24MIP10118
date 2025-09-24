package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a student in the system.
 * Extends Person. Could eventually add GPA, advisor, etc.
 */
public class Student extends Person {

    private final String regNumber;     // registration number
    private final LocalDate joinDate;   // when they joined

    // keeping as mutable list, but exposing a copy
    private final List<CourseCode> enrolledCourses = new ArrayList<>();

    public Student(String id, String regNumber, Name name, String email, LocalDate joinDate) {
        super(id, name, email);
        this.regNumber = regNumber;
        this.joinDate = joinDate;
    }

    public String getRegistration() {
        return regNumber;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void addCourse(CourseCode c) {
        if (c != null) {
            enrolledCourses.add(c);
        }
        // else silently ignore — maybe throw exception later?
    }

    public void dropCourse(CourseCode c) {
        enrolledCourses.remove(c);
    }

    // safer to return unmodifiable list instead of exposing original
    public List<CourseCode> getCourses() {
        return Collections.unmodifiableList(enrolledCourses);
    }

    @Override
    public String summary() {
        // not the prettiest formatting, but works
        return "Student[" + personId
                + " | " + regNumber
                + " | " + fullName.getFullName()
                + " | joined=" + joinDate
                + " | courses=" + enrolledCourses + "]";
    }

    @Override
    public String toString() {
        // just reuse summary for now (could diverge later)
        return summary();
    }

    // TODO: maybe add equals/hashCode so students can be compared properly
}
