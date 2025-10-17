package com.dkfedko;
import java.io.*;
import java.util.ArrayList;

public class FileAnalyzer {
    public static void main(String[] agrs) {

        String filePath = "/home/dkfedko/Стільниця/story.txt";
        String searchedWord = "duck";
        int searchedWordCounts = 0;
        ArrayList<String> sentencesList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.endsWith(".") || line.endsWith("?") || line.endsWith("!")) {
                    sentencesList.add(line);
                    String[] words = line.split("[\\s.,!?]+");
                        for (String word : words) {
                            if (word.equalsIgnoreCase(searchedWord)) {
                                searchedWordCounts++;
                                System.out.println(searchedWordCounts);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("can't find file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

