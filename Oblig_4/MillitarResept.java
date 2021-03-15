public class MillitarResept extends HvitResept{
    public MillitarResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit, int type){
        super(legemiddel, utskrivendeLege, pasientId, reit, type);
    }
    
    public double prisAaBetale(){
        return 0;
    }

    public String farge(){
        return "hvit";
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