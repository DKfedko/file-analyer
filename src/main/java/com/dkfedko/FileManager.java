package com.dkfedko;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public int countFiles(String path) {

        File file = new File(path);
        int totalFilesCount = 0;
        if (!file.exists()) {
            throw new RuntimeException("file is not exist");
        }
        File[] dataOfFiles = file.listFiles();
        assert dataOfFiles != null;
        for (File currentFile : dataOfFiles) {
            if (currentFile.isFile()) {
                totalFilesCount++;
            } else if (currentFile.isDirectory()) {
                totalFilesCount += countFiles(currentFile.getAbsolutePath());
            }
        }
        return totalFilesCount;
    }

    public int countFolders(String path) {
        File folder = new File(path);
        int totalFoldersCounts = 0;
        if (!folder.exists()) {
            throw new RuntimeException("folder does not exist " + path);
        }
        totalFoldersCounts++;
        File[] folders = folder.listFiles();
        if (folders == null) {
            throw new RuntimeException("folder = null");
        }
        for (File listOfFolders : folders) {
            if (listOfFolders.isDirectory()) {
                totalFoldersCounts += countFolders(listOfFolders.getAbsolutePath());
            }
        }
        return totalFoldersCounts;
    }

    public void move (String from, String to) {
        try {
            String pathFrom = from;
            String pathTo = to;
            Files.move(Path.of(pathFrom), Path.of(pathTo));
        } catch (AccessDeniedException e) {
            System.out.println("access denied to " + from);
        } catch (FileNotFoundException e) {
            System.out.println("can't find file");
        } catch (IOException e) {
            throw new RuntimeException("can't read file");
        }
    }

    public void copy(String from, String to) {
        try {
            String pathFrom = from;
            String pathTo = to;
            Files.copy(Path.of(pathFrom), Path.of(pathTo));
        } catch (AccessDeniedException e) {
            System.out.println("access denied to " + from);
        } catch (FileNotFoundException e) {
            System.out.println("can't find file");
        } catch (IOException e) {
            throw new RuntimeException("can't read file");
        }
    }

    public void copyByIO(String from, String to) {
        try (FileInputStream inputStream = new FileInputStream(from);
             FileOutputStream outputStream = new FileOutputStream(to)) {
            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error copy file");
        }
    }
}

