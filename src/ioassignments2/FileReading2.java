package ioassignments2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReading2 {

    public static void main(String[] args) {
        FileReading2 fileReading2 = new FileReading2();
        String source = "D:\\binary.docx";
        String dest = "D:\\TestDir\\binaryresult.docx";
        Path path = Paths.get(source);
        System.out.println(Files.exists(path));

        fileReading2.copyFileNio(source, dest);
        fileReading2.copyFileByte(source, dest);
        fileReading2.copyFileBuffer(source, dest);
    }


    //1.  Написать функциюpublic void copyFile(String from, String to){}
    // которая принимает файл и цель и копирует файл.
    // Например,copyFile(“c:\\temp\\bigfile.zip”, “c:\\temp2”)
    // должна скопировать ​bigfile.zip​ в папку ​temp2​.
    // Возможны 3 реализации: вычитывание файла побайтово, вычитывание блоками вбуфер заданного
    // размера или вычитывание того, что доступно для вычитывания с
    // использованием функции available(

    public void copyFileNio(String from, String to) {
        Path path1 = Paths.get(from);
        Path path2 = Paths.get(to);
        try {
            Files.copy(path1, path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFileByte(String from, String to) {
        try (InputStream in = new FileInputStream(from); OutputStream out = new FileOutputStream(to)) {
            int c;
            while ((c = in.read()) != -1)
                out.write(c);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copyFileBuffer(String from, String to) {
        try (InputStream in = new FileInputStream(from); OutputStream out = new FileOutputStream(to)) {
            byte[] buf = new byte[10];
            int bytesRead;
            while (((bytesRead = in.read(buf)) != -1))
                out.write(buf, 0, bytesRead);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
