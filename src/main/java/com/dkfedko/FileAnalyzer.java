package com.dkfedko;
import java.io.*;

public class FileAnalyzer {

    public static void main(String[] args) throws IOException {

        String filePath = "/home/dkfedko/Стільниця/story.txt";
        String searchedWord = "duck";

        File file = new File(filePath);
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file.isDirectory());
        System.out.println();

        try {
            String line;
            int wordCount = 0;

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(searchedWord)){
                    System.out.println(searchedWord);
                }
                }
        } catch (FileNotFoundException exception) {
            System.out.println("can't find file");

        }
    }
}
