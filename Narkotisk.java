public class Narkotisk extends Legemiddel{

    int styrke;
    
    public Narkotisk(String navn, int pris, double virkestoff, int styrke, int type){
        super(navn, pris, virkestoff, type);
        this.styrke = styrke;
    }

    public int hentNarkotiskStyrke(){
        return this.styrke;
    }

    public void printInfo(){
        System.out.println("Navn: " + this.hentNavn());
        System.out.println("Id: " + this.hentId());
        System.out.println("Pris: " + this.hentPris());
        System.out.println("Virkestoff: " + this.hentVirkestoff());
        System.out.println("Narkotisk styrke: " + this.hentNarkotiskStyrke());
    }
}