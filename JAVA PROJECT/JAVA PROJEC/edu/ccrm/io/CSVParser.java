package edu.ccrm.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Super basic CSV parser.
 * Only handles splitting by commas (no fancy quoting support yet).
 */
public class CSVParser {

    /**
     * Turns a list of CSV lines into a list of string arrays.
     */
    public List<String[]> parseLines(List<String> lines) {
        List<String[]> results = new ArrayList<>();

        if (lines == null || lines.isEmpty()) {
            return results; // nothing to do
        }

        for (String line : lines) {
            if (line == null || line.isBlank()) {
                continue; // skip blank lines
            }

            // NOTE: this is a naive split, won't handle commas inside quotes
            String[] columns = line.split(",", -1);

            // trimming each column manually (probably not needed, but safer)
            for (int i = 0; i < columns.length; i++) {
                columns[i] = columns[i].trim();
            }

            results.add(columns);
        }

        return results;
    }

    // TODO: maybe add support for quoted CSV values later (e.g., "Hello, World")
}
