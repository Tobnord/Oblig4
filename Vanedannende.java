public class Vanedannende extends Legemiddel{
    int styrke;

    public Vanedannende(String navn, int pris, double virkestoff, int type, int styrke){
        super(navn, pris, virkestoff, type);
        this.styrke = styrke;
    }

    public int hentVanedannendeStyrke(){
        return this.styrke;
    }

    public void printInfo(){
        System.out.println("Navn: " + this.hentNavn());
        System.out.println("Id: " + this.hentId());
        System.out.println("Pris: " + this.hentPris());
        System.out.println("Virkestoff: " + this.hentVirkestoff());
        System.out.println("Vanedannende styrke: " + this.hentVanedannendeStyrke());
    }
}
