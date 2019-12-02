package tateti;

public class MachinePlayer {
    private String name;
    
    public MachinePlayer(String name){
        this.name = name;
    }
         
    public int getFilaMachine(){
        int fila = Auxiliar.numRandomEntre(1, 3);
        return fila;
    }
    public char getColumnaMachine(){
        char columna = (char)Auxiliar.numRandomEntre(97, 99);
        return columna;
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
