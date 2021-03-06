/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author calvinespinoza
 */
public class Huffman {

    private static ArrayList<Character> letters = new ArrayList();
    private static ArrayList<Integer> freq = new ArrayList();
    private static File archivo = null;

    public Huffman() {

    }

    public static Map<Character, Integer> getFreq(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        int cont = 0;
        if (s != null) {
            for (Character c : s.toCharArray()) {
                Integer count = charFreq.get(c);
                int newCount = (count == null ? 1 : count + 1);
                charFreq.put(c, newCount);
            }
        }
        return charFreq;
    }

    public static void main(String[] args) {
        System.out.println("Insert string: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Map count = getFreq(str);
        for (Character ch : str.toCharArray()) {
            if (!letters.contains(ch)) {
                letters.add(ch);
                freq.add((int) count.get(ch));
                //freq2.add((int) count.get(ch));
            }
        }

        for (int i = 0; i < letters.size(); i++) {
            System.out.println(letters.get(i) + " " + freq.get(i));
        }

        Collections.sort(freq);
        ArrayList<BinTree> nodos = new ArrayList();

        for (int i = 0; i < freq.size(); i++) {
            nodos.add(new BinTree(Integer.toString(freq.get(i))));
        }

        BinTree node = new BinTree();
        while (nodos.size() > 1) {
            Collections.sort(nodos);
            System.out.println("\n");
            System.out.println("\n");
            BinTree nodo1 = nodos.get(0);
            BinTree nodo2 = nodos.get(1);
            int info = Integer.parseInt(nodo1.getInfo()) + Integer.parseInt(nodo2.getInfo());
            node = new BinTree(nodo1, nodo2, Integer.toString(info));

            nodos.remove(1);
            nodos.remove(0);
            nodos.add(node);

            node.preorden(node);
        }

        System.out.println("");
        String st = node.BinCode(node, "");
        String delim = ",";
        StringTokenizer tok = new StringTokenizer(st, delim, true);
        ArrayList binary = new ArrayList();
        int cont = 0;
        ArrayList<String> test = new ArrayList();
        ArrayList bin = new ArrayList();

        while (tok.hasMoreTokens()) {
            String token = tok.nextToken();

            if (tok.hasMoreTokens()) {
                tok.nextToken();
            }
            if (cont % 2 == 0) {
                for (int i = 0; i < freq.size(); i++) {
                    if (token.equals(Integer.toString(freq.get(i)))) {
                        binary.add(letters.get(i));
                        test.add(letters.get(i) + "");
                        freq.remove(i);
                        letters.remove(i);
                        break;
                    }
                }
            } else {
                test.add(token);
            }
            binary.add(token);
            cont++;
        }
        System.out.println(binary);
        System.out.println("TEST" + test);
        String texto = "";
        String compressed = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < test.size(); j++) {
                if (str.substring(i, i + 1).equals(test.get(j))) {
                    compressed += test.get(j + 1);
                }
            }
        }

        System.out.println(compressed);
        texto += compressed + ",";
        for (int i = 0; i < test.size(); i++) {
            texto += test.get(i) + ",";
        }
        save(texto, str);

        bin = cargar();
        System.out.println("TEST2" + bin);

        String text = bin.get(0).toString() + "0";
        bin.remove(0);
        BinTree raiz = new BinTree();

        BinTree root = node.BintoText(new BinTree(), new BinTree(), bin, 1, 0);
        System.out.println("out");
        root.preorden(root);
        String newString = "";
        String decompressed = root.DecomText(root, root, text, newString, 0);
        System.out.println("out");
        System.out.println(decompressed);
    }

    public void HuffCompress(String str) {
        Map count = getFreq(str);
        for (Character ch : str.toCharArray()) {
            if (!letters.contains(ch)) {
                letters.add(ch);
                freq.add((int) count.get(ch));
            }
        }
//
//        for (int i = 0; i < letters.size(); i++) {
//            System.out.println(letters.get(i) + " " + freq.get(i));
//        }

        Collections.sort(freq);
        ArrayList<BinTree> nodos = new ArrayList();

        for (int i = 0; i < freq.size(); i++) {
            nodos.add(new BinTree(Integer.toString(freq.get(i))));
        }

        BinTree node = new BinTree();
        while (nodos.size() > 1) {
            Collections.sort(nodos);
//            System.out.println("\n");
//            System.out.println("\n");
            BinTree nodo1 = nodos.get(0);
            BinTree nodo2 = nodos.get(1);
            int info = Integer.parseInt(nodo1.getInfo()) + Integer.parseInt(nodo2.getInfo());
            node = new BinTree(nodo1, nodo2, Integer.toString(info));

            nodos.remove(1);
            nodos.remove(0);
            nodos.add(node);

            node.preorden(node);
        }

        //System.out.println("");
        String st = node.BinCode(node, "");
        String delim = ",";
        StringTokenizer tok = new StringTokenizer(st, delim, true);
        ArrayList binary = new ArrayList();
        int cont = 0;
        ArrayList<String> test = new ArrayList();
        ArrayList bin = new ArrayList();

        while (tok.hasMoreTokens()) {
            String token = tok.nextToken();

            if (tok.hasMoreTokens()) {
                tok.nextToken();
            }
            if (cont % 2 == 0) {
                for (int i = 0; i < freq.size(); i++) {
                    if (token.equals(Integer.toString(freq.get(i)))) {
                        binary.add(letters.get(i));
                        test.add(letters.get(i) + "");
                        freq.remove(i);
                        letters.remove(i);
                        break;
                    }
                }
            } else {
                test.add(token);
            }
            binary.add(token);
            cont++;
        }
        //System.out.println(binary);
        System.out.println("TEST" + test);
        String texto = "";
        String compressed = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < test.size(); j++) {
                if (str.substring(i, i + 1).equals(test.get(j))) {
                    compressed += test.get(j + 1);
                }
            }
        }

        System.out.println(compressed);
        texto += compressed + ",";
        for (int i = 0; i < test.size(); i++) {
            texto += test.get(i) + ",";
        }
        save(texto, str);
    }

    public BinTree HuffDecompress(ArrayList bin) {
        //String text = bin.get(0).toString() + "0";
        bin.remove(0);
        BinTree raiz = new BinTree();

        BinTree root = raiz.BintoText(new BinTree(), new BinTree(), bin, 1, 0);
        System.out.println("out");
        root.preorden(root);
        String newString = "";
        //String decompressed = root.DecomText(root, root, text, newString, 0);
        //System.out.println(decompressed);
        return root;
    }

    public static void save(String texto, String str) {
        //String texto = "";
        archivo = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        String name = str.substring(0, 6);

        try {
            archivo = new File("./Archivos/" + name + ".txt");
            fw = new FileWriter(archivo, false);
            //si el archivo no existe lo crea y si ya existe los sobreescribe (al menos que append
            bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //primero se borra el buffer
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public static ArrayList cargar() {
        Scanner sc = null;
        ArrayList binary = new ArrayList();

        try {
            sc = new Scanner(archivo);
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                binary.add(sc.next());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sc.close();
        }
        return binary;
    }

    public static ArrayList read(String path) {
        Scanner sc = null;
        ArrayList binary = new ArrayList();
        File file = new File(path);

        try {
            sc = new Scanner(file);
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                binary.add(sc.next());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sc.close();
        }
        return binary;
    }
}
