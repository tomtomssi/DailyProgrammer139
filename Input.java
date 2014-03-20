/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyprogrammer139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Tatu
 */
public class Input {

    private int KEYPAD_LENGTH = 3;
    private final static int KEYPAD_HEIGHT = 9;
    private String[] _Input;

    public Input() {
        printHelp();
        getUserInput();
    }

    protected String[] getInput() {
        return _Input;
    }

    public void setInput(String[] input) {
        this._Input = input;
    }

    //Split input by whitespace
    private void getUserInput() {
        try {
            String[] arr = new BufferedReader(
                    new InputStreamReader(System.in)).readLine().split("\\s+");
            setInput(arr);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private void printHelp() {
        System.out.println("Enter input separated by a space");
        int ASCII = 65;
        for (int i = 1; i <= KEYPAD_HEIGHT; ++i) {
            System.out.print(i + ": ");
            for (int j = 0; j < KEYPAD_LENGTH; ++j) {
                if (i == 1) {
                    continue;
                }
                if (i == 7 || i == 9) {
                    KEYPAD_LENGTH = 4;
                }
                if (i == 8) {
                    KEYPAD_LENGTH = 3;
                }
                System.out.print(Character.toString((char) ASCII));
                ++ASCII;
            }
            System.out.println();
        }
    }
}
