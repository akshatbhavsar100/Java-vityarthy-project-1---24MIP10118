# JAVA VITYARTHI PROJECT - 24MIP10118
Akshat Bhavsar

# Campus Course & Records Manager (CCRM)

## Project Overview

The Campus Course & Records Manager (CCRM) is a console-based Java SE
application designed to help educational institutes manage their
academic workflows.

The system supports:\
- Students: Add, update, deactivate, manage enrollments, and print
transcripts.\
- Courses: Create, update, search and filter by department, semester, or
instructor.\
- Enrollment and Grading: Enroll/unenroll students, record marks,
compute GPA, and generate transcripts.\
- File Utilities: Import/export data using CSV-like files, backup
records, and recursive utilities (like calculating backup folder size).

This project demonstrates Object-Oriented Programming (OOP), Java SE
APIs (Streams, NIO.2, Date/Time), and design patterns such as Singleton
and Builder.

------------------------------------------------------------------------

## How to Run

1.  Install JDK 17 or later.\

2.  Clone this repository:

    ``` bash
    git clone <repo-link>
    cd CampusCourseRecordsManager
    ```

3.  Compile and run:

    ``` bash
    javac -d bin src/**/*.java
    java -cp bin edu.ccrm.cli.Main
    ```

4.  Or import into Eclipse IDE → New Java Project → Run Main class.

------------------------------------------------------------------------

## Evolution of Java

-   1995: Java 1.0 released by Sun Microsystems.\
-   2004: Java 5 introduced Generics, Enums, and Annotations.\
-   2011: Java 7 added NIO.2 and try-with-resources.\
-   2014: Java 8 introduced Streams, Lambdas, and Date/Time API.\
-   2017 onwards: Java 9--17 added modules, var, records, sealed
    classes, and pattern matching.

------------------------------------------------------------------------

## Java Editions

  -------------------------------------------------------------------------------
  Edition              Purpose                      Example Use
  -------------------- ---------------------------- -----------------------------
  Java ME              Lightweight apps for         Feature phones, IoT
                       embedded/mobile devices      

  Java SE              Core platform for standard   This project (console-based
                       desktop apps                 app)

  Java EE (Jakarta EE) Enterprise/web/distributed   Banking systems, e-commerce
                       systems                      
  -------------------------------------------------------------------------------

------------------------------------------------------------------------

## Java Architecture

-   JDK (Java Development Kit): Tools for developers, includes compiler
    and JRE.\
-   JRE (Java Runtime Environment): Provides JVM and core libraries.\
-   JVM (Java Virtual Machine): Executes compiled bytecode.

Flow: Source Code → Compiler → Bytecode → JVM → Execution

------------------------------------------------------------------------

## Installation on Windows

1.  Download JDK (Oracle or OpenJDK).\

2.  Install and set JAVA_HOME in Environment Variables.\

3.  Verify installation:

    ``` bash
    java -version
    ```

4.  In Eclipse IDE: Create a new Java Project, add source folder, and
    run Main class.

------------------------------------------------------------------------

## Mapping: Syllabus Topics to Project

  -----------------------------------------------------------------------
  Topic                           Example
  ------------------------------- ---------------------------------------
  Encapsulation                   Student class with private fields and
                                  getters/setters

  Inheritance                     Person (abstract) → Student, Instructor

  Abstraction                     Abstract methods in Person

  Polymorphism                    TranscriptService interface with
                                  multiple implementations

  Interfaces                      Persistable, Searchable`<T>`{=html}

  Lambdas and Streams             Filtering courses by
                                  semester/instructor

  Enums                           Semester, Grade

  Singleton                       AppConfig

  Builder                         Course.Builder

  Exception Handling              DuplicateEnrollmentException,
                                  MaxCreditLimitExceededException

  File I/O (NIO.2)                ImportExportService, BackupService

  Recursion                       Recursive backup size computation

  Assertions                      Enforcing ID non-null and credit limits
  -----------------------------------------------------------------------

------------------------------------------------------------------------

## Usage Examples

-   Add Student: Input details through CLI.\
-   Enroll Student: Choose student and course code.\
-   Record Grades: Enter marks, GPA auto-computed.\
-   Export Data: Creates CSV files in /exports.\
-   Backup: Copies exports into /backup/yyyyMMdd_HHmmss.

------------------------------------------------------------------------

## Notes

-   Run with assertions enabled:

    ``` bash
    java -ea -cp bin edu.ccrm.cli.Main
    ```

-   Includes both checked and unchecked exceptions.\

-   Errors vs Exceptions explained in comments and documentation.

------------------------------------------------------------------------

## Deliverables

-   Source Code (organized into packages).\
-   README.md (this file).\
-   Screenshots folder (JDK setup, Eclipse run, program output,
    backups).\
-   Sample test-data CSVs.\
-   Optional demo video link.

------------------------------------------------------------------------

## Acknowledgements

This project was developed as part of the Programming in Java
coursework.

References:\
- Oracle Java Documentation: https://docs.oracle.com/javase/\
- Baeldung Java Tutorials: https://www.baeldung.com/\
- GeeksforGeeks Java Programming Guide:
https://www.geeksforgeeks.org/java/\
- Eclipse IDE Documentation: https://help.eclipse.org/

