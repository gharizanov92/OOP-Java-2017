/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8b;

import java.util.Random;

/**
 *
 * @author Georgi
 */
public class Wrapper {
    private int size;

    public Wrapper(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public Cipherable createFixedRandom() {
        return new FixedRandom();
    }

    public Cipherable createFixedSelection() {
        return new FixedSelection();
    }
    
    private class FixedRandom implements Cipherable {

        @Override
        public char[] getSecretChars(int seed) {
            char[] chars = new char[size];
            Random random = new Random(seed);
            int ordA = (int) 'A';
            int ordZ = (int) 'Z';
            int alphabetSize = ordZ - ordA;
            
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (ordA + random.nextInt(alphabetSize + 1));
            }
            return chars;
        }
    }
    
     private class FixedSelection implements Cipherable {

        @Override
        public char[] getSecretChars(int seed) {
            char[] chars = new char[size];
            Random random = new Random(seed);
            int ordA = (int) 'A';
            int ordZ = (int) 'Z';
            int alphabetSize = ordZ - ordA;
            
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (ordA + random.nextInt(seed % (alphabetSize + 1)));
            }
            return chars;
        }
        
    }
}
