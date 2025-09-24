package edu.ccrm.cli;

import edu.ccrm.domain.Name;
import edu.ccrm.domain.Student;
import edu.ccrm.service.*;

import java.util.Scanner;

/**
 * Very simple CLI menu. Definitely not production grade :)
 * TODO: maybe refactor into commands later?
 */
public class MenuHandler {
    private final StudentService studentSvc;
    private final CourseService courseSvc;
    private final EnrollmentService enrollmentSvc;
    private final ImportExportService ioSvc;

    public MenuHandler(StudentService ss, CourseService cs, EnrollmentService es, ImportExportService io) {
        // kept short params but stored as longer names (bit inconsistent)
        this.studentSvc = ss;
        this.courseSvc = cs;
        this.enrollmentSvc = es;
        this.ioSvc = io;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("menu: 1-add-student 2-add-course 3-list-students 4-enroll 5-export 0-exit");
            String opt = sc.nextLine().trim();

            switch (opt) {
                case "1":
                    addStudent(sc);
                    break;
                case "2":
                    addCourse(sc);
                    break;
                case "3":
                    // could add pagination later if list grows too big
                    studentSvc.listAll().forEach(System.out::println);
                    break;
                case "4":
                    enroll(sc);
                    break;
                case "5":
                    try {
                        ioSvc.exportAll();
                        System.out.println("exported ok");
                    } catch (Exception e) {
                        // not super descriptive, but fine for now
                        System.err.println("Something went wrong during export: " + e.getMessage());
                    }
                    break;
                case "0":
                    keepRunning = false;
                    break;
                default:
                    System.out.println("unknown option, try again");
                    break;
            }
        }

        sc.close();
    }

    private void addStudent(Scanner sc) {
        System.out.println("given name:");
        String g = sc.nextLine();

        System.out.println("family name:");
        String f = sc.nextLine();

        System.out.println("reg no:");
        String reg = sc.nextLine();

        System.out.println("email:");
        String email = sc.nextLine();

        // should probably validate email, but skipping for now
        Student s = studentSvc.register(reg, new Name(g, f), email);
        System.out.println("added student with id " + s.id());
    }

    private void addCourse(Scanner sc) {
        System.out.println("code:");
        String code = sc.nextLine();

        System.out.println("title:");
        String title = sc.nextLine();

        System.out.println("credits:");
        int cr = Integer.parseInt(sc.nextLine());

        // hardcoding instructor + semester for now (lazy)
        courseSvc.add(code, title, cr, "Dr. Smith", edu.ccrm.domain.Semester.FALL, "General");
        System.out.println("course added: " + code);
    }

    private void enroll(Scanner sc) {
        System.out.println("student id:");
        String sid = sc.nextLine();

        System.out.println("course code:");
        String courseCode = sc.nextLine();

        Student s = studentSvc.findById(sid);
        if (s == null) {
            System.out.println("student not found!");
            return;
        }

        try {
            enrollmentSvc.enroll(s, courseCode);
            System.out.println("enrollment successful");
        } catch (Exception ex) {
            // printing error message only, no stacktrace for now
            System.out.println("err: " + ex.getMessage());
        }
    }
}
