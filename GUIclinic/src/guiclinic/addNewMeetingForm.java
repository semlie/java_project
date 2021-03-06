/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclinic;

import Treatments.Counseling;
import Treatments.Meeting;
import Treatments.Patient;
import Treatments.Services;
import Treatments.Treatment;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dell
 */
public class addNewMeetingForm extends javax.swing.JFrame {

    /**
     * Creates new form addNewMeetingForm
     */
    public addNewMeetingForm() throws Exception {
        initComponents();
        fillSelctType();
        fillNameOfExistPatient();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCoustemer = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAllServicesAvilable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jComboBoxCategory = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxTreatType = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jCheckBoxIsPayed = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("הוספת פגישה חדשה");

        jLabel2.setText("לקוח קיים");

        jComboBoxCoustemer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCoustemer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCoustemerActionPerformed(evt);
            }
        });

        jLabel3.setText("בחירת לקוח");

        jLabel4.setText("לקוח חדש");

        jButton1.setText("הוסף לקוח חדש");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jLabel5.setText("תאריך הפגישה");

        jTableAllServicesAvilable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableAllServicesAvilable);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jButton2.setText("שמירה");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("סינון לפי סוג");

        jLabel7.setText("אופי הפגישה");

        jComboBoxTreatType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("האם שולם");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(jLabel4))
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jCheckBoxIsPayed)
                                        .addComponent(jComboBoxCoustemer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(39, 39, 39)
                                            .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(43, 43, 43)
                                            .addComponent(jLabel8))))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                                .addComponent(jComboBoxCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxTreatType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(jLabel5))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCoustemer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addComponent(jCheckBoxIsPayed))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTreatType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCoustemerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCoustemerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCoustemerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addNewPatientForm f = new addNewPatientForm();
        f.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            try {
//                JOptionPane.showMessageDialog(null, "Bye Bye!");
                fillNameOfExistPatient();
               
               // ExitAction.getInstance().actionPerformed(null);
            } catch (Exception ex) {
                Logger.getLogger(addNewMeetingForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    });
        f.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // save button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       for (int i=0;i<jTableAllServicesAvilable.getRowCount();i++){
           Boolean chk = (Boolean)jTableAllServicesAvilable.getValueAt(i, 4);
           if (chk) {
               // retrieve row's ;
               jTableAllServicesAvilable.getValueAt(i, 4);
               
               String type = jTableAllServicesAvilable.getValueAt(i, 5).toString();
                 try {
                      // retrive the selected costumer
                     Patient p = GUIclinic.Controler.GetAllPatient().get(jComboBoxCoustemer.getSelectedIndex());
                     int id = Integer.parseInt(jTableAllServicesAvilable.getValueAt(i, 1).toString());
                     double price = Double.parseDouble(jTableAllServicesAvilable.getValueAt(i, 2).toString());
                     String name = jTableAllServicesAvilable.getValueAt(i, 3).toString();
                     JFormattedTextField editor = jXDatePicker1.getEditor();
                     Date date = (Date) editor.getValue();
//                     Date date = jXDatePicker1.getDate();
                     if(type.equals("יעוץ")){
                        Services.TypesCons tC = Services.TypesCons.valueOf(jTableAllServicesAvilable.getValueAt(i, 0).toString());
                        GUIclinic.Controler.AddMeeting(new Meeting(p,new Counseling(tC, id, date, price, name)));
                     }
                     else{
                         Services.TypesTret tT = Services.TypesTret.valueOf(jTableAllServicesAvilable.getValueAt(i, 0).toString());
                         GUIclinic.Controler.AddMeeting(new Meeting(p,new Treatment(tT, "", id, date, price, name)));
                     }
                         
               } catch (Exception ex) {
                   Logger.getLogger(addNewMeetingForm.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1ActionPerformed
    public void fillSelctType() throws Exception{
        
        jComboBoxTreatType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "יעוץ", "טיפול"}));
        Vector comboBoxItems=new Vector();
        for(String o:GUIclinic.Controler.counselingType()){
            comboBoxItems.add(o);
        }
        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel(comboBoxItems));
        //
        // For listening to the changes of the selected items in the combo box
        // we need to add an ItemListener to the combo box component as shown
        // below.
        //
        jComboBoxCategory.addItemListener(new ItemListener() {
            //
            // Listening if a new items of the combo box has been selected.
            //
            @Override
            public void itemStateChanged(ItemEvent event) {
                // The item affected by the event.
                Object item = event.getItem();
                if (event.getStateChange() == ItemEvent.SELECTED) {
                   JOptionPane.showConfirmDialog(null, item);
                    try {
                        initData();
                    } catch (Exception ex) {
                        Logger.getLogger(addNewMeetingForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        jComboBoxTreatType.addItemListener(new ItemListener() {
            //
            // Listening if a new items of the combo box has been selected.
            //
            @Override
            public void itemStateChanged(ItemEvent event) {
                // The item affected by the event.
                Object item = event.getItem();
                if (event.getStateChange() == ItemEvent.SELECTED) {
                   JOptionPane.showConfirmDialog(null, item);
                    try {
                        initData();
                    } catch (Exception ex) {
                        Logger.getLogger(addNewMeetingForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
    }
    public void fillNameOfExistPatient() throws Exception{
        Vector comboBoxItems=new Vector();
        for(Patient o:GUIclinic.Controler.GetAllPatient()){
            comboBoxItems.add(o.getName());
        }
        jComboBoxCoustemer.setModel(new javax.swing.DefaultComboBoxModel(comboBoxItems));
//         SwingUtilities.updateComponentTreeUI(this);
        jComboBoxCoustemer.invalidate();
        jComboBoxCoustemer.validate();
        jComboBoxCoustemer.repaint();
    }
    public ArrayList<String> retServiceByType (Boolean b){
        return null;
        }
    private void initDataPrev() throws Exception {
        
        jXDatePicker1.setFormats("dd-MM-yyyy HH:mm:ss");
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
        titColForCounseling.add("בחר");
        titColForCounseling.add("סוג הטיפול");

        /*
         for Tretment col titles
         */

        //loop for Counseling date

        for (Object s : GUIclinic.Controler.GetAllServices()) {
            // s=(Counseling)s;//cast to Counseling
            row = new Vector();
            if (s instanceof Counseling) {
                
                row.add(((Counseling) s).getTyps());
                row.add(((Counseling) s).getId());
                row.add(((Counseling) s).getPrice());
                row.add(((Counseling) s).getNameOfAttendant());
                row.add(Boolean.FALSE);
                row.add("יעוץ");
            } else {
                row.add(((Treatment) s).getTypes());
                row.add(((Treatment) s).getId());
                row.add(((Treatment) s).getPrice());
                row.add(((Treatment) s).getNameOfAttendant());
                row.add(Boolean.FALSE);
                row.add("טיפול");
            }
            colDataForCounseling.add(row);
        }
        jTableAllServicesAvilable.setModel(new javax.swing.table.DefaultTableModel(
        colDataForCounseling,
        titColForCounseling
        ));        //loop for Tretment     
        jTableAllServicesAvilable.getColumnModel().getColumn(4).setCellRenderer(
                jTableAllServicesAvilable.getDefaultRenderer(Boolean.class));
        jTableAllServicesAvilable.getColumnModel().getColumn(4).setCellEditor(
                jTableAllServicesAvilable.getDefaultEditor(Boolean.class));
   
        /*jTableTretment.setModel(new javax.swing.table.DefaultTableModel(
        colDataForTretment,
        titColForTretment
        ));*/
    }
    
    
    
     private void initData() throws Exception {
        
        jXDatePicker1.setFormats("dd-MM-yyyy HH:mm:ss");
        Vector<String> titColForCounseling = new Vector<String>();
        Vector colDataForCounseling = new Vector();
        Vector row;
        Vector<String> titColForTretment = new Vector<String>();
        Vector colDataForTretment = new Vector();
        String type=jComboBoxCategory.getSelectedItem().toString();
        String tp=jComboBoxTreatType.getSelectedItem().toString();
        /*
         for Counseling col titles
         */

        titColForCounseling.add("סוג הטיפול");
        titColForCounseling.add("מזהה");
        titColForCounseling.add("מחיר");
        titColForCounseling.add("שם היועץ");
        titColForCounseling.add("בחר");
        titColForCounseling.add("אופי הפגישה");

        /*
         for Tretment col titles
         */

        //loop for Counseling date

        for (Object s : GUIclinic.Controler.GetAllServices()) {
            // s=(Counseling)s;//cast to Counseling
            row = new Vector();
            if (s instanceof Counseling) {
                if(!((Counseling) s).getTyps().toString().equals(type))
                    continue;
                if (tp.equals("טיפול"))
                    continue;
                row.add(((Counseling) s).getTyps());
                row.add(((Counseling) s).getId());
                row.add(((Counseling) s).getPrice());
                row.add(((Counseling) s).getNameOfAttendant());
                row.add(Boolean.FALSE);
                row.add("יעוץ");
            } else {
                 if(!((Treatment) s).getTypes().toString().equals(type))
                    continue;
                 if (tp.equals("יעוץ"))
                    continue;
                row.add(((Treatment) s).getTypes());
                row.add(((Treatment) s).getId());
                row.add(((Treatment) s).getPrice());
                row.add(((Treatment) s).getNameOfAttendant());
                row.add(Boolean.FALSE);
                row.add("טיפול");
            }
            colDataForCounseling.add(row);
        }
        jTableAllServicesAvilable.setModel(new javax.swing.table.DefaultTableModel(
        colDataForCounseling,
        titColForCounseling
        ));        //loop for Tretment     
        jTableAllServicesAvilable.getColumnModel().getColumn(4).setCellRenderer(
                jTableAllServicesAvilable.getDefaultRenderer(Boolean.class));
        jTableAllServicesAvilable.getColumnModel().getColumn(4).setCellEditor(
                jTableAllServicesAvilable.getDefaultEditor(Boolean.class));
   
        jTableAllServicesAvilable.invalidate();
        jTableAllServicesAvilable.validate();
        jTableAllServicesAvilable.repaint();
        /*jTableTretment.setModel(new javax.swing.table.DefaultTableModel(
        colDataForTretment,
        titColForTretment
        ));*/
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
            java.util.logging.Logger.getLogger(addNewMeetingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addNewMeetingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addNewMeetingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addNewMeetingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new addNewMeetingForm().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(addNewMeetingForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBoxIsPayed;
    private javax.swing.JComboBox jComboBoxCategory;
    private javax.swing.JComboBox jComboBoxCoustemer;
    private javax.swing.JComboBox jComboBoxTreatType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAllServicesAvilable;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}
