package com.dkfedko;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FileManagerTest {
    String path  = getClass().getClassLoader().getResource("fileTest").getFile();
    String localPath   = "/home/dkfedko/Стільниця/fileTest";
    @Test
    void shouldCountFiles() {

        FileManager fileManager = new FileManager();

        assertNotNull(localPath);
        assertFalse(localPath.isEmpty());

        int actual = fileManager.countFiles(localPath);
        assertEquals(3, actual);

    }

    @Test
    void shouldCountFolders()  {

        FileManager fileManager = new FileManager();

        assertNotNull(localPath);
        assertFalse(localPath.isEmpty());

        int actual = fileManager.countFolders(localPath);
        assertEquals(6, actual);

    }

//    @Test
//    void shouldCopyFilesByIO(){

//        File from = new File(String from);
//        File to = new File(String to);
//        //assert

        //act


//
//    }
//    @Test
//    void shouldMoveFiles(){
//
//
//    }
//
}
