/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyprogrammer139;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Tatu
 */
public class Printer extends Input {

    String[] _Input;                        //2-9 Numpad
    private static final String file = "D:\\Programming\\Netbeans\\DailyProgrammer139\\src\\dailyprogrammer139\\text.txt";
    private static final String[] CHARS = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private String output = "";
    private static final int LINES_TO_PRINT = 6;

    public Printer() {
        this._Input = getInput();
        findWords();
    }

    private String parseData() {
        for (int i = 0; i < _Input.length; ++i) {
            //Get value from each space separated line
            int temp = Character.getNumericValue(_Input[i].charAt(0));
            int tempLength = _Input[i].length();
            //Point to the correct character based on the input
            output += CHARS[temp - 1].charAt(tempLength - 1);
        }
        return output;
    }

    private void findWords() {
        String input = parseData();
        BufferedReader br = null;
        try {
            String sLine;
            int count = 0;
            br = new BufferedReader(new FileReader(file));
            while ((sLine = br.readLine()) != null) {
                if (sLine.startsWith(input) && count < LINES_TO_PRINT) {
                    ++count;
                    //Print six items per line
                    if (count % 2 == 0) {
                        System.out.println();
                    }
                    System.out.print(sLine + " ");
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
