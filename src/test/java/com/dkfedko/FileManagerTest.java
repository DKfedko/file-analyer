package com.dkfedko;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {
    @Test
    void shouldCountFiles() {
        String path   = "home/dkfedko/Стільниця/fileTest";
        String Fullpath  = new String(path);
        FileManager fileManager = new FileManager();

        int actual = fileManager.countFiles(path);
        assertEquals(3, actual);

    }

//    @Test
//    void shouldCountFolders() throws FileNotFoundException {
//
//        int actual = FileManager.
//
//        assertEquals(4, actual);
//
//    }

    @Test
    void shouldCopyFilesByIO(){

//        File from = new File(String from);
//        File to = new File(String to);
//        //assert

        //act



    }
    @Test
    void shouldMoveFiles(){


    }

}
