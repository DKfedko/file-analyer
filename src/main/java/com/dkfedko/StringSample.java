package com.dkfedko;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;


public class StringSample {
    public static void main(String[] args) {

        String testedString = "  This is tested string, checking Methods! Test, test.  ";
        String filePath = "/home/dkfedko/Стільниця/story.txt";

        System.out.println(testedString.trim().toLowerCase(Locale.ROOT));

        String[] elementsOfTestedString = testedString.split("[\\s.,!?]+");
        for (String elements : elementsOfTestedString) {
            System.out.println(elements);
        }

        System.out.println(testedString.endsWith(" "));
        System.out.println(testedString.endsWith("!"));
        System.out.println(Arrays.toString(testedString.getBytes(StandardCharsets.UTF_8)));
        System.out.println(testedString.trim().toUpperCase());
        System.out.println("is this string contains later 'a'?: " + testedString.contains("a"));
        System.out.println("is this string starts with space?: " + testedString.startsWith(" "));
        System.out.println("is this string starts with 'T'?: " + testedString.startsWith("T"));
        System.out.println(testedString.compareTo(filePath));


        int index = testedString.indexOf('!');
        int index1 = testedString.indexOf(' ', 3);
        int index2 = testedString.lastIndexOf('a');
        System.out.println("index count of ! is: " + index);
        System.out.println("index of the space starts from third: " + index1);
        System.out.println("do we have ch a uder any index? " + index2);


        System.out.println(testedString.codePointAt(5));
        System.out.println(testedString.length());
        System.out.println(testedString.isBlank());
        System.out.println(testedString.isEmpty());

        System.out.println(testedString.substring(10, 15));
    }
}
