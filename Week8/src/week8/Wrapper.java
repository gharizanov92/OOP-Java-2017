/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8;

import java.util.Random;

/**
 *
 * @author gharizanov
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
    
    public Cipherable makeFixedRandom() {
        return new FixedRandom();
    }
    
    private class FixedRandom implements Cipherable {

        @Override
        public char[] getSecretChars(int seed) {
            final Random rand = new Random(seed);
            final char[] cipheredChars = new char[size];
            final int ordA = (int) 'A';
            final int ordZ = (int) 'Z';
            final int alphabetSize = ordZ - ordA;
            for (int i = 0; i < cipheredChars.length; i++) {
                cipheredChars[i] = (char) (rand.nextInt(alphabetSize) + ordA);
            }
            
            return cipheredChars;
        }
        
    }
    
    private class FixedSelection implements Cipherable {

        @Override
        public char[] getSecretChars(int seed) {
            final Random rand = new Random();
            final char[] cipheredChars = new char[rand.nextInt(seed) + 1];
            final int ordA = (int) 'A';
            final int ordZ = (int) 'Z';
            final int alphabetSize = ordZ - ordA;
            for (int i = 0; i < cipheredChars.length; i++) {
                cipheredChars[i] = (char) (rand.nextInt(alphabetSize) + ordA);
            }
            
            return cipheredChars;
        }
        
    }
}
