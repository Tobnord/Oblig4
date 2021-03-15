public class Lege implements Comparable<Lege>{
    String navn;
    static int antNark;
    Lenkeliste<Resept> utskrevneResepter = new Lenkeliste<Resept>();
  
    public Lege(String navn){
        this.navn = navn;
    }
    
    public String hentNavn(){
        return navn;
    }

    public void printInfo(){
        System.out.println("Navn: " + this.hentNavn());
    }

    @Override
    public int compareTo(Lege legen){
        int nyLege;
        nyLege = (this.navn.compareTo(legen.hentNavn()));
        return nyLege; 
    }

    public Lenkeliste<Resept> hentUtResepter(){
        return (this.utskrevneResepter);
    }

    public void leggTilResept(Resept resept){
        this.utskrevneResepter.leggTil(resept);
    }

    // Hvite resepter er abstrakte, og implementeres av PResept og MilitarResept. Derfor implementerer vi ikke denne klassen.
    // public HvitResept skrivHvitResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{}


    public MillitarResept skrivMillitaerResept(Legemiddel legemiddel, int pasientID, int reit, int type) throws UlovligUtskrift{
        MillitarResept millitarResept;
        if (legemiddel instanceof Narkotisk){
            antNark++;
            throw new UlovligUtskrift(this, legemiddel);
        }
        else{
            millitarResept = new MillitarResept(legemiddel, this, pasientID, reit, type);
            leggTilResept(millitarResept);
            
        }
        return millitarResept;
    }

    public PResept skrivPResept (Legemiddel legemiddel, int pasientID, int reit, int type) throws UlovligUtskrift{
        PResept presept;
        if (legemiddel instanceof Narkotisk){
            antNark++;
            throw new UlovligUtskrift(this, legemiddel);
        }
        else{
            presept = new PResept(legemiddel, this, pasientID, type);
            leggTilResept(presept);
            
        }
        return presept;
    }

    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, int pasientID, int reit, int type) throws UlovligUtskrift{
        BlaaResept blaaresept;
        if (legemiddel instanceof Narkotisk){
            antNark++;
            throw new UlovligUtskrift(this, legemiddel);
        }
        else{
            blaaresept = new BlaaResept(legemiddel, this, pasientID, reit, type);
            leggTilResept(blaaresept);
            
        }
        return blaaresept;
    }
}

    