abstract class Resept {
    static int countID = 0;
    int id;
    Legemiddel legemiddel;
    Lege utskrivendeLege;
    int pasientId;
    int reit;
    int type;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit, int type) {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        this.countID++;
        this.id = countID;
        this.type = type;
    }

    public int hentId(){
        return this.id;
    }

    public String hentLegemiddel(){
        return legemiddel.hentNavn();
    }

    public String hentLege(){
        return utskrivendeLege.hentNavn();
    }

    public int hentPasientId(){
        return pasientId;
    }

    public int hentReit(){
        return reit;
    }

    public boolean bruk(){
        if (reit > 0){
            reit--;
            return true;
        }
        else{
            return false;
        }
    }
    
    abstract public String farge();
    abstract public double prisAaBetale();
}