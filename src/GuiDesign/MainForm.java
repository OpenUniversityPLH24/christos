package GuiDesign;

/**
 *
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */

import Econometrica.DataSet;
import Econometrica.JsonGdp;
import Econometrica.JsonOil;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import model.Country;
import model.CountryData;
import model.CountryDataset;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainForm extends javax.swing.JFrame {
 
    public MainForm() {
        initComponents();
        Countryfilldata();
        SavedCheckBox.setEnabled(false);
        Save_Button.setEnabled(false);
                
    }
    
    public void Countryfilldata(){
    String line;  
    String splitBy = ";"; 
    String csv = "iso-countries.csv"; 
        
    try   
        {  
        //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader(csv));
            br.readLine();
            while ((line = br.readLine()) != null){   //returns a Boolean value  
                String[] country = line.split(splitBy);    // use comma as separator  
                String[][] csvData = new String[250][4];
                int i = 0;
                csvData[i][0] = country[0];
                csvData[i][1] = country[1];
                csvData[i][2] = country[2];
                csvData[i][3] = country[3];
                CountrySelect.addItem(csvData[i][0]);
                i++;
                }  
            }
            catch (IOException e){  
        }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        SavedCheckBox = new javax.swing.JCheckBox();
        Delete_Button = new javax.swing.JButton();
        Save_Button = new javax.swing.JButton();
        Plot_Button = new javax.swing.JButton();
        Fetch_Button = new javax.swing.JButton();
        CountrySelect = new javax.swing.JComboBox<>();
        gpdcountry = new javax.swing.JLabel();
        oilcountry = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        OilDataTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        GPDDataTable = new javax.swing.JTable();
        OilStartDate = new javax.swing.JLabel();
        OilEndDate = new javax.swing.JLabel();
        GDPStartDate = new javax.swing.JLabel();
        GDPEndDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Econometrica");
        setLocation(new java.awt.Point(500, 250));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Select Country:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("OILDATA");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Dataset Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("GDPDATA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Dataset Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Available Timespan:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Available Timespan:");

        jLabel8.setText("Start Date:");

        jLabel9.setText("Start Date:");

        jLabel10.setText("End Date:");

        jLabel11.setText("End Date:");

        SavedCheckBox.setText("Already Saved to DataBase");
        SavedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavedCheckBoxActionPerformed(evt);
            }
        });

        Delete_Button.setText("Delete All");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });

        Save_Button.setText("Save");
        Save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_ButtonActionPerformed(evt);
            }
        });

        Plot_Button.setText("Plot");
        Plot_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plot_ButtonActionPerformed(evt);
            }
        });

        Fetch_Button.setText("Fetch Data");
        Fetch_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fetch_ButtonActionPerformed(evt);
            }
        });

        gpdcountry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        oilcountry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jScrollPane3.setHorizontalScrollBar(null);

        OilDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Values"
            }
        ));
        jScrollPane3.setViewportView(OilDataTable);

        GPDDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Values"
            }
        ));
        jScrollPane4.setViewportView(GPDDataTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CountrySelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(Fetch_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel11))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(OilStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(OilEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(oilcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(Save_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(68, 68, 68)
                                                        .addComponent(Plot_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(220, 220, 220)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(Delete_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SavedCheckBox))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(gpdcountry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(GDPEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(GDPStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(147, 147, 147)))))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CountrySelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fetch_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(oilcountry, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                    .addComponent(gpdcountry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                            .addComponent(OilStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OilEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel11))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                            .addComponent(GDPStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(GDPEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SavedCheckBox)
                    .addComponent(Delete_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Plot_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Save_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SavedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavedCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SavedCheckBoxActionPerformed

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        int verify = JOptionPane.showConfirmDialog(rootPane, "Είσαι βέβαιος για τη διαγραφή;");
        if(verify == JOptionPane.NO_OPTION)
            System.exit(0);
        if (verify == JOptionPane.YES_OPTION) {

            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EconometricaPU");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                em.createNamedQuery("CountryData.deleteAll").executeUpdate();
                em.createNamedQuery("CountryDataset.deleteAll").executeUpdate();
                em.createNamedQuery("Country.deleteAll").executeUpdate();
                em.createNativeQuery("ALTER TABLE Country ALTER COLUMN ID RESTART WITH 1");
                em.getTransaction().commit();
                em.close();
                emf.close();
                JOptionPane.showMessageDialog(null, "Τα δεδομένα διαγράφηκαν");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Τα δεδομένα δεν διαγράφηκαν");
            }

        }
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void Plot_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plot_ButtonActionPerformed
        String plotcountry = (String) CountrySelect.getSelectedItem();
        PlotPanel plot = new PlotPanel(plotcountry);
        plot.setVisible(true);
        plot.setDefaultCloseOperation(MainForm.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_Plot_ButtonActionPerformed

    private void Fetch_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fetch_ButtonActionPerformed
        //Δημιουργία του Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EconometricaPU");
        //Δημιουργία του EntityManager
        EntityManager em = emf.createEntityManager();
        
        DefaultTableModel GDPmodel = (DefaultTableModel) GPDDataTable.getModel();
        DefaultTableModel OILmodel = (DefaultTableModel) OilDataTable.getModel();
        gpdcountry.setText("");
        GDPStartDate.setText("");
        GDPEndDate.setText("");
        oilcountry.setText("");
        OilStartDate.setText("");
        OilEndDate.setText("");
        GDPmodel.setRowCount(0);
        OILmodel.setRowCount(0);
        if(SavedCheckBox.isSelected()==true){
            SavedCheckBox.setEnabled(true);
            SavedCheckBox.doClick();
            SavedCheckBox.setEnabled(false);
        }
        Save_Button.setEnabled(true);
        String selection = (String) CountrySelect.getSelectedItem();
        int i;
        Query fetchdata = em.createNamedQuery("Country.findByName",Country.class);
        fetchdata.setParameter("name", selection);
        List<Country> countries = fetchdata.getResultList();        
        if(!countries.isEmpty()){
            for(Country e : countries){
                int size = countries.get(0).getCountryDatasetList().size();
                if(size==1){
                    if(countries.get(0).getCountryDatasetList().get(0).getDescription().contains("GDP")){
                        gpdcountry.setText(e.getCountryDatasetList().get(0).getDescription());
                        GDPStartDate.setText(e.getCountryDatasetList().get(0).getStartYear());
                        GDPEndDate.setText(e.getCountryDatasetList().get(0).getEndYear());
                        int gdp=e.getCountryDatasetList().get(0).getCountryDataList().size();
                        for(i=0;i<gdp;i++){
                            String gdpyear = e.getCountryDatasetList().get(0).getCountryDataList().get(i).getDataYear();
                            String gdpvalue = e.getCountryDatasetList().get(0).getCountryDataList().get(i).getValue();
                            GDPmodel.addRow(new Object[]{gdpyear, gdpvalue});
                        }
                        if(i!=0){
                            SavedCheckBox.setEnabled(true);
                            SavedCheckBox.doClick();
                            SavedCheckBox.setEnabled(false);
                            Save_Button.setEnabled(false);
                        }
                    }
                }else if(size==2){
                    if(countries.get(0).getCountryDatasetList().get(0).getDescription().contains("GDP")){
                        gpdcountry.setText(e.getCountryDatasetList().get(0).getDescription());
                        GDPStartDate.setText(e.getCountryDatasetList().get(0).getStartYear());
                        GDPEndDate.setText(e.getCountryDatasetList().get(0).getEndYear());
                        int gdp=e.getCountryDatasetList().get(0).getCountryDataList().size();
                        for(i=0;i<gdp;i++){
                            String gdpyear = e.getCountryDatasetList().get(0).getCountryDataList().get(i).getDataYear();
                            String gdpvalue = e.getCountryDatasetList().get(0).getCountryDataList().get(i).getValue();
                            GDPmodel.addRow(new Object[]{gdpyear, gdpvalue});
                        }
                        if(i!=0){
                            SavedCheckBox.setEnabled(true);
                            SavedCheckBox.doClick();
                            SavedCheckBox.setEnabled(false);
                            Save_Button.setEnabled(false);
                        }
                    }
                if(countries.get(0).getCountryDatasetList().get(1).getDescription().contains("Oil")){
                    oilcountry.setText(e.getCountryDatasetList().get(1).getDescription());
                    OilStartDate.setText(e.getCountryDatasetList().get(1).getStartYear());
                    OilEndDate.setText(e.getCountryDatasetList().get(1).getEndYear());
                    int oil=e.getCountryDatasetList().get(1).getCountryDataList().size();
                    for(i=0;i<oil;i++){
                        String oilyear = e.getCountryDatasetList().get(1).getCountryDataList().get(i).getDataYear();
                        String oilvalue = e.getCountryDatasetList().get(1).getCountryDataList().get(i).getValue();
                        OILmodel.addRow(new Object[]{oilyear, oilvalue});
                    }
                    if(i!=0){
                        SavedCheckBox.setEnabled(true);
                        SavedCheckBox.doClick();
                        SavedCheckBox.setEnabled(false);
                        Save_Button.setEnabled(false);
                    }
                }
            }
        }
        }else{
            JOptionPane.showMessageDialog(null, "Τα δεδομένα δεν υπάρχουν αποθηκευμένα στη ΒΔ."+"\n"+"Θα γίνει λήψη από τον ιστότοπο quandl.com");
            String line;  
            String splitBy = ";"; 
            String csv = "iso-countries.csv";
            String code = null;
            try   
                {  
                //parsing a CSV file into BufferedReader class constructor  
                BufferedReader br = new BufferedReader(new FileReader(csv));
                br.readLine();
                while ((line = br.readLine())!= null){   //returns a Boolean value  
                    String[] country = line.split(splitBy);    // use comma as separator  
                    String[][] csvData = new String[250][4];
                    int a = 0;
                    csvData[a][0] = country[0];
                    csvData[a][1] = country[1];
                    csvData[a][2] = country[2];
                    csvData[a][3] = country[3];                   
                    if(csvData[a][0] == null ? selection == null : csvData[a][0].equals(selection)){
                        code = csvData[a][2];
                        break;
                     }
                     a++;
                }  
            }
            catch (IOException e){  
            }
            String str1 = "https://www.quandl.com/api/v3/datasets/WWDI/";
            String str2 = "https://www.quandl.com/api/v3/datasets/";
            String gdp_code = "_NY_GDP_MKTP_CN";
            String oil_code = "BP/OIL_CONSUM_";
            String apikey = ".json?api_key=j79mQ_zEuVUqFV1DihJT";

            String url1 = str1+code+gdp_code+apikey;
            String url2 = str2+oil_code+code+apikey;
            OkHttpClient client = new OkHttpClient();
            Request request1 = new Request.Builder().url(url1).build();
            Request request2 = new Request.Builder().url(url2).build();
            try (Response response2 = client.newCall(request2).execute()) {
                if(response2.isSuccessful() && response2.body() != null) {
                    Gson gsonoil = new Gson();
                    JsonOil JsonOil = gsonoil.fromJson(response2.body().string(), JsonOil.class);
                    oilcountry.setText(JsonOil.getDataset().getName());
                    OilStartDate.setText(JsonOil.getDataset().getStartDate());
                    OilEndDate.setText(JsonOil.getDataset().getEndDate());
                    int oil=JsonOil.getDataset().getData().size();
                    for(i=0;i<oil;i++){
                        
                        OILmodel.addRow(new Object[]{(JsonOil.getDataset().getData().get(i).get(0).toString()).substring(0, 4), JsonOil.getDataset().getData().get(i).get(1)});
                    }
                }
            } catch (IOException e) {
        }
            try (Response response1 = client.newCall(request1).execute()) {
                if(response1.isSuccessful() && response1.body() != null) {
                    Gson gsongpd = new Gson();
                    JsonGdp JsonGdp = gsongpd.fromJson(response1.body().string(), JsonGdp.class);
                    gpdcountry.setText(JsonGdp.getDataset().getName());
                    GDPStartDate.setText(JsonGdp.getDataset().getStartDate());
                    GDPEndDate.setText(JsonGdp.getDataset().getEndDate());
                    int gdp=JsonGdp.getDataset().getData().size();
                    for(i=0;i<gdp;i++){
                        DecimalFormat df1 = new DecimalFormat("#.#");
                        GDPmodel.addRow(new Object[]{(JsonGdp.getDataset().getData().get(i).get(0).toString()).substring(0, 4), df1.format(JsonGdp.getDataset().getData().get(i).get(1))});
                    }
                }
            } catch (IOException e) {
        }  
    }
    em.close();
    emf.close();
    }//GEN-LAST:event_Fetch_ButtonActionPerformed

    private void Save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_ButtonActionPerformed
        //Δημιουργία του Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EconometricaPU");
        //Δημιουργία του EntityManager
        EntityManager em = emf.createEntityManager();
        String selection = (String) CountrySelect.getSelectedItem();        
        String gdpCountry = (String) gpdcountry.getText();        
        String gdpStartDate = (String) GDPStartDate.getText();        
        String gdpEndDate = (String) GDPEndDate.getText();        
        String oilCountry = (String) oilcountry.getText();        
        String oilStartDate = (String) OilStartDate.getText();
        String oilEndDate = (String) OilEndDate.getText();

        String line;  
        String splitBy = ";"; 
        String csv = "iso-countries.csv";
        String iso = null;
        try{  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader(csv));
            br.readLine();
            while ((line = br.readLine())!= null){   //returns a Boolean value  
                String[] country = line.split(splitBy);    // use comma as separator  
                String[][] csvData = new String[250][4];
                int a = 0;
                csvData[a][0] = country[0];
                csvData[a][1] = country[1];
                csvData[a][2] = country[2];
                csvData[a][3] = country[3];                   
                if(csvData[a][0] == null ? selection == null : csvData[a][0].equals(selection)){
                    iso = csvData[a][3];
                    break;
                }
                a++;
            }  
        } catch (IOException e){  
    } 

        em.getTransaction().begin();
        
        Country country = new Country (iso, selection);
        em.persist(country);
        em.flush();        
        if(!gdpCountry.isEmpty()){
            CountryDataset cdatasetgdp = new CountryDataset(null, gdpStartDate.substring(0, 4), gdpCountry, gdpEndDate.substring(0, 4));
            cdatasetgdp.setCountryCode(country);
            cdatasetgdp.setDescription(gdpCountry);
            em.persist(cdatasetgdp);
            em.flush();
            for(int i=0;i<GPDDataTable.getRowCount();i++){
                String gpddate = (String) GPDDataTable.getValueAt(i, 0);
                String gpdvalue = (String) GPDDataTable.getValueAt(i, 1);
                CountryData cdatagdp = new CountryData(null, gpddate, gpdvalue);
                cdatagdp.setDataset(cdatasetgdp);
                em.persist(cdatagdp);
                em.flush();
            }
        }            
            if(!oilCountry.isEmpty()){
                CountryDataset cdatasetoil = new CountryDataset(null, oilStartDate.substring(0, 4), oilCountry, oilEndDate.substring(0, 4));
                cdatasetoil.setCountryCode(country);
                cdatasetoil.setDescription(oilCountry);
                em.persist(cdatasetoil);
                em.flush();
                for(int j=0;j<OilDataTable.getRowCount();j++){
                String oildate = (String) OilDataTable.getValueAt(j, 0);
                String oilvalue = (String) OilDataTable.getValueAt(j, 1);
                CountryData cdataoil = new CountryData(null, oildate, oilvalue);
                cdataoil.setDataset(cdatasetoil);
                em.persist(cdataoil);
                em.flush();
            }
        }
        SavedCheckBox.setEnabled(true);
        SavedCheckBox.doClick();
        SavedCheckBox.setEnabled(false);
        Save_Button.setEnabled(false);

        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }//GEN-LAST:event_Save_ButtonActionPerformed

    public void OilCountry(String selection) {
        oilcountry.setText(String.valueOf(selection));
    }

    public void GPDCountry(String selection) {
        gpdcountry.setText(String.valueOf(selection));
    }
    
    public void OilStartDate(String oilstartdate) {
        OilStartDate.setText(String.valueOf(oilstartdate));
    }
    
    public void OilEndDate(String oilenddate) {
        OilEndDate.setText(String.valueOf(oilenddate));
    }
    
    public void GPDStartDate(String gpdstartdate) {
        GDPStartDate.setText(String.valueOf(gpdstartdate));
    }
    
    public void GPDEndDate(String gpdenddate) {
        GDPEndDate.setText(String.valueOf(gpdenddate));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CountrySelect;
    private javax.swing.JButton Delete_Button;
    private javax.swing.JButton Fetch_Button;
    private javax.swing.JLabel GDPEndDate;
    private javax.swing.JLabel GDPStartDate;
    private javax.swing.JTable GPDDataTable;
    private javax.swing.JTable OilDataTable;
    private javax.swing.JLabel OilEndDate;
    private javax.swing.JLabel OilStartDate;
    private javax.swing.JButton Plot_Button;
    private javax.swing.JButton Save_Button;
    private javax.swing.JCheckBox SavedCheckBox;
    private javax.swing.JLabel gpdcountry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel oilcountry;
    // End of variables declaration//GEN-END:variables
}
