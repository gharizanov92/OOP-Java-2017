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
public class CipherTest {
    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper(10);
        Cipherable cipherable = wrapper.createFixedSelection();
        
        System.out.println(Arrays.toString(cipherable.getSecretChars(30)));
        
        CipherGenerator generator = new CipherGenerator();
        Result result = generator.countDistinct(cipherable, 30);
        System.out.println(result);
    }
}
