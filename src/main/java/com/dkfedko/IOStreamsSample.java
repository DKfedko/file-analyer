package com.dkfedko;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamsSample {
    public static void main(String[] args) throws IOException {
        try {
            String folderPath = "/home/dkfedko/Стільниця/input output steam folder";
            String inputFilePath = "/home/dkfedko/Стільниця/input output steam folder/inputfolder/CV.txt";
            String outputFilePath = "/home/dkfedko/Стільниця/input output steam folder/outputfolder/Новий документ";

            FileInputStream inputStream = new FileInputStream(inputFilePath);
            FileOutputStream outputStream = new FileOutputStream(outputFilePath);
            {
                int d;
                while ((d = inputStream.read()) != -1) {
                    outputStream.write(d);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("can't find file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}





