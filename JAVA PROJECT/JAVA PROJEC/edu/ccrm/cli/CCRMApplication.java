package edu.ccrm.cli;

import edu.ccrm.io.ImportExportService;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.EnrollmentService;
import edu.ccrm.service.StudentService;

/**
 * Entry point for the CCRM demo app.
 * Not fancy, just wires things together for now.
 */
public class CCRMApplication {

    public static void main(String[] args) {
        // bootstrap basic services
        StudentService studentSvc = new StudentService();
        CourseService courseSvc = new CourseService();
        EnrollmentService enrollmentSvc = new EnrollmentService(courseSvc);
        ImportExportService ioSvc = new ImportExportService(studentSvc, courseSvc);

        // just drop in some sample data to make it less empty
        seedDemo(studentSvc, courseSvc);

        // run the menu loop (blocking)
        new MenuHandler(studentSvc, courseSvc, enrollmentSvc, ioSvc).run();

        // TODO: maybe add a shutdown hook for saving state
    }

    /**
     * Adds a couple of demo records so the app isn't empty.
     */
    private static void seedDemo(StudentService ss, CourseService cs) {
        // quick demo student
        ss.register("REG2025", new edu.ccrm.domain.Name("Maya", "Sharma"), "maya@example.com");

        // quick demo course
        cs.add("CS201", "Algorithms", 4, "Dr. Rao", edu.ccrm.domain.Semester.FALL, "CS");

        // NOTE: could load from a config file instead of hardcoding, but fine for now
        System.out.println("Demo data seeded.");
    }
}
