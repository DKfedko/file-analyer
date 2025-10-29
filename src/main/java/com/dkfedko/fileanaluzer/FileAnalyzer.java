package com.dkfedko.fileanaluzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileAnalyzer implements FilesAnalyzer {

    @Override
    public FileInformationAnalyzer fileInformationAnalyzer(String path, String word) {
        validationWord(word);
        validationPath(path);

        String content = readContent(path);
        List<String> sentences = splitIntoSentences(content);

        List<String> strings = filterForWords(sentences);
        int count = wordCount(strings, word);

        FileInformationAnalyzer info = new FileInformationAnalyzer(word, count, strings);
        return info;
    }

    @Override
    public String readContent(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Path = null");
        }
        try (FileInputStream input = new FileInputStream(path)) {
            byte[] data = input.readAllBytes();
            return new String(data, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("can't find file: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + path, e);
        }
    }

    @Override
    public List<String> splitIntoSentences(String data) {
        if (data == null || data.trim().isEmpty()) {
            throw new RuntimeException("content  = 0, nothing to split.");
        }

        String[] sentences = data.split("(?<=[.!?])\\s+");
        List<String> result = new ArrayList<>();
        for (String sentence : sentences) {
            result.add(sentence);
        }
        return result;
    }

    @Override
    public List<String> filterForWords(List<String> sentences) {
        if (sentences == null || sentences.isEmpty()) {
            throw new RuntimeException("content  = 0, no words found");
        }
        List<String> allWords = new ArrayList<>();
        for (String sentence : sentences) {
            String[] words = sentence.split("[\\s,.!?]+");
            for (String word : words) {
                allWords.add(word);
            }
        }
        return allWords;
    }

    @Override
    public int wordCount(List<String> text, String searchedWord) {
        int countWords = 0;
        for (String word : text) {
            if (word.equalsIgnoreCase(searchedWord)) {
                countWords++;
            }
        }
        return countWords;
    }


    private static void validationWord(String searchedWord) {
        if (searchedWord == null || searchedWord.isEmpty()) {
            throw new IllegalArgumentException("searched word is null or empty");
        }
    }

    private static void validationPath(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IllegalArgumentException("can't find file " + file);
        }
    }
}

