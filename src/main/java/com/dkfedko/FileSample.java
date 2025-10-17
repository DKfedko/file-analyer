package com.dkfedko;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileSample {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/dkfedko/Стільниця/fileTest/story.txt";
        String filTestFolderPath = "/home/dkfedko/Стільниця/fileTest/folder-with-files";

        File file = new File(filePath);
        System.out.println("absolute path is " + file.getAbsoluteFile());
        System.out.println("file name is " + file.getName());

        System.out.println("is this file is directory? " + file.isDirectory());
        System.out.println("is this file is hidden? " + file.isHidden());
        System.out.println("is this fil exists? " + file.exists());
        System.out.println(file.getCanonicalFile());
        System.out.println("URI path" + file.toURI());

        File folderFiles = new File(filTestFolderPath);
        System.out.println(Arrays.toString(folderFiles.listFiles()));
        System.out.println(Arrays.toString(folderFiles.list()));
        System.out.println("is this file is directory? "  + folderFiles.isDirectory());
        System.out.println(folderFiles.getFreeSpace());

        long lastModified = folderFiles.lastModified();
        System.out.println(new java.util.Date(lastModified));

    }
}
