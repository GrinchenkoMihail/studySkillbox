import MyExeption.pathCheckExeption;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CopyDirAndFile {
    public void copy(File source, File target) throws IOException {
        if (!source.exists()) {
            throw new pathCheckExeption("Директория" + source.getName()+ " введена неверно" );
        }
        if (!target.exists()) {
            throw new pathCheckExeption("Директория" + target.getName()+ " введена неверно");
        }
        FileUtils.copyDirectory(source, target);
    }
}
