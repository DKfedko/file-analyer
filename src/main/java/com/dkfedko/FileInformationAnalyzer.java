package com.dkfedko;

import java.util.ArrayList;
import java.util.List;

public class FileInformationAnalyzer {

    private String word;
    private int count;
    private List<String> sentencesList;
    
    FileInformationAnalyzer(String word){
        this.word = word;
        this.count = 0;
        this.sentencesList = new ArrayList<>();
    }

    public String getWord(){
        return word;
    }
    public int getWordCount(){
        return count;
    }
    public List<String> getSentences() {
        return sentencesList;
    }
}
