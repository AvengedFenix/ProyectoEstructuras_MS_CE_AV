/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author calvinespinoza
 */
public class Huffman {
    
    public static Map<Character,Integer> getCharFreq(String s) {
        Map<Character,Integer> charFreq = new HashMap<Character,Integer>();
            if (s != null) {
                for (Character c : s.toCharArray()) {
                    Integer count = charFreq.get(c);
                    int newCount = (count==null ? 1 : count+1);
                    charFreq.put(c, newCount);
                }
            }
        return charFreq;
    }
    
    public static void main(String[] args) {
        System.out.println("Insert string: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s);
        ArrayList letters = new ArrayList();
        ArrayList freq = new ArrayList();
        
    }
    
}
