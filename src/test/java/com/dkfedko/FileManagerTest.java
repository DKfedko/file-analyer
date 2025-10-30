package com.dkfedko;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FileManagerTest {
    String path  =  "src/test/resources/fileTest";
    FileManager fileManager = new FileManager();

    @Test
    void shouldCountFiles() {

        assertNotNull(path);
        assertFalse(path.isEmpty());

        int actual = fileManager.countFiles(path);
        assertEquals(3, actual);

    }

    @Test
    void shouldCountFolders()  {

        assertNotNull(path);
        assertFalse(path.isEmpty());

        int actual = fileManager.countFolders(path);
        assertEquals(6, actual);

    }

    @Test
    void shouldMoveFiles(){


//    }
//    }
//    @Test
//    void shouldMoveFiles(){
//
//
    }
//
}
