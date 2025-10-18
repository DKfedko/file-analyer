package com.dkfedko;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public static int countFiles(String path){
        File file = new File(path);
        int totalFilesCount = 0;

        try {
            File[] files = file.listFiles();
            if (files == null) {
                throw new FileNotFoundException("Can't find file" + path);
            }
            for (File f : files) {
                if (f.isFile()) {
                    totalFilesCount++;
                }else if (f.isDirectory()){
                    totalFilesCount+=countFiles(f.getAbsolutePath());
                }
            }
            return totalFilesCount;
        } catch (FileNotFoundException e) {
            System.out.println("can't find file" + path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static int countFolders(String path){
        File folder = new File(path);
        int totalFoldersCounts = 0;
        try {
            File[] Folders = folder.listFiles();
            if (Folders == null) {
                throw new FileNotFoundException("Can't find folder");
            }
            for (File f : Folders) {
                if (f.isDirectory()) {
                    totalFoldersCounts++;
                }else if (f.isDirectory()){
                    totalFoldersCounts+=countFolders(f.getAbsolutePath());
                }
            }
            return totalFoldersCounts;
        } catch (FileNotFoundException e) {
            System.out.println("can't find folder");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static void move(String from, String to) throws IOException {
        try {
            String pathFrom = from;
            String pathTo = to;
            Files.move(Path.of(pathFrom), Path.of(pathTo));
        } catch (FileNotFoundException e){
            System.out.println("can't find file");
        }
    }

    public static void copy(String from, String to) throws IOException {
        try {
        String pathFrom = from;
        String pathTo = to;
        Files.copy(Path.of(pathFrom), Path.of(pathTo));
        } catch (FileNotFoundException e){
            System.out.println("can't find file");
        }
    }

    public static void copyByIO(String from, String to) throws IOException {
        try {
            FileInputStream inputStream = new FileInputStream(from);
            FileOutputStream outputStream = new FileOutputStream(to);
            {
                int d;
                while ((d = inputStream.read()) != -1) {
                    outputStream.write(d);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("can't find file");
        }
    }
}

