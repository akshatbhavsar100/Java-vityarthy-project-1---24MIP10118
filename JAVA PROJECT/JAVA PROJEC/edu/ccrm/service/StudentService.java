package edu.ccrm.service;

import edu.ccrm.domain.Name;
import edu.ccrm.domain.Student;

import java.time.LocalDate;
import java.util.*;

/**
 * Service for handling student stuff (register, search, etc).
 * Not super optimized yet – just getting it working.
 */
public class StudentService implements Persistable, Searchable<Student> {

    // Using a map so we can look up by ID quickly
    private final Map<String, Student> students = new HashMap<>();

    /**
     * Registers a new student and returns it.
     * Note: Right now, regNo uniqueness isn't enforced.
     */
    public Student register(String regNo, Name name, String email) {
        String generatedId = UUID.randomUUID().toString();

        // I guess LocalDate.now() is fine here, maybe we need something more configurable later
        Student newStudent = new Student(generatedId, regNo, name, email, LocalDate.now());

        students.put(generatedId, newStudent);
        return newStudent;
    }

    /**
     * Returns all students sorted by their full name.
     */
    public List<Student> listAll() {
        List<Student> result = new ArrayList<>(students.values());

        // could've used streams, but this feels easier to read
        result.sort(Comparator.comparing(s -> s.name().full()));
        return result;
    }

    /**
     * Just a quick lookup by student id.
     */
    public Student findById(String id) {
        // Slightly redundant variable, but makes debugging nicer
        Student found = students.get(id);
        return found;
    }

    @Override
    public List<Student> searchBy(String term) {
        if (term == null || term.isBlank()) {
            return Collections.emptyList(); // safer than null
        }

        String query = term.toLowerCase();
        List<Student> matches = new ArrayList<>();

        // Doing it the long way instead of streams – feels clearer to me
        for (Student s : students.values()) {
            String fullName = s.name().full().toLowerCase();
            String regNum = s.reg().toLowerCase();

            if (fullName.contains(query) || regNum.contains(query)) {
                matches.add(s);
            }
        }

        return matches;
    }

    @Override
    public void save() {
        // TODO: actually persist somewhere (file/db?)
    }

    @Override
    public void load() {
        // TODO: load from wherever we decide later
    }
}
