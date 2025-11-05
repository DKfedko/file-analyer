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
        assertEquals(6, actual);

    }

    @Test
    void shouldCountFolders() {

        assertNotNull(path);
        assertFalse(path.isEmpty());

        int actual = fileManager.countFolders(path);
        assertEquals(6, actual);

    }

//    @Test
//    void shouldMoveFiles() {
//
//        String from = "src/test/resources/fileTest/2";
//        String to = "fileTest/story/input_output_stream_folder";
//
//
//        fileManager.move(from, to);
//
//    }
//
//    @Test
//    void shouldCopyFile() {
//
//        String from = "src/test/resources/fileTest/input_output_stream_folder/input_folder/CV.txt";
//        String to = "src/test/resources/fileTest/input_output_stream_folder/outputfolder";
//
//        fileManager.copy(from, to);
//
//    }
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
}