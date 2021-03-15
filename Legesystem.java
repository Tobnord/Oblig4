

class Legesystem{

    static Lenkeliste<Lege> legeListe = new Lenkeliste<Lege>();
    static Lenkeliste<Pasient> pasientListe = new Lenkeliste<Pasient>();
    static Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
    static Lenkeliste<Resept> reseptListe = new Lenkeliste<Resept>();
    static Lenkeliste<Spesialist> spesialistListe = new Lenkeliste<Spesialist>();

    public Legesystem(){
        //Må starte en while-løkke for brukeren
    }

    public static void nyLege(String legenavn){
        for (int i = 0; i >= legeListe.stoerrelse(); i++){
            if (legeListe.hent(i).hentNavn().toLowerCase().equals(legenavn.toLowerCase())){
                System.out.println("Denne legen finnes allerede.");
            }
        else{
            Lege legen = new Lege (legenavn);
            legeListe.leggTil(legen);
            System.out.println("Ny lege opprettet, ved navn:"+legenavn);
        }
    }
    }

    public static void nySpesialist(String legenavn, String kontrollID){
        for (int i = 0; i >= legeListe.stoerrelse(); i++){
            if (spesialistListe.hent(i).hentNavn().toLowerCase().equals(legenavn.toLowerCase())){
                System.out.println("Denne spesialisten finnes allerede.");
            }
        else{
            Spesialist spesialisten = new Spesialist(legenavn, kontrollID);
            spesialistListe.leggTil(spesialisten);
            System.out.println("Ny spesialist opprettet, ved navn:"+legenavn);
        }
    }
    }

    public static void nyPasient(String navn, String foedselsnummer){
        for (int i = 0; i >= pasientListe.stoerrelse(); i++){
            if (pasientListe.hent(i).hentFoedlselsnummer().equals(foedselsnummer)){
                System.out.println("Denne pasienten finnes allerede.");
            }
        else{
            Pasient pasienten = new Pasient (navn, foedselsnummer);
            pasientListe.leggTil(pasienten);
        }
    }
    }

    public static void nyResept(Legemiddel legemiddel, Lege lege, int pasientID, int reit, int type) throws UlovligUtskrift{
            Resept resepten;
            if (type == 1){
                MillitarResept militar = new MillitarResept(legemiddel, lege, pasientID, reit, type);
                resepten = militar;
                }
            if (type == 2){
                PResept presept = new PResept(legemiddel, lege, pasientID, type);
                resepten = presept;
                }
            if (type == 3){
                BlaaResept blaaresept = new BlaaResept(legemiddel, lege, pasientID, reit, type);
                resepten = blaaresept;
                }
            else{
                throw new IllegalArgumentException("Resepten må være av typen 1, 2 eller 3.");
            }
            String legen = resepten.hentLege();
            String legemiddelet = resepten.hentLegemiddel();
            int pasientIDen = resepten.hentPasientId();
            for (int i = 0; i >= reseptListe.stoerrelse(); i++){
                 Resept denneResepten = reseptListe.hent(i);
                if (!((denneResepten.hentLegemiddel().equals(legemiddelet))&&(denneResepten.hentPasientId()==(pasientIDen)))){
                switch (type){
                    case(1):
                        lege.skrivMillitaerResept(legemiddel, pasientID, reit, type);
                        break;
                    case(2):
                        lege.skrivPResept(legemiddel, pasientID, reit, type);
                        break;
                    case(3):
                        lege.skrivBlaaResept(legemiddel, pasientID, reit, type);
                        break;
                }
                reseptListe.leggTil(resepten);
                
            }
        }
    }


    public static void nyttLegemiddel(String navn, int pris, double virkestoff, int type, int styrke){
        for (int i = 0; i >= legemiddelListe.stoerrelse(); i++){
            if (legemiddelListe.hent(i).hentNavn().toLowerCase().equals(navn.toLowerCase())){
                System.out.println("Denne pasienten finnes allerede.");
            }
        else{
            if (type == 1){
                Vanlig vanlig = new Vanlig(navn, pris, virkestoff, type);
                legemiddelListe.leggTil(vanlig);
                }
            if (type == 2){
                Vanedannende vanedanner = new Vanedannende(navn, pris, virkestoff, type, styrke);
                legemiddelListe.leggTil(vanedanner);
                }
            if (type == 3){
                Narkotisk nark = new Narkotisk(navn, pris, virkestoff, type, styrke);
                legemiddelListe.leggTil(nark);
                }
            else{
                throw new IllegalArgumentException("Legemiddel må være av typen 1, 2 eller 3.");
            }
        }
    }
    }

    public void skrivUtAlt(){
        System.out.println("Statistikk\n");
        System.out.println("Liste over leger:"+ legeListe.toString()+ "\n");
        System.out.println("Liste over spesialister:"+ spesialistListe.toString()+ "\n");
        System.out.println("Liste over pasienter:"+ pasientListe.toString()+ "\n");
        System.out.println("Liste over legemidler:"+ legemiddelListe.toString()+ "\n");
        System.out.println("Liste over resepter:"+ reseptListe.toString()+ "\n");
    }





}
