import MyExeption.pathChechExeption;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSizeCalculation {
    public static long getSumOfFilesSize(File folder) throws IOException {
        if (!folder.exists()) {
            throw new pathChechExeption("Директория введена неверно");
        }
        System.out.println("Загрузка ...");

        return Files.walk(folder.toPath())
                .map(Path::toFile)
                .mapToLong(File::length)
                .sum();
    }
}
