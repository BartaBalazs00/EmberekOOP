import java.time.LocalDateTime;

public class Ember {

    private String nev;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzulDatum() {
        return szulDatum;
    }

    public void setSzulDatum(String szulDatum) {
        this.szulDatum = szulDatum;
    }

    public String getSzulHely() {
        return szulHely;
    }

    public void setSzulHely(String szulHely) {
        this.szulHely = szulHely;
    }

    private String szulDatum;
    private String szulHely;

    public Ember(String nev, String szulDatum, String szulHely) {
        this.nev = nev;
        this.szulDatum = szulDatum;
        this.szulHely = szulHely;
    }

    public int SzuletesiDatumEv(){
        int evSzam=Integer.parseInt(szulDatum.substring(0,4));
        return evSzam;
    }

    public int SzuletesiDatumHonap(){
        int honapSzam;
        if(szulDatum.charAt(7)=='-'){
            honapSzam=Integer.parseInt(szulDatum.substring(5,7));
        }
        else
        {
            honapSzam=Integer.parseInt(szulDatum.substring(5,6));
        }

        return honapSzam;
    }

    public int SzuletesiDatumNap(){
        int napSzam;
        if(szulDatum.charAt(szulDatum.length()-3)=='-'){
            napSzam=Integer.parseInt(szulDatum.substring(szulDatum.length()-2,szulDatum.length()));
        }else{
            napSzam=Integer.parseInt(szulDatum.substring(szulDatum.length()-1,szulDatum.length()));
        }

        return napSzam;
    }
    public int HanyEvesVagy(){
        LocalDateTime maiDatum = LocalDateTime.now();

        return maiDatum.getYear()-SzuletesiDatumEv();
    }
    @Override
    public String toString() {
        return "nev=" + nev + '\n' +
                "szulDatum=" + szulDatum + '\n' +
                "szulHely=" + szulHely + '\n';
    }
}
