package proyectoestructuras;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author calvinespinoza
 */

public class adminPerson {

    private ArrayList<Person> listaPersonas = new ArrayList();
    private File archivo = null;

    public adminPerson(String path) {
        archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<Person> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Person> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
<<<<<<< HEAD
    public ArrayList<Person> getLista(){
        return listaPersonas;
    }
=======
>>>>>>> 21360ead128d25fc33e1caefad1afd66088bc9d1

    @Override
    public String toString() {
        return "listaPersonas=" + listaPersonas;
    }

    //extra mutador
    public void setPerson(Person p){
        this.listaPersonas.add(p);
    }

    //metodos de administracion
    public void escribirArchivo() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        int cont;

        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Person t : listaPersonas) {
                bw.write(t.getName() + ";");
                bw.write(t.getEvaluation()+ ";");
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
            }
        }
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaPersonas = new ArrayList();

        try {
            sc = new Scanner(archivo);
            sc.useDelimiter(";");
            while (sc.hasNext()) {               
                listaPersonas.add(new Person(sc.next(), sc.nextInt()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sc.close();
        }
    }
/*
    public void cargarArchivo() {
        FileReader fr = null;
        BufferedReader br = null;
        listaPersonas = new ArrayList();

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String text = "";
            String linea = "";
            
            while((linea = br.readLine()) != null){
                text += linea;
            }
            System.out.println(text);
            
            StringTokenizer st = new StringTokenizer(text,";");
            
            while(st.hasMoreTokens()){
                String str = st.nextToken();
                if (str.contains("|")){
                    StringTokenizer st2 = new StringTokenizer(str,"|");
                    while (st2.hasMoreTokens()) {
                        listaPersonas.get(listaPersonas.size() - 1).addHobby(new Hobby(Integer.parseInt(st2.nextToken()), st2.nextToken()));
                    }
                } else {
                    listaPersonas.add(new Persona(Integer.parseInt(str), st.nextToken(), Integer.parseInt(st.nextToken())));
                }
            }
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }
*/
}    

