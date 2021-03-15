//import java.util.Iterator;

public class Lenkeliste<T> implements Liste<T>{
    public class Node{
        Node neste = null;
        T info;

        // Konstruktor til node
        Node(T x){
            this.info = x;
        }
    }
    public Node foerste = new Node(null);


    public class LenkelisteIterator implements Iterator<T>{
        private Liste<T> liste;
        private int indeks = 0;

        public LenkelisteIterator(Liste<T> listen){
            liste = listen;
        }

        @Override
        public boolean hasNext(){
            return indeks < liste.stoerrelse();
        }


        @Override
        public T next(){
            return liste.hent(indeks++);
        }


        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
            
    }

    @Override //Måtte legges til, gjør ingenting. Lenkeliste måtte implementere iterator
    public Iterator<T> iterator(){
        return null;
    }

    @Override
    // Setter inn elementet i posisjonen ved aa overskrive det som var der.
    public void sett(int pos, T x){
        if (pos < 0 || pos >= this.stoerrelse()){
            throw new UgyldigListeIndeks(pos);
        }

        Node u = foerste;
        
        for (int i = 0; i < pos; i++){
            u = u.neste;
        }

        u.neste.info = x;
    }
  

    @Override
    // Oppretter en ko liste.(foert inn, foerst ut)
    public void leggTil(T x){

        // Sjekker om listen er tom og printer ut
        if (foerste.neste == null){
            foerste.neste = new Node(x);
            System.out.println(foerste.neste.info);
        }
        else{
            Node u = foerste;

            // While lokke som henter siste elementet i lista
            while (u.neste != null){
                u = u.neste;
            }
            u.neste = new Node(x);
        }
    }
  

    @Override
    // Legger et nytt element foran i listen som forskyver resten ved aa oeke posisjonen.
    public void leggTil(int pos, T x){
        if (pos < 0 || pos > this.stoerrelse()){
            throw new UgyldigListeIndeks(pos);
        }

        if (pos == 0){
            Node u = new Node(x);
            u.neste = foerste.neste;
            foerste.neste = u;
        }

        else{
            Node u = foerste;
            for (int i = 0; i < pos; i++){
              u = u.neste;
            }
            Node ny = new Node(x);
            ny.neste = u.neste;
            u.neste = ny;
        }
    }


    @Override
    // Fjerner og returnerer elementet foerst i listen.
    public T fjern(){
        if (foerste.neste == null){
            throw new UgyldigListeIndeks(-1);
        }
        else{
            Node u = foerste.neste;
            foerste.neste = u.neste;
            return u.info;
        }
    }
  

    @Override
    // Fjerner et element etter posisjonen. Elementene etter blir flyttet frem.
    public T fjern(int pos){
        if (pos < 0 || pos >= this.stoerrelse()){
            throw new UgyldigListeIndeks(pos);
        }

        Node u = foerste;
        for (int i = 0; i < pos; i++){
            u = u.neste;
        }

        Node fjernes = u.neste;
        u.neste = fjernes.neste;
        return fjernes.info;
    }
  

    @Override
    // Returnerer antall elementer(eller storrelse om du vil).
    public int stoerrelse(){
        Node u = foerste;
        int s = 0;

        while (u.neste != null){
            s++;
            u = u.neste;
        }

        return s;
    }
  

    @Override
    // throws exeption hvis oppgitt posisjon ikke er innenfor listen.
    // ellers returnerer den informasjon om Node objektet fra den posisjonen.
    public T hent(int pos){
        if (pos >= this.stoerrelse()|| pos < 0){
            throw new UgyldigListeIndeks(pos);
        }

        Node u = foerste.neste;

        for (int i = 0; i < pos; i++){
            u = u.neste;
        }

        return u.info;
    }
}