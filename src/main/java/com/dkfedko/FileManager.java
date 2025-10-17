package com.dkfedko;

import java.io.File;
import java.io.FileNotFoundException;

public class FileManager {


    public static int countFiles(String path) throws FileNotFoundException {
        File file = new File(path);
        int totalFilesCount = 0;

        File[] files = file.listFiles();
        if (files == null) {
            throw new FileNotFoundException();
        }
        for (File f : files)
            if (f.isFile()) {
                totalFilesCount++;
            }
        return totalFilesCount;
    }

    public static int countFolders(String path) throws FileNotFoundException {
        File folder = new File(path);
        int totalFoldersCounts = 0;

        File[] files = folder.listFiles();
        if (files == null) {
            throw new FileNotFoundException();
        }
        for (File f : files) {
            if (f.isDirectory()) {
                totalFoldersCounts++;
            }
        }
        return totalFoldersCounts;
    }

    public static void copy(String from, String to) {


    }

    public static void move(String from, String to) {
        File mover = new File(from, to);

        String path = "";
        from = path;
        to = new String(path);

    }
}
