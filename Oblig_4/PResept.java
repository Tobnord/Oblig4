public class PResept extends HvitResept{
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int type){
        super(legemiddel, utskrivendeLege, pasientId, 3, type);
    }
    public double prisAaBetale(){
        double fullPris = legemiddel.hentPris(); // 108 kroner avslag.
        if (fullPris <= 108.00){
            return 0;
        }
        else{
            return (fullPris - 116.00);
        }
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