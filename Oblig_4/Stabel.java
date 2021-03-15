public class Stabel<T> extends Lenkeliste<T>{

    // Konstruktor til Stabel
    public Stabel(){
        super();
    }


    // Legger til elementet paa slutten av listen.
    public void leggPaa(T x){
        super.leggTil(x);
    }


    // Tar av elementet paa slutten av listen
    public T taAv(){
        T nodeInfo = super.fjern(super.stoerrelse() - 1);

        return nodeInfo;
    }
}