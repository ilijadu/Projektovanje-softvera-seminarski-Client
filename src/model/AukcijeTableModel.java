/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Antikvitet;
import domain.ProdajaAntikviteta;
import domain.Vlasnik;
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
public class AukcijeTableModel extends AbstractTableModel {

    List<ProdajaAntikviteta> prodati;
    boolean pretraga = false;
    Pair<Object, Object> p;

    public AukcijeTableModel() {
        try {
            prodati = Komunikacija.getInstance().UcitajSveProdajaAntikviteta();
        } catch (Exception ex) {
            Logger.getLogger(AukcijeTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AukcijeTableModel(List<ProdajaAntikviteta> prodati) {
        this.prodati = prodati;
        pretraga = true;
    }

    public AukcijeTableModel(List<ProdajaAntikviteta> prodati, Pair p) {
        System.out.println("model.AntikvitetiTableModel.<init>(), usao u model");
        this.prodati = prodati;
        pretraga = true;
        this.p = p;
        System.out.println("model.AntikvitetiTableModel.<init>(), zavrsio konstruktor model");
    }

    @Override
    public int getRowCount() {
        return prodati.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return prodati.get(rowIndex).getAntikvitet().getNaziv();
            case 1:
                return prodati.get(rowIndex).getAntikvitet().getVrednost();
            case 2:
                return prodati.get(rowIndex).getCena();
            case 3:
                return prodati.get(rowIndex).getValuta();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        String[] nazivi = {"Naziv antikviteta", "Početna vrednost", "Prodajna vrednost", "Valuta"};
        return nazivi[column];
    }

    public void add(ProdajaAntikviteta antikvitet) {
        prodati.add(antikvitet);
        fireTableDataChanged();
    }

    public ProdajaAntikviteta get(int row) {
        return prodati.get(row);
    }

    public void delete(int row) {
        prodati.remove(row);
        fireTableDataChanged();
    }

    public void dodajProdate(List<ProdajaAntikviteta> prodati) {
        this.prodati = prodati;
        fireTableDataChanged();
    }

    public void obrisiSve() {
        prodati.clear();
        fireTableDataChanged();
    }

    public void osvezi() {
        if (!pretraga) {
            try {
                prodati = Komunikacija.getInstance().UcitajSveProdajaAntikviteta();
                fireTableDataChanged();
            } catch (Exception ex) {
                Logger.getLogger(AntikvitetiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void promeniSignal() {
        pretraga = !pretraga;
    }
}
