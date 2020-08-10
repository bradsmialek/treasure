package com.treasure.util;

import java.io.*;
import java.util.ArrayList;


public class FileManager {

    private static BufferedReader reader;

    //READS .txt FILES CONTAINING ISLANDS
    public static ArrayList<String> readIslandFile(String filename) {

        System.out.println("COMPONENT MANAGER CLASS: READING "+filename);
        ArrayList<String> strings = new ArrayList<String>();
        File file = new File(filename).getAbsoluteFile();
        System.out.println(file);
        try{
            reader = new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException e) {
            System.out.println("File MANAGER CLASS: [ERROR]: "+file+" not found!");
        }
        try {
            String str = reader.readLine();
            strings.add(str);

            while(str!=null) {
                str = reader.readLine();
//                System.out.println(str);
                strings.add(str);
            }
        }catch (IOException e) {
            System.out.println("COMPONENTS MANAGER CLASS [ERROR]: IOException");
        }
        return strings;
    }
}
