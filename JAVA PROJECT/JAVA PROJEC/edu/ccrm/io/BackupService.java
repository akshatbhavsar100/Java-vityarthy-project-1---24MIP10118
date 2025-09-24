package edu.ccrm.io;

import edu.ccrm.config.AppConfig;

import java.io.IOException;
import java.nio.file.*;

public class BackupService {
    private final AppConfig cfg = AppConfig.get();

    public Path snapshot() throws IOException {
        Path root = cfg.storageFolder();
        if (!Files.exists(root)) Files.createDirectories(root);
        Path target = root.resolve("backup-" + cfg.nowStamp());
        Files.createDirectories(target);
        try (var s = Files.list(root)) {
            s.filter(p->Files.isRegularFile(p)).forEach(p -> {
                try { Files.copy(p, target.resolve(p.getFileName()), StandardCopyOption.REPLACE_EXISTING); } catch (Exception ignored) {}
            });
        }
        return target;
    }
}
