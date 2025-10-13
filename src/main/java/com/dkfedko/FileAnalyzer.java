package com.dkfedko;
import java.io.*;
import java.util.ArrayList;

public class FileAnalyzer<T> {

    public void main(String[] args) throws IOException {

        String filePath = "/home/dkfedko/Стільниця/story.txt";
        String searchedWord = "duck";

        File file = new File(filePath);
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file.isDirectory());
        System.out.println();

        try {
            char sentences;
            int searchedWordCounts = 0;
            ArrayList<T> sentencesList = new ArrayList<>();

//            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            try
                    (FileReader fileReader = new FileReader(filePath)) {
                while ((sentences = (char) fileReader.read())!= -1) {
                    String senctences;
                    if (senctences.endsWith(".") || sentences.endsWith("?") || sentences.endsWith("!")) {
                        sentencesList.add((T) sentences);
                        if (sentences.contains(searchedWord)) {
                            String[] words = sentences.split("[\\s.,!?]+");
                            for (String word : words) {
                                if (word.equals(searchedWord)) ;
                                searchedWordCounts++;
                                System.out.println(searchedWordCounts);
                            }
                        }
                    }
                }
            }

//            while ((line = bufferedReader.readLine()) != null) {
//                if (line.endsWith(".") || line.endsWith("?") || line.endsWith("!")) {
//                    sentencesList.add(line);
//                }
//            }
//            if (line.contains(searchedWord)) {
//                String[] words = line.split("[\\s.,!?]+");
//                for (String word : words) {
//                    if (word.equals(searchedWord)) ;
//                    searchedWordCounts++;
//                    System.out.println(searchedWordCounts);
//                }
//            }
        } catch (FileNotFoundException exception) {
            System.out.println("can't find file");

        }
    }
}
