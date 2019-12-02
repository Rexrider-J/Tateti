package tateti;

class Tablero {
    private char tablero[][];
    private int columnas;
    private int filas;
    
    public Tablero(){
        this.filas = 3;
        this.columnas = 3;
        tablero = new char [filas][columnas];
    }
    public void arrancarTablero(){
        generarTablero();
        mostrarTablero();
    }
    
    private void generarTablero(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.tablero[i][j] = '.';
            }
        }
    }
    
    public void mostrarTablero(){
        System.out.print("     ");
        for (int i = 0; i < columnas; i++) { 
            System.out.print("  " + (char)(i+97) + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < this.tablero.length; i++) {
            System.out.printf("%2d   ", i+1);    
        //lo primero que se imprime en la línea es el número
        //System.out.printf permite imprimir una cadena con formato
        //%2d significa que se imprimirá un número de dos dígitos
        //si solo tiene un dígito, se imprimen espacios en blanco a la izquierda
        //los demás argumentos del método son los elementos que se
        //imprimirán en las posiciones de %<algo>
        //en este caso, (i+1) resulta en 1, 2, 3 ...
            for (int j = 0; j < this.tablero.length; j++) {
                System.out.print("| " + this.tablero[i][j] + " ");
            }
            System.out.print("|");
            System.out.println("\n");
        }
    }
    
    public void actualizarTablero(int fila, char columna, boolean esMaquina){
        int posicionColumna = (int)columna - 97;
        int posicionFila = fila -1;
        if (esMaquina == false){
            tablero[posicionFila][posicionColumna] = 'x';
        }else{
            tablero[posicionFila][posicionColumna] = 'o';
        }
    }
    
    public int espacioVacio(){
        int vacios = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (this.tablero[i][j] == '.'){
                    vacios += 1;
                }
            }
        }
        return vacios;
    }
    
    public boolean comprobarVacio(int fila,char columna){ //si esta vacio true, si no false
        int posicionColumna = (int)columna - 97;
        int posicionFila = fila -1;
        if (tablero[posicionFila][posicionColumna] == '.'){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean ganador (char jugador){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if(tablero[0][0] == jugador && tablero[1][0] == jugador && tablero[2][0] == jugador){
                    return true;
                }
                if(tablero[0][1] == jugador && tablero[1][1] == jugador && tablero[2][1] == jugador){
                    return true;
                }
                if(tablero[0][2] == jugador && tablero[1][2] == jugador && tablero[2][2] == jugador){
                    return true;
                }
                if(tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador){
                    return true;
                }
                if(tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador){
                    return true;
                }
                if(tablero[0][0] == jugador && tablero[0][1] == jugador && tablero[0][2] == jugador){
                    return true;
                }
                if(tablero[1][0] == jugador && tablero[1][1] == jugador && tablero[1][2] == jugador){
                    return true;
                }
                if(tablero[2][0] == jugador && tablero[2][1] == jugador && tablero[2][2] == jugador){
                    return true;
                }
            }
        }
        return false;
    }
}
