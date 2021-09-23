import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Emberek {

    private List<Ember> emberekLista;

    public Emberek(Ember[] tomb){
        this.emberekLista = new ArrayList<>();
        this.emberekLista.addAll(Arrays.asList(tomb));
        /*
        for (Ember ember:
             tomb) {
            emberekLista.add(ember);
        }
        */
    }

    public Emberek(String fajlNev){
        this.emberekLista = new ArrayList<>();
        try {
            FileReader fr=new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            String sor=br.readLine();
            while (sor != null){

                String[] adatok = sor.split(";");
                String nev=adatok[0];
                String szulDatum=adatok[1];
                String szulHely=adatok[2];
                Ember e = new Ember(nev, szulDatum,szulHely);
                emberekLista.add(e);
                System.out.println(e);
                sor= br.readLine();
            }

        }catch (IOException ie){
            System.out.println(ie);
        }
    }

    public int AdottHonapbanSzulettek(int adottHonap){
        int darab = 0;
        for (Ember ember:
             emberekLista) {
            if(ember.SzuletesiDatumHonap()==adottHonap){
                darab++;
            }
        }
        return darab;
    }
    public int AtlagosEletkor(){
        double osszesEletkor=0;
        for (Ember ember:
             emberekLista) {
           osszesEletkor+=ember.HanyEvesVagy();
        }
        return (int)Math.round(osszesEletkor/emberekLista.size());
    }

    public String LegfiatalabbEmberNeve(){
        int legfiatalabb=emberekLista.get(0).HanyEvesVagy();
        int index=0;

        for (int i = 0; i < emberekLista.size(); i++) {
            if(emberekLista.get(i).HanyEvesVagy()<legfiatalabb){
                legfiatalabb=emberekLista.get(i).HanyEvesVagy();
                index = i;
            }
        }
        return  emberekLista.get(index).getNev();
    }

    public int LegidosebbEmberSorszama(){
        int legidosebb=emberekLista.get(0).HanyEvesVagy();
        int index=0;

        for (int i = 0; i < emberekLista.size(); i++) {
            if(emberekLista.get(i).HanyEvesVagy()>legidosebb){
                legidosebb=emberekLista.get(i).HanyEvesVagy();
                index = i;
            }
        }
        //attól függ hogyan szeretnénk a sorszámát Ha nullától akkor nem kell a pluzssz 1
        return  index+1;
    }

    @Override
    public String toString() {
        String szoveg="";
        for (Ember ember:
             this.emberekLista) {
            szoveg += ember+"\n";
        }
        return szoveg;
    }
}
