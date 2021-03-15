public class Vanlig extends Legemiddel{

    public Vanlig(String navn, int pris, double virkestoff, int type){
        super(navn, pris, virkestoff, type);
    }

    public void printInfo(){
        System.out.println("Navn: " + this.hentNavn());
        System.out.println("Id: " + this.hentId());
        System.out.println("Pris: " + this.hentPris());
        System.out.println("Virkestoff: " + this.hentVirkestoff());
    }
}