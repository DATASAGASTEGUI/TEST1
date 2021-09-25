/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivoscsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;

/**
 *
 * @author DAM 2
 */
public class LeerArchivoCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList arrayListLectura;
        String ruta = "datos/Financial_Sample.csv";
        String route; 

        String nuevaRuta = ArchivoTexto.transformarArchivo(ruta);

        File f = new File(nuevaRuta);

        if (f.exists()) {
             ArchivoTexto.Separar(nuevaRuta); 
        } else {
            System.out.println("No existe");
        }
    }


}











