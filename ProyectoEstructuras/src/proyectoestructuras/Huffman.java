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
    
    private static ArrayList<Character> letters = new ArrayList();
    private static ArrayList<Integer> freq = new ArrayList();
    
    public static Map<Character,Integer> getCharFreq(String s) {
        Map<Character,Integer> charFreq = new HashMap<Character,Integer>();
        int cont = 0;
            if (s != null) {
                for (Character c : s.toCharArray()) {
                    Integer count = charFreq.get(c);
                    int newCount = (count == null ? 1 : count+1);
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
        
        Map count = getCharFreq(s);
        for (Character ch : s.toCharArray()) {
            if (!letters.contains(ch)) {
                letters.add(ch);
                freq.add((int)count.get(ch));
            }     
        }
        
        for (int i = 0; i < letters.size(); i++) {
            System.out.println(letters.get(i) + " " + freq.get(i));
        }
    }
}
