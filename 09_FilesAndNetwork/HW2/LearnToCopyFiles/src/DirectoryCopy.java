import MyExeption.pathCheckExeption;

import java.io.*;
import java.nio.file.Files;

public class DirectoryCopy {
    public void copy(File source, File target) throws IOException {
        if (!source.exists()) {
            throw new pathCheckExeption("Директория введена неверно " + source.getName());
        }
        if (source.isDirectory()) {
            copyDirectory(source, target);
        } else {
            copyFile(source, target);
        }
    }

    private void copyDirectory(File source, File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }

        for (String f : source.list()) {


            copy(new File(source, f), new File(target, f));
        }
    }

    private void copyFile(File source, File target) throws IOException {
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)
        ) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }
}
