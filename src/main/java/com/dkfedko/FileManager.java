package com.dkfedko;

import java.io.*;
import java.nio.file.*;

public class FileManager {

    public int countFiles(String path) {

        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("file is not exist");
        }
        if (!file.isDirectory()){
            throw new RuntimeException("this is not a file ");
        }

        int totalFilesCount = 0;

        File[] dataOfFiles = file.listFiles();
        if (file == null){
            return totalFilesCount;
        }
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

        if (!folder.exists()) {
            throw new RuntimeException("folder does not exist " + path);
        }
        if (!folder.isDirectory()){
            throw new RuntimeException("not a folder: " + path);
        }

        int totalFoldersCounts = 1;

        File[] folders = folder.listFiles();
        if (folders == null) {
            return totalFoldersCounts;
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
            Path source = Path.of(from);
            Path target = Path.of(to);

            Files.move(source, target);

        } catch(NoSuchFileException e){
            throw new RuntimeException("Can't find file: " + from);
        } catch(AccessDeniedException e){
            throw new RuntimeException("Access to file is denied: " + from);
        } catch(IOException e){
            throw new RuntimeException("can't copy: " + e.getMessage());
        }
    }

    public void copy (String from, String to) {

        try {
            Path pathFrom = Path.of(from);
            Path pathTo = Path.of(to);

                Files.copy(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);

            } catch(NoSuchFileException e){
                throw new RuntimeException("Can't find file: " + from);
            } catch(AccessDeniedException e){
                throw new RuntimeException("Access to file is denied: " + from);
            } catch(IOException e){
                throw new RuntimeException("can't copy: " + e.getMessage());
            }
        }

    public void copyByIO (String from, String to) {
        try (FileInputStream inputStream = new FileInputStream(from);
             FileOutputStream outputStream = new FileOutputStream(to)) {
            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error copy file", e);
        }
    }
}

