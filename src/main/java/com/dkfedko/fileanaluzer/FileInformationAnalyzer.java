package com.dkfedko.fileanaluzer;


import java.util.List;

//DTO or POJO
public class FileInformationAnalyzer {
    private String word;
    private int count;
    private List<String> sentencesList;

    public FileInformationAnalyzer(String word, int count, List<String> sentencesList) {
        this.word = word;
        this.count = count;
        this.sentencesList = sentencesList;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public List<String> getSentencesList() {
        return sentencesList;
    }

    @Override
    public String toString() {
        return "FileInformationAnalyzer{" +
                "word='" + word + '\'' +
                ", count=" + count +
                ", sentencesList=" + sentencesList +
                '}';
    }
}
