/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.Collections;
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
        String str = sc.nextLine();
        
        Map count = getCharFreq(str);
        for (Character ch : str.toCharArray()) {
            if (!letters.contains(ch)) {
                letters.add(ch);
                freq.add((int)count.get(ch));
            }     
        }
        
        for (int i = 0; i < letters.size(); i++) {
            System.out.println(letters.get(i) + " " + freq.get(i));
        }
        
        Collections.sort(freq);
        
        ArrayList<Integer> freq2 = freq;
        /*for (int i = 0; i < freq.size(); i++) {
            System.out.println(freq.get(i));*/
            while (freq2.size() >= 2) {
                System.out.println("\n");
                for (int i = 0; i < freq2.size(); i++) {
                   System.out.print(freq2.get(i) + " ");
                }
                System.out.println("\n");
                
                int num1 = freq2.get(0);
                BinTree node1 = new BinTree(Integer.toString(num1)+ "+");
                int num2 = freq2.get(1);
                BinTree node2 = new BinTree(Integer.toString(num2) + "*");
                int num = freq2.get(0) + freq2.get(1);
                String info = Integer.toString(num);
                BinTree node = new BinTree(node1, node2, info);
                freq2.remove(1);
                freq2.remove(0);
                
                node.preorden(node);
            }
        //}
        
        
        
    }
}
