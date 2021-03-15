abstract class Legemiddel {

    static int countID = 0;
    int id;
    String navn;
    int pris;
    double virkestoff; // maalt i milligram (mg)
    int type;

    public Legemiddel(String navn, int pris, double virkestoff, int type){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.countID++;
        this.id = countID;
        this.type = type;
      }

      public int hentId(){
        return this.id;
      }

      public String hentNavn(){
        return this.navn;
      }

      public int hentPris(){
          return this.pris;
      }

      public double hentVirkestoff(){
          return this.virkestoff;
      }

      public void settNyPris(int nyPris){
          this.pris = nyPris;
      }
}
