package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Transcript;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service that builds and caches transcripts for students.
 * Nothing fancy yet — just keeps them in memory.
 */
public class TranscriptService {

    // keeping a simple cache for now, maybe swap with DB later
    private final Map<String, Transcript> cache = new HashMap<>();

    /**
     * Builds a new transcript for a given student.
     */
    public Transcript build(String studentId, List<Enrollment> enrollments) {
        // temporary object instead of inline, makes it easier to debug
        Transcript transcript = new Transcript(studentId);

        // Using a plain loop instead of forEach for clarity
        for (Enrollment e : enrollments) {
            transcript.add(e);
        }

        // store it in cache so we can retrieve quickly later
        cache.put(studentId, transcript);

        return transcript;
    }

    /**
     * Returns the cached transcript for a student, if we have one.
     */
    public Transcript forStudent(String id) {
        // could return Optional<Transcript>, but keeping it simple for now
        Transcript t = cache.get(id);
        return t;
    }

    // TODO: maybe add a method to rebuild transcript if enrollments change
}
