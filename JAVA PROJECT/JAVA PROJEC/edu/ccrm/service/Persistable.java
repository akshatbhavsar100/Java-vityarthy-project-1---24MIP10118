package edu.ccrm.service;

/**
 * Something that can be saved/loaded.
 * Not sure yet if this should throw exceptions or return boolean...
 */
public interface Persistable {

    // save the object somewhere (DB, file, whatever)
    void save();

    // load the object (probably from the same place it was saved)
    void load();

    // TODO: maybe add delete()? or saveAsync()?
}
