package edu.ccrm.domain;

/**
 * Base class for different types of people (students, teachers, etc.)
 * Not sure yet if this will be too restrictive, but let's see.
 */
public abstract class Person {

    // keeping id final (assuming it's immutable, like a DB key)
    protected final String personId;

    // These are mutable for now, might regret that later...
    protected Name fullName;
    protected String emailAddr;

    protected Person(String personId, Name fullName, String emailAddr) {
        this.personId = personId;
        this.fullName = fullName;
        this.emailAddr = emailAddr;
    }

    // getters (yeah, I'm not using Lombok here, just writing them out)
    public String getId() {
        return personId;
    }

    public Name getName() {
        return fullName;
    }

    public String getEmail() {
        return emailAddr;
    }

    // "mutators" — I don't love having these, but let's keep it flexible
    public void changeName(Name n) {
        // maybe should validate? but skipping for now
        this.fullName = n;
    }

    public void changeEmail(String e) {
        if (e != null && !e.isBlank()) {
            this.emailAddr = e.trim();
        } else {
            // not sure if we should allow blank email...
            this.emailAddr = e;
        }
    }

    // every subclass should say how it describes itself
    public abstract String summary();

    // TODO: consider adding equals/hashCode here
    // (depends on whether personId is globally unique)
}
