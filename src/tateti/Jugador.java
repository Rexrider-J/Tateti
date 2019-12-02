package tateti;

public class Jugador {
    private String name;
    
    public Jugador(String name){
        this.name = name;
    }

    public int getFilaPlayer(){
        int fila = Auxiliar.readPositiveWholeBetween("Ingrese número de fila: ", 1, 3);
        return fila;
    }
    
    public char getColumnaPlayer(){
        char columna = Auxiliar.readChar("Ingrese letra de la columna: ");
        return columna;
    }
    
    @Override
    public String toString() {
        return "" + name;
    }
    
}
