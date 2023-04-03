/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Antikvitet;
import java.util.ArrayList;
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
public class AntikvitetiTableModel extends AbstractTableModel {

    List<Antikvitet> antikviteti;
    boolean pretraga = false;
    Pair<Object, Object> p;
    
    public AntikvitetiTableModel() {
        try {
            this.antikviteti = Komunikacija.getInstance().UcitajAntikvitete();
        } catch (Exception ex) {
            Logger.getLogger(AntikvitetiTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AntikvitetiTableModel(List<Antikvitet> antikviteti) {
        this.antikviteti = antikviteti;
        pretraga = true;
    }
    public AntikvitetiTableModel(List<Antikvitet> antikviteti,Pair p) {
        System.out.println("model.AntikvitetiTableModel.<init>(), usao u model");
        this.antikviteti = antikviteti;
        pretraga = true;
        this.p=p;
        System.out.println("model.AntikvitetiTableModel.<init>(), zavrsio konstruktor model");
    }

    @Override
    public int getRowCount() {
        return antikviteti.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return antikviteti.get(rowIndex).getNaziv();
            case 1:
                return antikviteti.get(rowIndex).getVrednost();
            case 2:
                return antikviteti.get(rowIndex).getValuta();
            case 3:
                return antikviteti.get(rowIndex).getTipAntikviteta().getNaziv();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        String[] nazivi = {"Naziv", "Vrednost", "Valuta", "Tip antikviteta"};
        return nazivi[column];
    }

    public void add(Antikvitet antikvitet) {
        antikviteti.add(antikvitet);
        fireTableDataChanged();
    }

    public Antikvitet get(int row) {
        return antikviteti.get(row);
    }

    public void dodajAntikvitete(List<Antikvitet> antikviteti) {
        this.antikviteti = antikviteti;
        fireTableDataChanged();
    }

    public void osvezi() {
        if (!pretraga && p==null) {
            try {
                antikviteti = Komunikacija.getInstance().UcitajAntikvitete();
                fireTableDataChanged();
            } catch (Exception ex) {
                Logger.getLogger(AntikvitetiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(p!=null && false){
            try {
                antikviteti=Komunikacija.getInstance().UcitajAntikviteteSaParametrom(p);
                fireTableDataChanged();
            } catch (Exception ex) {
                Logger.getLogger(AntikvitetiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete(int row) {
        antikviteti.remove(row);
        fireTableDataChanged();
    }
    
    public void promeniSignal(){
        pretraga=!pretraga;
    }

}
