package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.CourseCode;
import edu.ccrm.domain.Semester;

import java.util.*;

/**
 * Service layer for managing courses.
 * Keeping things simple for now — might need to rethink persistence later.
 */
public class CourseService implements Persistable, Searchable<Course> {

    // Using LinkedHashMap so insertion order is preserved (handy for listing)
    private final Map<CourseCode, Course> courses = new LinkedHashMap<>();

    /**
     * Adds a new course and registers it internally.
     * Not checking for duplicates yet!
     */
    public Course add(String code, String title, int credits, String instructor, Semester sem, String dept) {
        // using builder pattern from Course
        Course newCourse = new Course.Builder(code)
                .title(title)
                .credits(credits)
                .instructor(instructor)
                .semester(sem)
                .department(dept)
                .build();

        CourseCode cc = new CourseCode(code); // a bit redundant, but clearer
        courses.put(cc, newCourse);

        return newCourse;
    }

    /**
     * Returns all courses in the order they were added.
     */
    public List<Course> listAll() {
        // No sorting for now, just return in insertion order
        return new ArrayList<>(courses.values());
    }

    /**
     * Finds a course by its CourseCode.
     */
    public Course find(CourseCode code) {
        if (code == null) {
            return null; // could throw exception later
        }
        return courses.get(code);
    }

    @Override
    public List<Course> searchBy(String term) {
        if (term == null || term.isEmpty()) {
            return Collections.emptyList();
        }

        String lowered = term.toLowerCase();
        List<Course> found = new ArrayList<>();

        // opted for old-fashioned loop instead of streams here
        for (Course c : courses.values()) {
            String courseTitle = c.title().toLowerCase();
            String courseCode = c.code().code().toLowerCase();

            if (courseTitle.contains(lowered) || courseCode.contains(lowered)) {
                found.add(c);
            }
        }

        return found;
    }

    @Override
    public void save() {
        // TODO: figure out how we want to persist (DB? JSON? text file?)
    }

    @Override
    public void load() {
        // TODO: reload courses from whatever storage we pick
    }
}
