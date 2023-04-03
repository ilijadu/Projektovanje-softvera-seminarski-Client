/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.nit;

import forms.util.ModelTabele;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import model.AntikvitetiTableModel;
import model.AukcijeTableModel;
import model.PretragaAukcijaTableModel;
import model.VlasniciTableModel;

/**
 *
 * @author Ilija Dumanović
 */
public class NitTabele extends Thread {

    JTable tabela;
    int model;
    boolean signal = true;

    public NitTabele(JTable tabela, int model) {
        this.tabela = tabela;
        this.model = model;
        System.out.println("model.nit.NitTabele.<init>(),zavrsio konstruktor u niti, ovo je pre start()");
        
        start();
    }
    @Override
    public void run() {
        while (signal) {
            try {
                if (tabela.getSelectedRow() == -1) {
                    osveziModel(model);
                    sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(NitTabele.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void promeniSignal() {
        signal = !signal;
    }

    private void osveziModel(int model) {
        switch (model) {
            case ModelTabele.ANTIKVITET_MODEL:
                System.out.println("model.nit.NitTabele.osveziModel(), pre osvezavanjas u niti");
                ((AntikvitetiTableModel) tabela.getModel()).osvezi();
                break;
            case ModelTabele.AUKCIJA_MODEL:
                ((AukcijeTableModel) tabela.getModel()).osvezi();
                break;
            case ModelTabele.VLASNIK_MODEL:
                ((VlasniciTableModel) tabela.getModel()).osvezi();
                break;
            case ModelTabele.PRETRAGA_AUKCIJA_MODEL:
                ((PretragaAukcijaTableModel) tabela.getModel()).osvezi();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void cekaj(){
        try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(NitTabele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void pokreni(){
        this.notify();
    }
}
