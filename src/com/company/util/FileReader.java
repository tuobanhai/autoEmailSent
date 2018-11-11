package com.company.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// read delay time from part-r-00000 file
public class FileReader {
    public static double read(String path) throws FileNotFoundException {
        File file =
                new File(path);
        Scanner sc = new Scanner(file);

        String line = "";
        while (sc.hasNextLine()){
            line = sc.nextLine();
        }
        String[] words = line.split("\t");
        return Double.parseDouble(words[words.length - 1]);
    }
}
