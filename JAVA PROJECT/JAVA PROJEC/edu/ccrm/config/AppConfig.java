package edu.ccrm.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Basic app configuration holder.
 * Singleton style (yeah, not everyone's favorite, but fine for now).
 */
public final class AppConfig {

    // singleton instance
    private static AppConfig instance;

    // where files get stored (defaults under user.home/ccrm-data)
    private Path storagePath;

    // timestamp format for backups, exports, etc.
    private final DateTimeFormatter stampFmt = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    private AppConfig() {
        storagePath = Paths.get(System.getProperty("user.home"), "ccrm-data");

        // debug print (can remove later)
        System.out.println("Storage folder set to: " + storagePath);
    }

    public static synchronized AppConfig get() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public Path storageFolder() {
        return storagePath;
    }

    public String nowStamp() {
        // might want to allow configurable formats later
        return LocalDateTime.now().format(stampFmt);
    }

    // TODO: replace this with proper DI (Spring or something?) if project grows
}
