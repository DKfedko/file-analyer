package com.dkfedko;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class FileAnalyzerTest {
    String path = "/home/dkfedko/Стільниця/fileTest";

    @Test
    void shouldCountFiles() throws FileNotFoundException {;

        int actual = FileManager.countFiles(path);

        assertEquals(3, actual);

    }
    @Test
    void shouldCountFolders() throws FileNotFoundException {

        int actual = FileManager.countFolders(path);

        assertEquals(4, actual);

    }
    @Test
    void shouldCopyFiles(){


    }
    @Test
    void shouldMoveFiles(){



    }

}
