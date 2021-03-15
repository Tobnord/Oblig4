import java.io.File; // Importerer File klassen.
import java.io.FileNotFoundException; // Importerer denne for aa haandtere error.
import java.util.Scanner; // Importerer denne klassen for aa lese fra filer.
import java.util.ArrayList;


public class testProgram {

    public static void lesFraFil(File fil){
        Scanner scanner = null;

        try{
            scanner = new Scanner(filnavn);
        }

        catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen");
            e.printStackTrace();
            return;
        }


        String innlest = scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] info = innlest.split(" ");

            // Leser inn alle pasienter
            if(info[1].compareTo("Pasienter") == 0){
                while(scanner.hasNextLine()) {
                    innlest = scanner.nextLine();

                    if(innlest.charAt(0) == '#'){
                        break;
                    }

                    String[] paslinje = innlest.split(", ");
                    nyttLegemiddel(paslinje[0], paslinje[1]);
                }

            }


            // Leser inn alle legemidler
            else if (info[1].compareTo("Legemidler") == 0){
                while (scanner.hasNextLine()) {
                    innlest = scanner.nextLine();
                    
                    if (innlest.charAt(0) == "#") {
                        break;
                    }

                    String[] legemiddel = innlest.split(", ");
                    int pris = Integer.parseInt(legemiddel[2]);
                    Double virk = Double.valueOf(legemiddel[3]);
                    int styrke = Integer.parseInt(legemiddel[4]);
                    int type;
                    if (legemiddel[1].toLowerCase() == "vanlig") {
                        type = 1;
                    }
                    else if (legemiddel[1].toLowerCase() == "vanedannende") {
                        type = 2;
                    }
                    else if (legemiddel[1].toLowerCase() == "narkotisk") {
                        type = 3;
                    }
                    else{
                        throw new IllegalArgumentException("Legemiddel må være av typen 1, 2 eller 3.");
                    }
                    nyttLegemiddel(legemiddel[0], pris, virk, type, styrke);
                }
            }


            // Leser inn alle leger
            else if(info[1].compareTo("Leger") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    
                    if(innlest.charAt(0) == '#'){
                        break;
                    }

                    info = innlest.split(", ");

                    int kontrollid = Integer.parseInt(info[1]);

                    // Hvis kontrollID er noe annet enn 0, er legen en spesialist.
                    if(kontrollid == 0){
                        nyLege(info[0]);
                    }
                    else{
                        nySpesialist(info[0], kontrollid);
                    }
                }
            }


            // Leser inn alle resepter
            else if (info[1].compareTo("Resepter") == 0) {
                while (scanner.hasNextLine()) {
                    innlest = scanner.nextLine();
                    info = innlest.split(", ");
                    

                    // Det valgte Legemiddellet
                    int id = Integer.valueOf(info[0]);
                    for(Legemiddel l : legemiddelListe){
                        if(l.hentId() == id){
                            valgtLegemid = l;
                        }
                    }

                    // Den valgte pasienten
                    Pasient valgPasient = null;
                }
            }

        }

    }


    public static void main(String[] args) {
        //Lege lege1 = new Lege("Dr.Anders");
        //Lege lege2 = new Lege("Dr.Bernt");
        //Narkotisk narkotisk1 = new Narkotisk("crack", 100, 50, 8);
        //Pasient pasient1 = new Pasient("Tobias", "150799");
        //Vanedannende vanedannende1 = new Vanedannende("snus", 97, 30.50, 2);


        //System.out.println(lege1.hentNavn().compareTo(lege2.hentNavn()));

        //lege1.skrivMillitaerResept(vanedannende1, pasient1, 3);
        File fil = new File("litenEksempelfil.txt");
        File fil2 = new File("storEksempelfil.txt");
        lesFraFil(fil);
    }
}