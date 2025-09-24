package edu.ccrm.service;

import java.util.List;

/**
 * Just a quick generic search contract.
 * Might want to refine this later if we need advanced filters.
 */
public interface Searchable<T> {

    /**
     * Searches by some term (could be name, id, whatever we decide).
     * @param term - the search keyword, not super strict right now
     * @return list of results (empty if nothing found)
     */
    List<T> searchBy(String term);

    // TODO: Maybe add pagination? Or a fuzzy search option?
    // Leaving it simple for now.
}
