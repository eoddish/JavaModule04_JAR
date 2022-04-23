package edu.school21.printer.logic;

import java.util.*;

import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;
//import org.junit.jupiter.api.Disabled;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
//import static com.diogonunes.jcolor.tests.unit.DataGenerator.randomInt;

public class Converter {

    private byte[] byteArray;
    private int width;
    private int height;
    private char whiteChar;
    private char blackChar;

    public Converter(byte[] byteArray, char whiteChar, char blackChar) {
        this.byteArray = byteArray;
        this.whiteChar = whiteChar;
        this.blackChar = blackChar;
        this.width = ((byteArray[21]&255) << 24) + ((byteArray[20]&255) << 16) + ((byteArray[19]&255) << 8) + (byteArray[18]&255);
        this.height = ((byteArray[25]&255) << 24) + ((byteArray[24]&255) << 16) + ((byteArray[23]&255) << 8) + (byteArray[22]&255);

    }

    public void convert() {

        int j = 0;
        String [] printArray = new String[height + 2];
        int k = 0;
        printArray[k] = "";
        for ( int i = 54; i < byteArray.length; i++) {

            //System.out.print((byteArray[i]&128) + " " + (byteArray[i]&64) + " " + (byteArray[i]&32) + " " + (byteArray[i]&16) + " " + (byteArray[i]&8) + " " + (byteArray[i]&4) + " " + (byteArray[i]&2) + " " + (byteArray[i]&1));


                if ((byteArray[i]&128) == 0x0)
                    printArray[k] += whiteChar;
                else
                    printArray[k] += blackChar;

                if ((byteArray[i]&64) == 0x0)
                    printArray[k] += whiteChar;
                else
                    printArray[k] += blackChar;

                if ((byteArray[i]&32) == 0x0)
                    printArray[k] += whiteChar;
                else
                    printArray[k] += blackChar;

                if ((byteArray[i]&16) == 0x0)
                    printArray[k] += whiteChar;
                else
                    printArray[k] += blackChar;

                if ((byteArray[i]&8) == 0x0)
                    printArray[k] += whiteChar;
                else
                    printArray[k] += blackChar;

                if ((byteArray[i]&4) == 0x0)
                    printArray[k] += whiteChar;
                else
                    printArray[k] += blackChar;

                if ((byteArray[i]&2) == 0x0)
                    printArray[k] += whiteChar;
                else
                    printArray[k] += blackChar;

                if ((byteArray[i]&1) == 0x0)
                    printArray[k] += whiteChar;
                else
                    printArray[k] += blackChar;

            j++;
            if(j == 2)
            {
                k++;
                if (k < printArray.length)
                    printArray[k] = "";
                j = 0;
                i += 2;
            }
        }

        for(int i = printArray.length - 1; i > 1; i--) {
            for (int m = 0; m < printArray[i].length(); m++) {
            if (printArray[i].charAt(m) == blackChar)
                System.out.print(colorize(printArray[i], CYAN_TEXT()));
            else if (printArray[i].charAt(m) == whiteChar)
                System.out.print(colorize(printArray[i], YELLOW_TEXT()));
            }
            System.out.println();
        }
    }

}