public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{

    public SortertLenkeliste(){
      super();
    }
  

    @Override
    // Legger inn elementer i listen i sortert rekkefolge. (minst til stoerst).
    // Benytter seg av Comparable for aa sammenlikne.
    public void leggTil(T x){
        if(stoerrelse() == 0){
            super.leggTil(x);
        }
        else if (stoerrelse() == 1){

            if(hent(0).compareTo(x) < 0){
                super.leggTil(x);
            }

            else{
                super.leggTil(0, x);
            }
        }
        else{
            for(int i = 0; i < stoerrelse(); i++){

                if(hent(i).compareTo(x) > 0){
                    super.leggTil(i, x);
                    return;
                }
            }
            super.leggTil(x);
        }
    }
  
    @Override
    // Fjerner det stoerste elementet (det bakerste).
    public T fjern(){
        int lengde = this.stoerrelse();
        return fjern(lengde - 1);
    }
  
    @Override
    public void leggTil(int pos, T x){
        throw new UnsupportedOperationException("Dette er ikke lov, da det vil odelegge sorteringen.");
    }
  
    @Override
    public void sett(int pos, T x){
        throw new UnsupportedOperationException("Dette er ikke lov, da det vil odelegge sorteringen.");
    }
}