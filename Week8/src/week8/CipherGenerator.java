/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8;

/**
 *
 * @author gharizanov
 */
public class CipherGenerator {
    
    private boolean isUnique(char[] generated, char current) {
        int occurences = 0;
        for (char c : generated) {
            occurences += c == current ? 1 : 0;
        }
        return occurences == 1;
    }
    
    public Result countDistinct(Cipherable cipher, int seed) {
        char[] generated = cipher.getSecretChars(seed);
        int distinct = 0;
        for (char c : generated) {
            if (isUnique(generated, c)) {
                distinct++;
            }
        }
        return new Result(generated, distinct);
    }
}
