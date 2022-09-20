package presentacion;
import logica.*;

public class Modelo {
    
    private Vista ventana;
    private Juego sudoku;
    
    public void iniciar(){
        getVentana().setSize(710, 730);
        getVentana().setVisible(true);
    }

    public Vista getVentana() {
        if(ventana == null){
            ventana = new Vista(this);
        }
        return ventana;
    }

    public void crearNuevoJuego() {
        if(sudoku ==null){
            sudoku = new Juego();
        }
        sudoku.nuevoJuego();
        ventana.nuevoTableroJuego(sudoku.getTableroBase());
    }
    
    void reiniciarJuegoActual() {
        if (sudoku != null) {
            sudoku.reiniciarJuego();
            ventana.nuevoTableroJuego(sudoku.getTableroBase());
        }
    }

    public Juego getSudoku() {
        if(sudoku==null){
            sudoku = new Juego();
        }
        return sudoku;
    }

    void fichaModificada(int[] coordenadas, int numero) {
        if(sudoku != null){
            sudoku.fichaCambiada(coordenadas[0],coordenadas[1],numero);
            ventana.actualizarTablero(sudoku.getTablero());
            if(sudoku.tableroCorrecto()){
                ventana.mostrarVictoria();
            }
        }
    }
}
