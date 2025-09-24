package edu.ccrm.io;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.StudentService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles exporting (and eventually importing) data.
 * Right now, just dumps students and courses into text files.
 */
public class ImportExportService {

    private final FileOperations ops = new FileOperations();
    private final StudentService ss;
    private final CourseService cs;

    public ImportExportService(StudentService ss, CourseService cs) {
        this.ss = ss;
        this.cs = cs;
    }

    /**
     * Exports all students and courses into plain text files.
     */
    public void exportAll() throws IOException {
        Path storageFolder = ops.ensureStorage();

        Path studentsFile = storageFolder.resolve("students.txt");
        Path coursesFile = storageFolder.resolve("courses.txt");

        // manually building student list instead of neat streams
        List<String> studentLines = new ArrayList<>();
        for (Student s : ss.listAll()) {
            studentLines.add(s.toString());  // TODO: maybe make CSV later instead of toString()
        }

        // did this one with a stream, just to mix styles
        List<String> courseLines = cs.listAll()
                                     .stream()
                                     .map(Course::toString)
                                     .toList();

        ops.writeLines(studentsFile, studentLines);
        ops.writeLines(coursesFile, courseLines);
    }

    // TODO: implement import methods to rebuild Student/Course from files
}
