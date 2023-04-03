/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import domain.Aukcija;
import domain.Vlasnik;
import forms.util.FormView;
import forms.util.ModelTabele;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.PretragaAukcijaTableModel;
import model.VlasniciTableModel;
import model.nit.NitTabele;

/**
 *
 * @author Ilija Dumanović
 */
public class PretrazivanjeAukcije extends javax.swing.JFrame {

    /**
     * Creates new form PretrazivanjeAukcije
     */
    List<Aukcija> aukcije;
    List<Aukcija> pretraga;
    String strPretraga = "";
    NitTabele n;

    public PretrazivanjeAukcije() {
        initComponents();
        uzmiAukcije();
        populateForm();
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
        txtPretraga = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnObrisiPretragu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAukcije = new javax.swing.JTable();
        btnDetalji = new javax.swing.JButton();
        btnDodajNovu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Aukcije");

        jLabel2.setText("Pretražite aukcije po nazivu: ");

        btnPretrazi.setText("Pretraži");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnObrisiPretragu.setText("Osveži tabelu");
        btnObrisiPretragu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiPretraguActionPerformed(evt);
            }
        });

        tblAukcije.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAukcije);

        btnDetalji.setText("Detalji o aukciji");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        btnDodajNovu.setText("Dodaj novu aukciju");
        btnDodajNovu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNovuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDetalji)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodajNovu))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnPretrazi)
                            .addGap(18, 18, 18)
                            .addComponent(btnObrisiPretragu))
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi)
                    .addComponent(btnObrisiPretragu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalji)
                    .addComponent(btnDodajNovu))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiPretraguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiPretraguActionPerformed
        pretraga = null;
        txtPretraga.setText("");
        tblAukcije.setModel(new PretragaAukcijaTableModel());
        tblAukcije.getSelectionModel().clearSelection();
    }//GEN-LAST:event_btnObrisiPretraguActionPerformed

    private void btnDodajNovuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNovuActionPerformed
        try {
            new KreiranjeAukcije(FormView.FORM_ADD_MODE).setVisible(true);
            tblAukcije.getSelectionModel().clearSelection();
            uzmiAukcije();
        } catch (Exception ex) {
            Logger.getLogger(PretrazivanjeVlasnika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajNovuActionPerformed

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        if (tblAukcije.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da prikaže podatke aukcije. Molomo Vas da izaberete aukciju pre prikazivanja detalja! ", "Poruka", JOptionPane.OK_OPTION);
        } else if (pretraga != null) {
            //n.promeniSignal();
            Aukcija v = pretraga.get(tblAukcije.getSelectedRow());
            new KreiranjeAukcije(FormView.FORM_VIEW_MODE, v, this);

        } else {
            //n.promeniSignal();
            uzmiAukcije();
            Aukcija v = aukcije.get(tblAukcije.getSelectedRow());
            new KreiranjeAukcije(FormView.FORM_VIEW_MODE, v, this);

        }
        tblAukcije.getSelectionModel().clearSelection();
    }//GEN-LAST:event_btnDetaljiActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        strPretraga = txtPretraga.getText().toLowerCase();
        if (!strPretraga.isEmpty()) {
            pretragaAukcija();
            if (pretraga.size() == 0) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da nađe aukciju po zadatoj vrednosti.Ne postoji aukcija sa datim nazivom!");
            } else if (pretraga.size() > 1) {
                System.out.println("forms.PretrazivanjeVlasnika.pretragaVlasnika(), prtraga: " + pretraga);
                tblAukcije.setModel(new PretragaAukcijaTableModel(pretraga));
                JOptionPane.showMessageDialog(this, "Sistem je pronašao više rezultata. Molimo Vas da odaberete neku od prikazanih aukcija.");
            } else {
                tblAukcije.setModel(new PretragaAukcijaTableModel(pretraga));
                JOptionPane.showMessageDialog(this, "Sistem je našao aukcija po zadatoj vrednosti.");

            }
            tblAukcije.getSelectionModel().clearSelection();
        } else {
            pretraga = null;
            JOptionPane.showMessageDialog(this, "Pre pretrage unesite karaktere za pretragu.");
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        n.promeniSignal();
        n=null;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnDodajNovu;
    private javax.swing.JButton btnObrisiPretragu;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAukcije;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    private void populateForm() {
        try {
            tblAukcije.setModel(new PretragaAukcijaTableModel());
            n = new NitTabele(tblAukcije, ModelTabele.PRETRAGA_AUKCIJA_MODEL);
        } catch (Exception ex) {
            Logger.getLogger(PretrazivanjeVlasnika.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void uzmiAukcije() {
        try {
            aukcije = Komunikacija.getInstance().UcitajAukcije();
        } catch (Exception ex) {
            Logger.getLogger(PretrazivanjeVlasnika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void pretragaAukcija() {
        uzmiAukcije();
        pretraga = new ArrayList<>();
        for (Aukcija a : aukcije) {

            if (a.getNaziv().toLowerCase().contains(strPretraga)) {
                pretraga.add(a);
            }
        }

    }

}
