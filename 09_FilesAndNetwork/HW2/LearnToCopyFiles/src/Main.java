import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //TODO Папки запрашивайте у пользователя в консоли.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите адрес папки, которую необходимо скопировать");
        String pathWhichFolder = scanner.nextLine();  //D:\Skillbox\test1
        File folderOut = new File(pathWhichFolder);

        System.out.println("Укажите адрес куда скопировать");
        String pathWhereToCopy = scanner.nextLine();//D:\Skillbox\test2
        File folderIn = new File(pathWhereToCopy);

        //TODO Копирует одну указанную папку в другую. При копировании должны сохраниться файлы и структура папки
        try {

            CopyWithHelpNIO copyWithHelpNIO = new CopyWithHelpNIO();
            copyWithHelpNIO.copy(folderOut,folderIn);




//            DirectoryCopy dirCopy = new DirectoryCopy();
//            dirCopy.copy(folderOut, folderIn);

//            CopyDirAndFile copyDirAndFile = new CopyDirAndFile();
//            copyDirAndFile.copy(folderOut, folderIn);

        } catch (FileAlreadyExistsException ex) {
            ex.printStackTrace();
        }
        //TODO Программа должна перехватывать все исключения, возникающие при ошибках чтения файлов и папок, и выводить сообщение об ошибке с трассировкой стека (stack trace).

    }
}
