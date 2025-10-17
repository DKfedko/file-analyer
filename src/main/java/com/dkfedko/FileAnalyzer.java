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
        ArrayList<String> sentences = new ArrayList<>();

        File file = new File(filePath);
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file.isDirectory());
        System.out.println(file.isHidden());


//            try
//                    (FileReader fileReader = new FileReader(filePath)) {
//
//                StringBuilder sentencesBuilder = new StringBuilder();
//                int i;
//                while ((i = fileReader.read()) != -1) {
//                    if (sentences.endsWith(".") || sentences.endsWith("?") || sentences.endsWith("!")) {
//                        sentencesList.add(sentences);
//                        char symbol = (char) i;
//                        sentences.append(symbol);
//                        if (sentences.contains(searchedWord)) {
//                            String[] words = sentences.split("[\\s.,!?]+");
//                            for (String word : words) {
//                                if (word.equalsIgnoreCase(searchedWord)) {
//                                    searchedWordCounts++;
//                                }
//                            }
//                            System.out.println(searchedWordCounts);
//                        }
//                    }
//                }
//            }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.endsWith(".") || line.endsWith("?") || line.endsWith("!")) {
                    sentences.add(line);
                    String[] words = line.split("[\\s.,!?]+");
                    for (String word : words) {
                        if (word.contains(searchedWord)) ;
                        searchedWordCounts++;
//                        System.out.println(searchedWordCounts);
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

