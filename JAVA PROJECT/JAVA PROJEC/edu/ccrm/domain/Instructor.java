package edu.ccrm.domain;

/**
 * Represents an instructor (lecturer, professor, etc.)
 * Extends Person. Could add office hours or rank later.
 */
public class Instructor extends Person {

    // the department/unit they belong to
    private String departmentUnit;

    public Instructor(String id, Name name, String email, String departmentUnit) {
        super(id, name, email);
        this.departmentUnit = departmentUnit;
    }

    // getter (yeah, naming is a bit inconsistent with Student class...)
    public String getUnit() {
        return departmentUnit;
    }

    // mutator (not sure if we should allow unit changes... but keeping it)
    public void setUnit(String newUnit) {
        if (newUnit != null && !newUnit.isBlank()) {
            this.departmentUnit = newUnit.trim();
        } else {
            // TODO: maybe throw exception instead of accepting blanks
            this.departmentUnit = newUnit;
        }
    }

    @Override
    public String summary() {
        // quick summary string — might clean up formatting later
        return "Instructor[" 
                + personId + " | " 
                + fullName.getFullName() + " | " 
                + emailAddr + " | unit=" 
                + departmentUnit + "]";
    }

    @Override
    public String toString() {
        // just delegate to summary for now
        return summary();
    }

    // Might add equals/hashCode later, depends how instructors
