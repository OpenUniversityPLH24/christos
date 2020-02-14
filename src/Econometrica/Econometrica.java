/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Econometrica;

/**
 *1
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */

import GuiDesign.MainForm;
import java.io.IOException;
import javax.swing.JFrame;
import okhttp3.*;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;

public class Econometrica {
    
    /**
     * @param args the command line arguments
     * @throws org.json.simple.parser.ParseException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException {

        //Εκκίνηση του Βασικού GUI - Δημιουργία νέου αντικειμένου τύπου MainForm
        MainForm mainform = new MainForm();
        //Ορατό στην οθόνη
        mainform.setVisible(true);
        //Ορισμός λειτουργίας του Close Button
        mainform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
               
        String url1 = "https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json?api_key=j79mQ_zEuVUqFV1DihJT";
        String url2 = "https://www.quandl.com/api/v3/datasets/BP/OIL_CONSUM_GRC.json?api_key=j79mQ_zEuVUqFV1DihJT";
        
        OkHttpClient client = new OkHttpClient();

        Request request1 = new Request.Builder().url(url1).build();
        Request request2 = new Request.Builder().url(url2).build();

        try (Response response1 = client.newCall(request1).execute()) {
            if(response1.isSuccessful() && response1.body() != null) {
                String responseString1 =  response1.body().string();
                //System.out.println(responseString1);
                ParseData parse1 = new ParseData();
                parse1.parseData(responseString1);
            }
        } catch (IOException e) {
        }
        
        try (Response response2 = client.newCall(request2).execute()) {
            if(response2.isSuccessful() && response2.body() != null) {
                String responseString2 =  response2.body().string();
                //System.out.println(responseString2);
                ParseData parse2 = new ParseData();
                parse2.parseData(responseString2);
            }
        } catch (IOException e) {
        }
    }
}