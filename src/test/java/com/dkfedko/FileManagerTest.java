package com.dkfedko;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;


public class FileManagerTest {
    String path = "src/test/resources";
    FileManager fileManager = new FileManager();

    @Test
    void shouldCountFolders() {

        assertNotNull(path);
        assertFalse(path.isEmpty());

        int actual = fileManager.countFolders(path);
        assertEquals(6, actual);

    }

    @Test
    void shouldCopyFile() {

        String from = "src/test/resources/test-dir1/testFile1.txt";
        String to = "src/test/resources/test-dir1/test-dir1_2/testFile1.txt";

        fileManager.copy(from, to);

    }

    @Test
    void shouldMoveFiles() {

        String from = "src/test/resources/test-dir1/test-dir1_2/testFile1.txt";
        String to = "src/test/resources/test-dir2/test-dir2_1/testFile1.txt";
        fileManager.move(from, to);
    }


    @Test
    void shouldCopyFileUsingIO() {

        String from = "src/test/resources/test-dir1/testFile1.txt";
        String to = "src/test/resources/test-dir1/test-dir1_2/testFile1.txt";

        fileManager.copyByIO(from, to);

    }

    @Test
    void shouldCountFiles() {

        assertNotNull(path);
        assertFalse(path.isEmpty());

        int actual = fileManager.countFiles(path);
        assertEquals(7, actual);

    }

    @Test
    void shouldCreateDirectoryCheckAndDelete() {

        try {
            File dir1 = new File("src/dir1");
            File dir1_1 = new File("src/dir1/dir1_1");
            File dir1_2 = new File("src/dir1/dir1_2");
            File dir2 = new File("src/dir2");
            File dir3 = new File("src/dir3");

            File file0 = new File("src/file0.txt");
            File file1 = new File("src/dir1/file1.txt");
            File file1_1 = new File("src/dir1/dir1_1/file1_1.txt");
            File file1_2 = new File("src/dir1/dir1_2/file1_2.txt");
            File file2 = new File("src/dir2/file2.txt");

            if (dir1.exists()){
                System.out.println("directory " + dir1 + " already exists");
            }else{
                dir1.mkdirs();
                System.out.println("directory " + dir1 + " created");
            }

            if (dir1_1.exists()){
                System.out.println("directory " + dir1_1 + " already exists");
            }else {
                dir1_1.mkdirs();
                System.out.println("directory " + dir1_1 + " created");
            }

            if (dir1_2.exists()){
                System.out.println("directory " + dir1_2 + " already exists");
            }else {
                dir1_2.mkdirs();
                System.out.println("directory " + dir1_2 + " created");
            }

            if (dir2.exists()){
                System.out.println("directory " + dir2 + " already exists");
            }else{
                dir2.mkdirs();
                System.out.println("directory " + dir2 + " created");
            }
            if (dir3.exists()){
                System.out.println("directory " + dir3 + " already exists");
            }else{
                dir3.mkdirs();
                System.out.println("directory " + dir3 + " created");
            }

            if (file0.exists()){
                System.out.println("file " + file0 + " created");
            }else{
                file0.createNewFile();
                System.out.println("file " + file0 + " already exists");
            }

            if (file1.exists()){
                System.out.println("file " + file1 + " created");
            }else{
                file1.createNewFile();
                System.out.println("file " + file1 + " already exists");
            }

            if (file1_1.exists()){
                System.out.println("file " + file1_1 + " created");
            }else{
                file1_1.createNewFile();
                System.out.println("file " + file1_1 + " already exists");
            }

            if (file1_2.exists()){
                System.out.println("file " + file1_2 + " created");
            }else{
                file1_2.createNewFile();
                System.out.println("file " + file1_2 + " already exists");
            }
            if (file2.exists()){
                System.out.println("file " + file2 + " created");
            }else{
                file2.createNewFile();
                System.out.println("file " + file2 + " already exists");
            }


            if (file0.delete()){
                System.out.println("file " + file0 + " deleted");
            }else{
                file0.deleteOnExit();
                System.out.println("file " + file0 + " not deleted");
            }
        }
        catch (IOException e) {
            throw new RuntimeException("can't create directory", e);
        }
    }
}


