/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

/**
 *
 * @author Ilija Dumanović
 */
public class OAplikaciji extends javax.swing.JFrame {

    public OAplikaciji() {
        initComponents();
        jEditorPane1.setText("Softverski sistem omogućuje agentu da evidentira(unese/kreira) novog vlasnika u sistem tako što će uneti njegove podatke kao što su lični podaci (ime, prezime, datum i mesto rođenja, jedinstveni matični broj). Takođe, sistem omogućava i unos podataka o novom antikvitetu koji se tiču naziva dela, vremenskog period u kom je delo nastalo, pravac kome pripada, tip dela, procenjena vrednost i kratak opis. Samo delo može biti novijeg doba(poznat je njegov autor) ili delo čiji je vlasnik/tvorac nepoznat, pa je unos podatka o autoru opciono polje. Agentu je omogućeno da vrši izmenu podataka o antikvitetu u koliko dođe do novih arheoloških otkrića ili novih saznanja o samom autoru/tvorcu dela. Agentu je takođe omogućeno da pretražuje druge antikvitete na osnovu naziva, pravca kojem pripada ili tipa umetnosti. Putem softverskog sistema, omogućeno je i pretraživanje vlasnika (ukucavanjem imena ili prezimena vlasnika ili pretragom spiska svih vlasnika), kao i brisanje antikviteta ukoliko se proda ili se više ne nalazi u njegovoj kolekciji. Takođe, agent može da pokrene/kreira aukciju (unošenje podataka o nazivu aukcije, datumu održavanja, mestu održ avanja, broju zvanica) zajedno sa vlasnikom dela/antikviteta radi prodaje, kao i da menjaju podatke o samoj aukciji.");
        jEditorPane1.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opis");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Aplikacija za evidentiranje antivkiteta");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jScrollPane1.setViewportView(jEditorPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
