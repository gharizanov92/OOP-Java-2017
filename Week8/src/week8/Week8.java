/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8;

import java.util.Arrays;

/**
 *
 * @author gharizanov
 */
public class Week8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper(20);
        Cipherable cipherable = wrapper.makeFixedRandom();
        System.out.println(Arrays.toString(cipherable.getSecretChars(1337)));
    }
    
}
