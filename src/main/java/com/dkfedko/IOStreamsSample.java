package com.dkfedko;

import java.io.*;
import java.util.Arrays;

public class IOStreamsSample {
    public static void main(String[] args) throws IOException {

        String inputFilePath = "/home/dkfedko/Стільниця/input output steam folder/inputfolder/CV.txt";
        String outputFilePath = "/home/dkfedko/Стільниця/input output steam folder/outputfolder/Новий документ";
        try {
            FileInputStream inputStream = new FileInputStream(inputFilePath);
            FileOutputStream outputStream = new FileOutputStream(outputFilePath);
            {
                System.out.println("reading file =  " + inputStream.read() + " bytes");
                System.out.println("bytes available " + inputStream.available() + " for reading");

//                System.out.println(Arrays.toString(inputStream.readNBytes(100)));
                byte[] data = inputStream.readNBytes(85);
                String text = new String(data);
                System.out.println("this text reads 200 bytes: " + text);

                System.out.println(inputStream.skip(30));
                System.out.println(inputStream.markSupported());

                System.out.println(outputStream.equals(inputStream));
                System.out.println(outputStream.getFD());
                System.out.println(outputStream.hashCode());

                outputStream.write(data);
                System.out.println("wrote same byte length as inputStream.ReadNBytes, bytes: " + data.length);


            }
        } catch (FileNotFoundException e) {
            System.out.println("can't find file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}





