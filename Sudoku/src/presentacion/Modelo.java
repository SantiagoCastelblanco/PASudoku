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
        
    }

    public Juego getSudoku() {
        if(sudoku==null){
            sudoku = new Juego();
        }
        return sudoku;
    }
    
}
