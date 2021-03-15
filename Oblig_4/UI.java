public class UI {
    
    public static void main(String[] args) {
        Scanner inputen = new Scanner(system.in);
        System.out.println("Hovedmeny:\n\n"+ 
        "1: Opprett ny lege\n"+ 
        "2: Opprett ny spesialist\n"+
        "3: Opprett ny pasient\n"+
        "4: Opprett ny resept\n"+
        "5: Opprett nytt legemiddel\n"+
        "0: Avslutt programmet");
        String inp = inputen.nextLine("Velg en metode:");
        switch (inp){
            case("1"):
            String legenavn = inputen.nextLine("Skriv inn navnet til legen\n");
            nyLege(legenavn);
            break;

            case("2"):
            String spesialistnavn = inputen.nextLine("Skriv inn navnet til spesialisten\n");
            String spesialistid = inputen.nextLine("Skriv inn kontrollID-en til spesialisten\n");
            nySpesialist(spesialistnavn, spesialistid);
            break;

        }
    }
}


