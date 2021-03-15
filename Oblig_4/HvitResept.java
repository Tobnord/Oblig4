abstract class HvitResept extends Resept{
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit, int type){
        super(legemiddel, utskrivendeLege, pasientId, reit, type);
    }
    public String farge(){
        return "hvit";
    }
}