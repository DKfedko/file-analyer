package com.dkfedko;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class FileAnalyzer {

    public static void main(String[] args) {

        String filePath = "/home/dkfedko/Стільниця/story.txt";
        String searchedWord = "duck";
        int searchedWordCounts = 0;
        ArrayList<String> sentencesList = new ArrayList<>();

        File file = new File(filePath);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.endsWith(".") || line.endsWith("?") || line.endsWith("!")) {
                    sentencesList.add(line);
                    String[] words = line.split("[\\s.,!?]+");
                    for (String word : words) {
                        if (word.contains(searchedWord)) ;
                        searchedWordCounts++;
                        System.out.println(searchedWordCounts);
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

