package model2;


public class Cocina {
    private Orden ordenRecibida[] = new Orden[5];
    private Orden ordenFinalizada[] = new Orden[5];


    public Cocina(Orden ordenRecibida[]){
        this.ordenRecibida = ordenRecibida;
    }

    public int ordenVacia(){
        for(int i = 0; i<this.ordenRecibida.length; i++){
            if(this.ordenRecibida[i]== null){
                return i;
            }
        }
        return -1;
    }

    public void setOrdenRecibida(Orden orden){
        int posicion = ordenVacia();
        if(posicion != -1){
            this.ordenRecibida[posicion] = orden;
        }
    }

    public Orden[] getOrdenRecibidad(){
        return this.ordenRecibida;
    }

    public void setOrdenFinalizada(int numeroOrden){
        this.ordenRecibida[numeroOrden] = null;
    }

    public Orden[] getOrdenFinalizada(){
        return this.ordenFinalizada;
    }


}