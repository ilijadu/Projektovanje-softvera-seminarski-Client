/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Antikvitet;
import domain.Vlasnik;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import komunikacija.Komunikacija;

/**
 *
 * @author Ilija Dumanović
 */
public class VlasniciTableModel extends AbstractTableModel {

    List<Vlasnik> vlasnici;
    boolean pretraga = false;

    public VlasniciTableModel() {
        try {
            this.vlasnici = Komunikacija.getInstance().UcitajVlasnike();
        } catch (Exception ex) {
            Logger.getLogger(VlasniciTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public VlasniciTableModel(List<Vlasnik> vlasnici) {
        this.vlasnici = vlasnici;
        pretraga=true;
    }

    @Override
    public int getRowCount() {
        return vlasnici.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return vlasnici.get(rowIndex).getIme();
            case 1:
                return vlasnici.get(rowIndex).getPrezime();
            case 2:
                return vlasnici.get(rowIndex).getDatumRodjenja();
            case 3:
                return vlasnici.get(rowIndex).getMesto().getNaziv();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        String[] nazivi = {"Ime", "Prezime","Datum rodjenja","Mesto"};
        return nazivi[column];
    }

    public void add(Vlasnik vlasnik) {
        vlasnici.add(vlasnik);
        fireTableDataChanged();
    }

    public Vlasnik get(int row) {
        return vlasnici.get(row);
    }

    public void delete(int row) {
        vlasnici.remove(row);
        fireTableDataChanged();
    }

    public void dodajVlasnike(List<Vlasnik> vlasnici) {
        this.vlasnici = vlasnici;
        fireTableDataChanged();
    }

    public void osvezi() {
        if (!pretraga) {
            try {
                vlasnici = Komunikacija.getInstance().UcitajVlasnike();
                System.out.println("model.VlasniciTableModel.osvezi(), vlasnici: "+vlasnici);
                fireTableDataChanged();
            } catch (Exception ex) {
                Logger.getLogger(AntikvitetiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void promeniSignal(){
        pretraga=!pretraga;
    }

}
