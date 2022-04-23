package edu.school21.printer.app;

import java.io.*;
import java.util.*;
import edu.school21.printer.logic.*;


public class Program {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: Wrong argumnents!");
            System.exit(-1);
        }
        char whiteChar = args[0].charAt(0);
        char blackChar = args[1].charAt(0);
        String imagePath = args[2];

        File file = new File(imagePath);
        byte[] byteArray = new byte[(int)file.length()];

        try {
            FileInputStream in = new FileInputStream(imagePath);
            in.read(byteArray);
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        Converter converter = new Converter(byteArray, whiteChar, blackChar);
        converter.convert();
    }
}