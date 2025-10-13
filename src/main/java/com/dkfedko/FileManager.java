package com.dkfedko;

import java.io.File;

public class FileManager {

    public static int countFiles(String path) {
        String pathToFile = new String(path) ;
        File file = new File(pathToFile);
        int totalFilesCount = 0;

        File[] files = file.listFiles();
        assert files != null;
        for (File f : files)
            totalFilesCount++;
        return totalFilesCount;
    }


    public static int countDirs(String path){

        return 0;
    }
    public static void copy(String from, String to){


    }

}
