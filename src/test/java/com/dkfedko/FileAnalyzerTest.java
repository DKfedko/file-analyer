package com.dkfedko;
import org.junit.jupiter.api.Test;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;

public class FileAnalyzerTest {
//    String path = Objects.requireNonNull(getClass().getClassLoader().getResource("fileTest")).getFile();
    String localPath  = "/home/dkfedko/Стільниця/story.txt";

    @Test
    void shouldReadContent() {
        FileAnalyzer fileAnalyzer = new FileAnalyzer();
        String dataFile  = fileAnalyzer.readContent(localPath);

        assertNotNull(localPath);
        assertNotNull(dataFile);
        assertFalse(dataFile.isEmpty());
        assertFalse(localPath.isEmpty());

    }
    @Test
    void shouldSplitIntoSentences(){
        FileAnalyzer fileAnalyzer = new FileAnalyzer();
        String dataFile = fileAnalyzer.readContent(localPath);
        String[] sentences = fileAnalyzer.splitIntoSentences(dataFile).toArray(new String[0]);


    }
}
