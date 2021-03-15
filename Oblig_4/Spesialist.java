public class Spesialist extends Lege implements Godkjenningsfritak{
    String navn;
    String kontrollID;
  
    public Spesialist(String navn, String kontrollID){
        super(navn);
        this.kontrollID = kontrollID;
    }
  
    @Override
    public String hentKontrollID(){
        return this.kontrollID;
    }

    public void printInfo(){
        System.out.println("Navn: " + this.hentNavn());
        System.out.println("KontrollID: " + hentKontrollID());
    }
}