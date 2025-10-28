package com.dkfedko;
import org.junit.jupiter.api.Test;

import java.security.spec.ECField;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileAnalyzerTest {
    FileAnalyzer fileAnalyzer = new FileAnalyzer();
    String path = "src/test/resources/story.txt";
    String wrongPath = "src/test/resources/Duck-story.txt";

    @Test
    void shouldReadContent() {
        //arrange
        String dataFile  = fileAnalyzer.readContent(path);

        //assert
        assertNotNull(path);
        assertFalse(path.isEmpty());

        assertNotNull(dataFile);
        assertFalse(dataFile.isEmpty());
        assertFalse(path.isEmpty());

    }

    @Test
    void shouldThrowFileNotFindException (){
        Exception exception = assertThrows(RuntimeException.class, () ->{
            fileAnalyzer.readContent(wrongPath);
        });
        String expected = "can't find file: ";
        String actual = exception.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    void shouldSplitIntoSentences(){
        //arrange
        String dataFile = fileAnalyzer.readContent(path);
        List<String> sentences = fileAnalyzer.splitIntoSentences(dataFile);

        //act
        String expected = "This is test sentences.";
        String notExpected = "This is test sentences!";

        //assert
        assertNotNull(path);
        assertNotNull(dataFile);
        assertFalse(dataFile.isEmpty());
        assertFalse(path.isEmpty());
        assertNotNull(sentences);
        assertFalse(sentences.isEmpty());

        assertTrue(sentences.contains(expected));
        assertFalse(sentences.contains(notExpected));

    }
    @Test
    void shouldFilterWords(){
        //assert
        String dataFile = fileAnalyzer.readContent(path);
        List<String> sentences = fileAnalyzer.splitIntoSentences(dataFile);
        List<String> word = fileAnalyzer.filterForWords(sentences);

        //act
        String expectedWords = "occasion";
        String wordNotExpected = "octopus";

        //assert
        assertNotNull(path);
        assertNotNull(dataFile);
        assertFalse(dataFile.isEmpty());
        assertFalse(path.isEmpty());

        assertTrue(word.contains(expectedWords));
        assertFalse(word.contains(wordNotExpected));

    }
    @Test
    void shouldCountWords(){
        //assert
        String dataFile = fileAnalyzer.readContent(path);
        List<String> sentences = fileAnalyzer.splitIntoSentences(dataFile);
        List<String> word = fileAnalyzer.filterForWords(sentences);

        String searchedWord = "duck";
        int expected = fileAnalyzer.wordCount(word, searchedWord);
        int actual = 4;

        assertEquals(actual, expected);

        assertTrue(expected>0);
        assertNotEquals(7, expected);

    }
    @Test
    void shouldShowFileAnalyzerInformation(){


    }

}
