/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclinic;


import TreatmentD.Counseling;
import TreatmentD.Services;
import TreatmentD.Treatment;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class allServicesForm extends javax.swing.JFrame {

    /**
     * Creates new form allServicesForm
     */
    public allServicesForm() throws Exception {
        initComponents();
        initData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTretment = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCounseling = new javax.swing.JTable();
        jButtonAddNewService = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "שם", "תעודת זהות", "טלפון"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("קליניקה רפואה שלמה ");

        jLabel2.setText("רשימת לקוחות ");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel3.setText("קליניקה רפואה שלמה ");

        jLabel4.setText("כל השירותים");

        jTableTretment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "שם", "תעודת זהות", "טלפון"
            }
        ));
        jScrollPane3.setViewportView(jTableTretment);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("טיפול", jPanel1);

        jTableCounseling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "שם", "תעודת זהות", "טלפון"
            }
        ));
        jScrollPane2.setViewportView(jTableCounseling);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("יעוץ", jPanel2);

        jButtonAddNewService.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonAddNewService.setText("הוספת שרות חדש");
        jButtonAddNewService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewServiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAddNewService)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jButtonAddNewService))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddNewServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewServiceActionPerformed
        addNewServiceForm f = new addNewServiceForm();
        f.setVisible(true);
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    }//GEN-LAST:event_jButtonAddNewServiceActionPerformed

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
            java.util.logging.Logger.getLogger(allServicesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(allServicesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(allServicesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(allServicesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new allServicesForm().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(allServicesForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private ArrayList<Services> retServiceByType(Boolean ifCunseling) throws Exception {
        ArrayList<Services> ret = new ArrayList<>();
        for (Services s : GUIclinic.Controler.GetAllServices()) {
            if (ifCunseling) {
                if (s instanceof Counseling) {
                    ret.add(new Counseling((Counseling) s));
                }
            } else {
                if (s instanceof Treatment) {
                    ret.add(new Treatment((Treatment) s));
                }
                
            }
        }
        return ret;
        
    }
    
    private void initData() throws Exception {
        Vector<String> titColForCounseling = new Vector<String>();
        Vector colDataForCounseling = new Vector();
        Vector row;
        Vector<String> titColForTretment = new Vector<String>();
        Vector colDataForTretment = new Vector();
        /*
         for Counseling col titles
         */
        
        titColForCounseling.add("סוג הטיפול");
        titColForCounseling.add("מזהה");
        titColForCounseling.add("מחיר");
        titColForCounseling.add("שם היועץ");

        /*
         for Tretment col titles
         */
        titColForTretment.add("סוג הטיפול");
        titColForTretment.add("מזהה");
        titColForTretment.add("בעיה");
        titColForTretment.add("מחיר");
        titColForTretment.add("שם היועץ");
        //loop for Counseling date
        
        for (Object s : retServiceByType(true)) {
            // s=(Counseling)s;//cast to Counseling
            row = new Vector();
            row.add(((Counseling) s).getTyps());
            row.add(((Counseling) s).getId());
            row.add(((Counseling) s).getPrice());
            row.add(((Counseling) s).getNameOfAttendant());
            colDataForCounseling.add(row);
        }
        jTableCounseling.setModel(new javax.swing.table.DefaultTableModel(
                colDataForCounseling,
                titColForCounseling
        ));
        
        jTableCounseling.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableCounseling.getColumnModel().getColumn(1).setMinWidth(0);
        jTableCounseling.getColumnModel().getColumn(1).setPreferredWidth(0);
        //loop for Tretment     
        for (Object s : retServiceByType(false)) {
            // s=(Counseling)s;//cast to Counseling
            row = new Vector();
            row.add(((Treatment) s).getTypes());
            row.add(((Treatment) s).getId());
            row.add(((Treatment) s).getProblem());
            row.add(((Treatment) s).getPrice());
            row.add(((Treatment) s).getNameOfAttendant());
            colDataForTretment.add(row);
        }
        jTableTretment.setModel(new javax.swing.table.DefaultTableModel(
                colDataForTretment,
                titColForTretment
        ));
        jTableTretment.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableTretment.getColumnModel().getColumn(1).setMinWidth(0);
        jTableTretment.getColumnModel().getColumn(1).setPreferredWidth(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddNewService;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableCounseling;
    private javax.swing.JTable jTableTretment;
    // End of variables declaration//GEN-END:variables
}