package edu.ccrm.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Basic file-related utilities.
 * Right now only has recursive size calculator.
 */
public final class FileUtils {

    private FileUtils() {
        // utility class, no instantiation
    }

    /**
     * Calculates total size of all regular files under a given path.
     * Returns 0 if the path doesn't exist.
     */
    public static long sizeRecursive(Path path) throws IOException {
        if (path == null || !Files.exists(path)) {
            return 0L;
        }

        long totalSize = 0L;

        // using Files.walk, but iterating manually instead of streaming
        try (Stream<Path> stream = Files.walk(path)) {
            for (Path p : (Iterable<Path>) stream::iterator) {
                if (Files.isRegularFile(p)) {
                    try {
                        long fileSize = Files.size(p);
                        totalSize += fileSize;
                    } catch (IOException ex) {
                        // just skip unreadable files for now
                        System.err.println("Could not read size for: " + p);
                    }
                }
            }
        }

        return totalSize;
    }

    // TODO: maybe add deleteRecursive() later
}
