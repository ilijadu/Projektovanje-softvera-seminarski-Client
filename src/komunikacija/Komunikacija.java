/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import communication.Receiver;
import communication.Sender;
import domain.Antikvitet;
import domain.Aukcija;
import domain.Korisnik;
import domain.Mesto;
import domain.ProdajaAntikviteta;
import domain.TipAntikviteta;
import domain.Vlasnik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import javafx.util.Pair;
import operation.Operation;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Ilija Dumanović
 */
public class Komunikacija {
    private Socket socket;
    private static Komunikacija instance;
    private Sender sender;
    private Receiver receiver;

    private Komunikacija() {
        try {
            this.socket = new Socket("localhost", 9000);
            this.sender = new Sender(socket);
            this.receiver = new Receiver(socket);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public Korisnik login(String username,String password) throws Exception{
        Korisnik user= new Korisnik(username,password,null,null);
        Request request=new Request(user, Operation.login);
        sender.send(request);
        System.out.println("poslat korisnik");
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (Korisnik)response.getObj();
        }else{
            logout();
            throw response.getException();
            
        }
    }
    public String logout() throws Exception{
        Request request=new Request(null, Operation.logout);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            socket.close();
            instance=null;
            return (String)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public Response KreirajAntikvitet(Antikvitet a) throws Exception{
        Request request=new Request(a, Operation.KreirajAntikvitet);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return response;
        }else{
            throw response.getException();
        }
    }
    
    public int ZapamtiAntikvitet(Antikvitet a) throws Exception{
        Request request=new Request(a, Operation.ZapamtiAntikvitet);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (int)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public int ObrisiAntikvitet(Antikvitet a) throws Exception{
        Request request=new Request(a, Operation.ObrisiAntikvitet);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
             return (int)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public Antikvitet UcitajAntikvitet(int a) throws Exception{
        Request request=new Request(a, Operation.UcitajAntikvitet);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (Antikvitet)response.getObj();
        }else{
            throw response.getException();
        }
    }
    public List<Antikvitet> UcitajAntikvitete() throws Exception{
        Request request=new Request(null, Operation.UcitajAntikvitete);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Antikvitet>)response.getObj();
        }else{
            throw response.getException();
        }
    }
    public List<Antikvitet> UcitajAntikviteteSaParametrom(Pair p) throws Exception{
        Request request=new Request(p, Operation.UcitajAntikviteteSaParametrom);
        sender.send(request);
        System.out.println("komunikacija.Komunikacija.UcitajAntikviteteSaParametrom(), ceka od servera odgovor za antikvitete sa parametrom");
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Antikvitet>)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    
    public int KreirajAukciju (Aukcija a) throws Exception{
        Request request=new Request(a, Operation.KreirajAuckiju);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
             return (int)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public int ZapamtiAukciju(Aukcija a) throws Exception{
        Request request=new Request(a, Operation.ZapamtiAukciju);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
             return (int)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public int ObrisiAukciju(Aukcija a) throws Exception{
        Request request=new Request(a, Operation.ObrisiAukciju);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
             return (int)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public Aukcija UcitajAukciju(int a) throws Exception{
        Request request=new Request(a, Operation.UcitajAukciju);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (Aukcija)response.getObj();
        }else{
            throw response.getException();
        }
    }
    public List<Aukcija> UcitajAukcije() throws Exception{
        Request request=new Request(null, Operation.UcitajAukcije);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Aukcija>)response.getObj();
        }else{
            throw response.getException();
        }
    }
    public List<Aukcija> UcitajAukcijeSaParametrom(Pair p) throws Exception{
        Request request=new Request(p, Operation.UcitajAukcijeSaParametrom);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Aukcija>)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    
    public Response KreirajVlasnika(Vlasnik a) throws Exception{
        Request request=new Request(a, Operation.KreirajVlasnika);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
             return response;
        }else{
            throw response.getException();
        }
    }
    
    public int ZapamtiVlasnika(Vlasnik a) throws Exception{
        Request request=new Request(a, Operation.ZapamtiVlasnika);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
             return (int)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public int ObrisiVlasnika(Vlasnik a) throws Exception{
        Request request=new Request(a, Operation.ObrisiVlasnika);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
             return (int)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public Vlasnik UcitajVlasnika(int a) throws Exception{
        Request request=new Request(a, Operation.UcitajVlasnika);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (Vlasnik)response.getObj();
        }else{
            throw response.getException();
        }
    }
    public List<Vlasnik> UcitajVlasnike() throws Exception{
        Request request=new Request(null, Operation.UcitajVlasnike);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Vlasnik>)response.getObj();
        }else{
            throw response.getException();
        }
    }
    public List<Vlasnik> UcitajVlasnikeSaParametrom(Pair p) throws Exception{
        Request request=new Request(p, Operation.UcitajVlasnikeSaParametrom);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Vlasnik>)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public Response KreirajProdajaAntikviteta(ProdajaAntikviteta a) throws Exception{
        Request request=new Request(a, Operation.KreirajProdajaAntikviteta);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
             return response;
        }else{
            throw response.getException();
        }
    }
    
    public int ZapamtiProdajaAntikviteta(ProdajaAntikviteta a) throws Exception{
        Request request=new Request(a, Operation.ZapamtiProdajaAntikviteta);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
             return (int)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public int ObrisiProdajaAntikviteta(ProdajaAntikviteta a) throws Exception{
        Request request=new Request(a, Operation.ObrisiProdajaAntikviteta);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
             return (int)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public ProdajaAntikviteta UcitajProdajaAntikviteta(int a) throws Exception{
        Request request=new Request(a, Operation.UcitajProdajaAntikviteta);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (ProdajaAntikviteta)response.getObj();
        }else{
            throw response.getException();
        }
    }
    public List<ProdajaAntikviteta> UcitajSveProdajaAntikviteta() throws Exception{
        Request request=new Request(null, Operation.UcitajProdajaAntikviteta);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<ProdajaAntikviteta>)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public List<ProdajaAntikviteta> UcitajSveProdajaAntikvitetaSaParametrom(Pair p) throws Exception{
        Request request=new Request(p, Operation.UcitajSveProdajaAntikvitetaSaParametrom);
        sender.send(request);
        System.out.println("komunikacija.Komunikacija.UcitajAntikviteteSaParametrom(), ceka od servera odgovor za antikvitete sa parametrom");
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<ProdajaAntikviteta>)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    public List<TipAntikviteta> UcitajListuTipova() throws Exception{
        Request request=new Request(null, Operation.UcitajListuTipova);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<TipAntikviteta>)response.getObj();
        }else{
            throw response.getException();
        }
    }
    public List<Mesto> UcitajListuMesta() throws Exception{
        Request request=new Request(null, Operation.UcitajListuMesta);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Mesto>)response.getObj();
        }else{
            throw response.getException();
        }
    }
    
    
}
