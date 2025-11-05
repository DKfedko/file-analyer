package com.dkfedko;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class FileManagerTest {
    String path = "src/test/resources";
    FileManager fileManager = new FileManager();

    @Test
    void shouldCountFiles() {

        assertNotNull(path);
        assertFalse(path.isEmpty());

        int actual = fileManager.countFiles(path);
        assertEquals(5, actual);

    }

    @Test
    void shouldCountFolders() {

        assertNotNull(path);
        assertFalse(path.isEmpty());

        int actual = fileManager.countFolders(path);
        assertEquals(6, actual);

    }

    @Test
    void shouldMoveFiles() {

        String from = "src/test/resources/test-dir1/test-dir1_2";
        String to = "src/test/resources/test-dir2";
        fileManager.move(from, to);

    }

    @Test
    void shouldCopyFile() {

        String from = "src/test/resources/test-dir1/testFile1.txt";
        String to = "src/test/resources/test-dir1/test-dir1_2/testFile1.txt";

        fileManager.copy(from, to);

    }
//
//    @Test
//    void shouldCopyFileUsingIO() {
//
//        String from = "src/test/resources/fileTest/input_output_stream_folder/input_folder/CV.txt";
//        String to = "src/test/resources/fileTest/input_output_stream_folder/outputfolder/CV.txt";
//
//        fileManager.copyByIO(from, to);
//
//    }
    @Test
    void shouldCreateDirectoryCheckAndDelete(){

        File file = new File("dir1");

        boolean create = file.mkdirs();
        if (!file.exists()){
            throw new RuntimeException("could not create directory ");
        }

    }

}