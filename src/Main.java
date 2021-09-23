import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Ember e1=new Ember("Kovács Attila","1983-12-6","Gödöllő");
        Ember e2=new Ember("Sárosi Roland","1973-1-1","Budapest");
        Ember e3=new Ember("Kalánczki Gábor","1975-4-21","Budapest");

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        System.out.println(e1.SzuletesiDatumEv()+" "+e2.SzuletesiDatumEv()+" "+e3.SzuletesiDatumEv() );
        System.out.println(e1.SzuletesiDatumHonap()+" "+e2.SzuletesiDatumHonap()+" "+e3.SzuletesiDatumHonap());
        System.out.println(e1.SzuletesiDatumNap()+" "+e2.SzuletesiDatumNap()+" "+e3.SzuletesiDatumNap());

        System.out.println(e1.HanyEvesVagy());

        Ember e4=new Ember("Iharos Katalin","1965-4-8","Debrecen");
        Ember e5=new Ember("Mészáros Csaba","1986-2-18","Szeged");

        Ember[] emberekTomb = new Ember[5];
        emberekTomb[0]=e1;
        emberekTomb[1]=e2;
        emberekTomb[2]=e3;
        emberekTomb[3]=e4;
        emberekTomb[4]=e5;

        Emberek emberek = new Emberek(emberekTomb);
        System.out.println(emberek.toString());

        System.out.println("Ebben a hónapban ennyi Ember született: "+emberek.AdottHonapbanSzulettek(4));
        System.out.println("Az atlag életkor:"+emberek.AtlagosEletkor());
        System.out.println("A legfiatalabb Ember neve:  "+emberek.LegfiatalabbEmberNeve());
        System.out.println("A legidősebb ember sorszáma: "+emberek.LegidosebbEmberSorszama());


        Emberek emberek2 = new Emberek("emberek.txt");
        System.out.println(emberek2.toString());


    }

}
