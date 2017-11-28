/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8b;

/**
 *
 * @author Georgi
 */
public class CipherGenerator {
    
    private boolean isUnique(char[] chars, char searchedChar) {
        int occurences = 0;
        for (char current : chars) {
            if (current == searchedChar) {
                occurences++;
            }
        }
        return occurences == 1;
    }

    private int countUniqueOccurences(char[] chars) {
        int count = 0;
        
        for (char aChar : chars) {
            if (isUnique(chars, aChar)) {
                count++;
            }
        }
        
        return count;
    }
    
    public Result countDistinct(Cipherable cipher, int seed) {
        char[] chars = cipher.getSecretChars(seed);
        int uniqueCount = countUniqueOccurences(chars);
        return new Result(chars, uniqueCount);
    }

}
