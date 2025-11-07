package com.dkfedko;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class FileManagerTest {
    String path = "src/test/resources/";
    FileManager fileManager = new FileManager();

    @Test
    void shouldCountFolders() {

        assertNotNull(path);
        assertFalse(path.isEmpty());

        int actual = fileManager.countFolders(path);
        assertEquals(4, actual);
    }

    @Test
    void shouldCopyFile() {

        String from = "src/test/resources/dir1Tets/tetsFile.txt";
        String to = "src/test/resources/dir3Tets/testFile.txt";

            fileManager.copy(from, to);

            File copiedFile = new File(to);
            assertTrue(copiedFile.exists());
    }

    @Test
    void shouldMoveFiles() {

        String from = "src/test/resources/dir3Tets/testFile.txt";
        String to = "src/test/resources/dir2Tets/testFile.txt";
        try {
            fileManager.move(from, to);
            File movedFile = new File(to);
            assertTrue(movedFile.exists());
        } finally {
            new File(to).delete();
        }
    }

    @Test
    void shouldCopyFileUsingIO() {

        String from = "src/test/resources/dir1Tets/tetsFile.txt";
        String to = "src/test/resources/dir2Tets/testFile.txt";
        try {
            fileManager.copyByIO(from, to);

            File copiedFile = new File(to);
            assertTrue(copiedFile.exists());
        } finally {
            new File(to).delete();
        }
    }

    @Test
    void shouldCountFiles() {

        assertNotNull(path);
        assertFalse(path.isEmpty());

        int actual = fileManager.countFiles(path);
        assertEquals(3, actual);
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

            assertTrue(dir1.exists() || dir1.mkdirs());
            assertTrue(dir1_1.exists() || dir1_1.mkdirs());
            assertTrue(dir1_2.exists() || dir1_2.mkdirs());
            assertTrue(dir2.exists() || dir2.mkdirs());
            assertTrue(dir3.exists() || dir3.mkdirs());

            assertTrue(file0.exists() || file0.createNewFile());
            assertTrue(file1.exists() || file1.createNewFile());
            assertTrue(file1_1.exists() || file1_1.createNewFile());
            assertTrue(file1_2.exists() || file1_2.createNewFile());
            assertTrue(file2.exists() || file2.createNewFile());

            assertTrue(dir1.isDirectory());
            assertTrue(dir1_1.isDirectory());
            assertTrue(dir1_2.isDirectory());
            assertTrue(dir2.isDirectory());
            assertTrue(dir3.isDirectory());

            assertTrue(file0.isFile());
            assertTrue(file1.isFile());
            assertTrue(file1_1.isFile());
            assertTrue(file1_2.isFile());
            assertTrue(file2.isFile());

            file0.delete();
            file1.delete();
            file1_1.delete();
            file1_2.delete();
            file2.delete();

            dir3.delete();
            dir2.delete();
            dir1_2.delete();
            dir1_1.delete();
            dir1.delete();

            assertFalse(dir1.exists());
            assertFalse(dir1_1.exists());
            assertFalse(dir1_2.exists());
            assertFalse(dir2.exists());
            assertFalse(dir3.exists());

            assertFalse(file0.exists());
            assertFalse(file1.exists());
            assertFalse(file1_1.exists());
            assertFalse(file1_2.exists());
            assertFalse(file2.exists());

        }
        catch (IOException e) {
            throw new RuntimeException("can't create directory", e);
        }
    }
}


