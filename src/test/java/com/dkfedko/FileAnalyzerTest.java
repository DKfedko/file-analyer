package com.dkfedko;

import com.dkfedko.fileanaluzer.FileAnalyzer;
import com.dkfedko.fileanaluzer.FileInformationAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileAnalyzerTest {
    FileAnalyzer fileAnalyzer = new FileAnalyzer();
    String path = "src/test/resources/story.txt";
    String wrongPath = "src/test/resources/Duck-story.txt";

    @Test
    void shouldReadContent() {
        //arrange
        String dataFile = fileAnalyzer.readContent(path);

        //assert
        assertNotNull(path);
        assertFalse(path.isEmpty());

        assertNotNull(dataFile);
        assertFalse(dataFile.isEmpty());
        assertFalse(path.isEmpty());

    }

    @Test
    void shouldThrowFileNotFindException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            fileAnalyzer.readContent(wrongPath);
        });
        String expected = "can't find file: ";
        String actual = exception.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    void shouldSplitIntoSentences() {
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
    void shouldFilterWords() {
        //arrange
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
    void shouldCountWords() {
        //assert
        String dataFile = fileAnalyzer.readContent(path);
        List<String> sentences = fileAnalyzer.splitIntoSentences(dataFile);
        List<String> word = fileAnalyzer.filterForWords(sentences);

        String searchedWord = "duck";
        int expected = fileAnalyzer.wordCount(word, searchedWord);
        int actual = 4;

        assertEquals(actual, expected);

        assertTrue(expected > 0);
        assertNotEquals(7, expected);

    }

    @Test
    void shouldShowFileAnalyzerInformation() {
        // when
        FileInformationAnalyzer lookForDuck = fileAnalyzer.fileInformationAnalyzer(path, "duck");

        lookForDuck.toString();
        System.out.println(lookForDuck);

        // then
        assertNotNull(lookForDuck, "Analyzer result should not be null");
        assertEquals("duck", lookForDuck.getWord(), "Word should match the searched one");
        assertEquals(4, lookForDuck.getCount(), "Count should be 1 for word 'duck'");

        List<String> sentences = lookForDuck.getSentencesList();
        assertNotNull(sentences, "Sentences list should not be null");
        assertFalse(sentences.isEmpty(), "Sentences list should not be empty");

        assertTrue(sentences.contains("duck"), "Sentences list should contain the word 'duck'");
    }
}
