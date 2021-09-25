/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivoscsv;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author DAM 2
 */
class ArchivoTexto {

    public static void Separar(String ruta) {
        Financial financial = null;

        String registro;
        String[] campo;
        File f;
        FileReader fr;
        BufferedReader br;
        ArrayList<Financial> ArrayListAmerica = new ArrayList<>();
        ArrayList<Financial> ArrayListFrance = new ArrayList<>();
        ArrayList<Financial> ArrayListGermany = new ArrayList<>();
        ArrayList<Financial> ArrayListCanada = new ArrayList<>();
        ArrayList<Financial> ArrayListMexico = new ArrayList<>();

        try {
            f = new File(ruta);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            int contador = 0;

            while ((registro = br.readLine()) != null) {
                campo = registro.split(",");
                if (campo.length == 16) {
                    financial = new Financial(
                            campo[0],
                            campo[1],
                            campo[2],
                            campo[3],
                            campo[4],
                            campo[5],
                            campo[6],
                            campo[7],
                            campo[8],
                            campo[9],
                            campo[10],
                            campo[11],
                            campo[12],
                            campo[13],
                            campo[14],
                            campo[15]);
                }
                

                if (null != campo[1]) {
                    
                    switch (campo[1]) {
                        case "United States of America":
                            ArrayListAmerica.add(financial);
                            break;
                        case "France":
                            ArrayListFrance.add(financial);
                            break;
                        case "Germany":
                            ArrayListGermany.add(financial);
                            break;
                        case "Canada":
                            ArrayListCanada.add(financial);
                            break;
                        case "Mexico":
                            ArrayListMexico.add(financial);
                            break;
                    }
                }
            }

            
            ArrayList array;
            array = escribir(ArrayListAmerica, "datos/Financial_America.csv");
            MostrarHTML(array, "America");
            array = escribir(ArrayListFrance, "datos/Financial_France.csv");
            MostrarHTML(array, "France");
            array = escribir(ArrayListGermany, "datos/Financial_Germany.csv");
            MostrarHTML(array, "Germany");
            array = escribir(ArrayListCanada, "datos/Financial_Canada.csv");
            MostrarHTML(array, "Canada");
            array = escribir(ArrayListMexico, "datos/Financial_Mexico.csv");
            MostrarHTML(array, "Mexico");

        } catch (IOException e) {
            System.out.println("El archivo no existe");
        }

    }

    private static ArrayList escribir(ArrayList array, String rute) {

        try {
            FileWriter fw = new FileWriter(rute);
            BufferedWriter bw = new BufferedWriter(fw);

            Financial a = null;
            for (int i = 0; i < array.size(); i++) {
                a = (Financial) array.get(i);
                bw.write(a.getSegment() + "," + a.getCountry() + "," + a.getProduct() + "," + a.getDiscount_Band() + "," + a.getUnits_sold() + "," + a.getManufacturing_Price() + "," + a.getSale_Price() + ","
                        + a.getGross_Sales() + "," + a.getDisconunts() + "," + a.getSales() + "," + a.getCOGS() + "," + a.getProfit() + "," + a.getDate() + "," + a.getMonthNumber() + "," + a.getMonthName());
                bw.newLine();
            }
            
            
            fw.flush();
            bw.flush();
            fw.close();
            bw.close();

        } catch (IOException e) {
            System.out.println("El archivo no existe");
        }

        return array;
    }

    static void MostrarHTML(ArrayList array, String name) {
        String salida = "datos/"+name+".html"; 
        FileWriter fw = null;  //OBJETO DE SALIDA
        BufferedWriter bw = null;  //FLUJO DE SALIDA
        PrintWriter pw = null;  //ENVIA LA INFORMACION

        Financial a = null; 

        try {
            //CREAR FLUJO
            bw = new BufferedWriter(new FileWriter(salida));

            //ESCRIBIR
            pw = new PrintWriter(bw);
            pw.println("<html>");
            pw.println("<head><title>"+name+"</title></head>");
            pw.println("<style>\n"
                    + "table, th, td {\n"
                    + "    border: 1px solid black;\n"
                    + "    border-collapse: collapse;\n"
                    + "}\n"
                    + "th, td {\n"
                    + "    padding: 5px;\n"
                    + "    text-align: left;    \n"
                    + "}\n"
                    + "</style>");
            pw.println("<body>");
            pw.println("<center><h1>"+name+"</h1></center>");
            pw.println("<table>");
            pw.println("<table style=\"width:50%\">\n"
                    + "  <tr>\n"
                    + "    <th>Segment</th>\n"
                    + "    <th>Country</th>\n"
                    + "    <th>Product</th>\n"
                    + "    <th>Units sold</th>\n"
                    + "    <th>Mnufacturing Price</th>\n"
                    + "    <th>Sale Price</th>\n"
                    + "    <th>Gross sales</th>\n"
                    + "    <th>Discounts</th>\n"
                    + "    <th>Sales</th>\n"
                    + "    <th>COGS</th>\n"
                    + "    <th>Profit</th>\n"
                    + "    <th>Date</th>\n"
                    + "    <th>Month Number</th>\n"
                    + "    <th>Month Name</th>\n"
                    + "    <th>Year</th>\n"
                    + "  </tr>\n");
            for (int i = 0; i < array.size(); i++) {
                a = (Financial) array.get(i);
                    pw.println("  <tr>\n");
                    pw.println("<td>" + a.getSegment() + "</td>\n");
                    pw.println("<td>" + a.getCountry() + "</td>\n");
                    pw.println("<td>" + a.getProduct() + "</td>\n");
                    pw.println("<td>" + a.getUnits_sold() + "</td>\n");
                    pw.println("<td>" + a.getManufacturing_Price() + "</td>\n");
                    pw.println("<td>" + a.getSale_Price() + "</td>\n");
                    pw.println("<td>" + a.getGross_Sales() + "</td>\n");
                    pw.println("<td>" + a.getDisconunts() + "</td>\n");
                    pw.println("<td>" + a.getSales() + "</td>\n");
                    pw.println("<td>" + a.getCOGS() + "</td>\n");
                    pw.println("<td>" + a.getProfit() + "</td>\n");
                    pw.println("<td>" + a.getDate() + "</td>\n");
                    pw.println("<td>" + a.getMonthNumber() + "</td>\n");
                    pw.println("<td>" + a.getMonthName() + "</td>\n");
                    pw.println("<td>" + a.getYear() + "</td>\n");
                    pw.println("  </tr>\n");
            }

            pw.println("</table>");
            pw.println("</body>");
            pw.println("</html>");
        } catch (IOException w) {
            System.out.println("ERROR");
        } finally {
            try {
                if (null != bw) {
                    bw.close();
                    pw.close();
                    System.out.println("Archivo Cerrado");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static String transformarArchivo(String ruta) {
        File f = new File(ruta);
        String nuevaRuta = "datos/Financial_SampleN.csv";
        String linea;
        String[] cadenas = null;
        String er = "\"";
        String res = "^[0-9].*";
        String cas = "^-[0-9].*";
        String as = ".*\\$.*";
        String cadenas2;
        ArrayList<String> string = new <String>ArrayList();
        try {
            FileReader fr = new FileReader(f);
            FileWriter fw = new FileWriter(nuevaRuta);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            f = new File(ruta);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                cadenas = linea.split(er);
                for (int i = 0; i < cadenas.length; i++) {
                    //System.out.print(cadenas[i]);
                    if (cadenas[i].matches(as)) {
                        cadenas2 = cadenas[i].replaceAll("\\$", "");
                        //System.out.println(cadenas2);
                        cadenas[i] = cadenas2;
                    }
                    //System.out.print(cadenas[i]);
                    if (cadenas[i].matches(res)) {
                        cadenas2 = cadenas[i].replaceFirst(",", "");
                        cadenas[i] = cadenas2;
                    }
                    if (cadenas[i].matches(cas)) {
                        cadenas2 = cadenas[i].replaceFirst(",", "");
                        cadenas[i] = cadenas2;
                    }
                    //string.add(cadenas[i]);
                    bw.write(cadenas[i]);
                }
                //string.add("\n");
                bw.newLine();
            }
            bw.flush();
            

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
        }
        
        
        return nuevaRuta;
    }
}
