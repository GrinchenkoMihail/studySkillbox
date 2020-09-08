import MyExeption.pathCheckExeption;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class CopyWithHelpNIO {

    public void copy(File source, File target) throws IOException {
        if (!source.exists()) {
            throw new pathCheckExeption("Директория введена неверно " + source.getName());
        }
            Files.walk(source.toPath()).forEach(file -> copyFile(file, source.toPath(), target.toPath()));

    }
    private void copyFile(Path file, Path pathDirSourth, Path pathDirDestination) {
        if (file.startsWith(pathDirDestination) || file.equals(pathDirDestination)) {
            return;
        }
        Path srcRelative = pathDirSourth.relativize(file);
        Path absFileDestination = pathDirDestination.resolve(srcRelative);
        try {
            if (file.toFile().isDirectory()) {
                Files.createDirectories(absFileDestination); // создаем директорию
            } else {
                Files.copy(file, absFileDestination); // копируем файл
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}



