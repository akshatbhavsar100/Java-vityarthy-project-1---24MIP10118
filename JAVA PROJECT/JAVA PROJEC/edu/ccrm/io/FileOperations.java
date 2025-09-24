package edu.ccrm.io;

import edu.ccrm.config.AppConfig;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for basic file read/write operations.
 * Nothing fancy, just wraps Java NIO calls.
 */
public class FileOperations {

    // using config singleton for now (might want DI later)
    private final AppConfig cfg = AppConfig.get();

    /**
     * Makes sure storage folder exists before using it.
     */
    public Path ensureStorage() throws IOException {
        Path storagePath = cfg.storageFolder();

        // create dirs if missing (recursive)
        if (!Files.exists(storagePath)) {
            Files.createDirectories(storagePath);
        }

        return storagePath;
    }

    /**
     * Writes lines to a file. Overwrites if file already exists.
     */
    public void writeLines(Path file, List<String> lines) throws IOException {
        // sanity check, just in case
        if (lines == null) {
            lines = new ArrayList<>(); // don't want null pointer surprises
        }

        ensureStorage();

        // Using CREATE + TRUNCATE so it's always replaced
        Files.write(
                file,
                lines,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }

    /**
     * Reads all lines from a file. Returns empty list if file missing.
     */
    public List<String> readLines(Path file) throws IOException {
        if (!Files.exists(file)) {
            // not sure if this is best, but avoids exceptions for now
            return new ArrayList<>();
        }
        return Files.readAllLines(file);
    }

    /**
     * Just checks if a path exists.
     */
    public boolean exists(Path path) {
        // could inline, but this is clearer to me
        return Files.exists(path);
    }

    // TODO: maybe add "appendLines" method later for logs
}
