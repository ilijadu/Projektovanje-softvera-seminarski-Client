/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Antikvitet;
import domain.Aukcija;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.table.AbstractTableModel;
import komunikacija.Komunikacija;

/**
 *
 * @author Ilija Dumanović
 */
public class PretragaAukcijaTableModel extends AbstractTableModel {

    List<Aukcija> aukcije;

    boolean pretraga = false;
    Pair<Object, Object> p;

    public PretragaAukcijaTableModel() {
        try {
            this.aukcije = Komunikacija.getInstance().UcitajAukcije();
        } catch (Exception ex) {
            Logger.getLogger(AntikvitetiTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PretragaAukcijaTableModel(List<Aukcija> aukcije) {
        this.aukcije = aukcije;
        pretraga = true;
    }
    
    public PretragaAukcijaTableModel(List<Aukcija> aukcije,Pair p) {
        System.out.println("model.AntikvitetiTableModel.<init>(), usao u model");
        this.aukcije = aukcije;
        pretraga = true;
        this.p=p;
        System.out.println("model.AntikvitetiTableModel.<init>(), zavrsio konstruktor model");
    }

    @Override
    public int getRowCount() {
        return aukcije.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return aukcije.get(rowIndex).getNaziv();
            case 1:
                return aukcije.get(rowIndex).getDatumOdrzavanja();
            case 2:
                return aukcije.get(rowIndex).getMesto();

            default:
                throw new AssertionError();
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] nazivi = {"Naziv", "Datum održavanja", "Mesto održavanja"};
        return nazivi[column];
    }
    public void add(Aukcija aukcija) {
        aukcije.add(aukcija);
        fireTableDataChanged();
    }

    public Aukcija get(int row) {
        return aukcije.get(row);
    }

    public void dodajAukcije(List<Aukcija> aukcije) {
        this.aukcije = aukcije;
        fireTableDataChanged();
    }

    public void osvezi() {
        if (!pretraga && p==null) {
            try {
                aukcije = Komunikacija.getInstance().UcitajAukcije();
                fireTableDataChanged();
            } catch (Exception ex) {
                Logger.getLogger(AntikvitetiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(p!=null && false){
            try {
                aukcije=Komunikacija.getInstance().UcitajAukcijeSaParametrom(p);
                fireTableDataChanged();
            } catch (Exception ex) {
                Logger.getLogger(AntikvitetiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete(int row) {
        aukcije.remove(row);
        fireTableDataChanged();
    }
    
    public void promeniSignal(){
        pretraga=!pretraga;
    }

}
