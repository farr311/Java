package lesson19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileStreamsPractice {
    //TODO
    // Используя FileInputStream, прочитайте данные из файла A
    // И с помощью FileOutputStream допишете их в конец файла B

    // File A: ", my name is <ваше имя>"
    // File B: "Hello world"

    public static void main(String[] args)  {
        // fis = new FileInputStream("A");
        // fos = new FileOutputStream("B", true);
        // Files.copy(fis, fos)

        String path1 = "src/lesson19/A.txt";
        String path2 = "E:\\Projects\\Telran\\Java\\Java\\src\\lesson19\\B.txt";
        try (FileInputStream fis = new FileInputStream(path1);
                FileOutputStream fos = new FileOutputStream(path2, true)) {

            fis.transferTo(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
