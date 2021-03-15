public class BlaaResept extends Resept {

    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit, int type){
        super(legemiddel, utskrivendeLege, pasientId, reit, type);
    }

    public double prisAaBetale(){
        double fullPris = legemiddel.hentPris(); // 75% rabatt.
        return 0.25*fullPris;
    }
    
    public String farge(){
        return "blaa";
    }

    public void printInfo(){
        System.out.println("Legemiddel: " + this.hentLegemiddel());
        System.out.println("Id: " + this.hentId());
        System.out.println("Lege: " + this.hentLege());
        System.out.println("Pasient ID: " + this.hentPasientId());
        System.out.println("Reit: " + this.hentReit());
        System.out.println("Farge: " + this.farge());

    }
}