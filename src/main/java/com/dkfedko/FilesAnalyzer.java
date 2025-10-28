package com.dkfedko;

import java.io.FileNotFoundException;
import java.util.List;

public interface FilesAnalyzer {
    String readContent(String path) throws FileNotFoundException;

    List<String> splitIntoSentences(String content);

    List<String> filterForWords (List<String> content);

    int wordCount(List<String> text, String searchedWord);

    void fileInformationAnalyzer(String path, String  word);

}
