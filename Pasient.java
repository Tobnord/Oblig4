public class Pasient{

    private static int IDteller;

    private String foedselsnummer;
    private int ID;
    private String navn;
    Stabel<Resept> reseptliste = new Stabel<Resept>();

    public Pasient(String navn, String foedselsnummer){
        this.foedselsnummer = foedselsnummer;
        this.navn = navn;
        IDteller++;
        ID = IDteller;
    }

    public void nyResept(Resept resept){
        this.reseptliste.leggPaa(resept);
    }

    public int hentID(){
        return this.ID;
    }

    public String hentNavn(){
        return this.navn;
    }

    public String hentFoedlselsnummer(){
        return this.foedselsnummer;
    }

    public Stabel<Resept> hentResepter(){
        return reseptliste;
    }
}