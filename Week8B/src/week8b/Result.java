/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8b;

import java.util.Arrays;

/**
 *
 * @author Georgi
 */
public class Result {
    private char[] chars;
    private int data;

    public Result(char[] chars, int data) {
        this.data = data;
        this.chars = chars;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    @Override
    public String toString() {
        return "Chars " + Arrays.toString(chars) + "\nResult " + data;
    }
}
