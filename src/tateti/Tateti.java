package tateti;

class Tateti {
    Tablero tablero = new Tablero();   
    private Jugador jugador;
    private MachinePlayer machine;
    private boolean esMaquina = false;
    
    public Tateti(){
        System.out.println("Bienvenido al Tateti");
        jugador = new Jugador(Auxiliar.readString("Ingrese nombre del jugador: "));
        machine = new MachinePlayer(Auxiliar.readString("Ingrese nombre del oponente: "));
    }
    public void arrancar(){
        tablero.arrancarTablero();
        int rondas = 0;
        while(tablero.espacioVacio() != 0 && hayGanador() != true) {
            rondas += 1;
            System.out.println("Ronda " + rondas + ": ");
            playerPlay();
            hayGanador();
            if(tablero.espacioVacio() != 0){
                machinePlay();
                tablero.mostrarTablero();
            }
        }
        if(hayGanador() ==true){
            ganador();
        }else{
            System.out.println("EMPATE");
        }
    }
    
    private void machinePlay(){
        esMaquina = true;
        boolean vacio;
        int fila = machine.getFilaMachine();
        char columna = machine.getColumnaMachine();
        vacio = tablero.comprobarVacio(fila, columna);
        while(vacio == false){
            fila = machine.getFilaMachine();
            columna = machine.getColumnaMachine();
            vacio = tablero.comprobarVacio(fila, columna);
        }
        tablero.actualizarTablero(fila, columna, esMaquina);
    }
    
    private void playerPlay(){
        esMaquina = false;
        boolean vacio;
        int fila = jugador.getFilaPlayer();
        char columna =  jugador.getColumnaPlayer();
        vacio = tablero.comprobarVacio(fila, columna);
        while( vacio == false){
            System.out.println("Ese lugar no se encuentra vacio.Intentelo de nuevo.");
            fila = jugador.getFilaPlayer();
            columna =  jugador.getColumnaPlayer();
            vacio = tablero.comprobarVacio(fila, columna);
        }
        tablero.actualizarTablero(fila, columna, esMaquina);
    }
    private void ganador(){
        if(tablero.ganador('x')==true){
            System.out.println(jugador.toString().toUpperCase() + " ERES EL GANADOR.");
        }
        if(tablero.ganador('o')==true){
            System.out.println(machine.toString().toUpperCase() + " ES EL GANADOR.");
        }
    }
    
    private boolean hayGanador(){
        if(tablero.ganador('x')==true || tablero.ganador('o')==true){
            return true;
        }else{
            return false;
        }
    }
}
