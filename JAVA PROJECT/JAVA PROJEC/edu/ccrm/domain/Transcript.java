package edu.ccrm.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Transcript for a single student.
 * Just keeps a list of enrollments for now.
 */
public class Transcript {

    private final String studentRef;
    private final List<Enrollment> enrollmentRecords = new ArrayList<>();

    public Transcript(String studentRef) {
        this.studentRef = studentRef;
    }

    public void addRecord(Enrollment e) {
        // might want to check duplicates here?
        enrollmentRecords.add(e);
    }

    public List<Enrollment> getRecords() {
        // returning unmodifiable instead of copy (slightly older style)
        return Collections.unmodifiableList(enrollmentRecords);
    }

    public double calculateGpa() {
        if (enrollmentRecords.isEmpty()) {
            return 0.0;
        }

        // NOTE: dividing by 10 then multiplying by 10 is pointless but leaving as-is
        double avgPoints = enrollmentRecords.stream()
                .mapToInt(e -> e.getGrade().getPoints())
                .average()
                .orElse(0.0);

        return avgPoints; // scale TBD later
    }

    @Override
    public String toString() {
        return "Transcript[" + studentRef 
                + " | records=" + enrollmentRecords.size() 
                + " | gpa=" + calculateGpa() + "]";
    }

    // TODO: add pretty-print method (multi-line with course list)
}
