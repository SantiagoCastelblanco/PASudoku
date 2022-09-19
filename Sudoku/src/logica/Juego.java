package logica;
import persistencia.*;

public class Juego{

  //Tablero manejara el tablero interno del juego, y asi mismo la logica de victoria y derrota. referencia es para los tableros guardados
  private Tablero tablero;
  private Tablero tableroBase;
  private AlmacenamientoTableros referenciaTableros;

  public Juego(){
    tablero = new Tablero();
    tableroBase = new Tablero();
    referenciaTableros = new AlmacenamientoTableros();
  }

    public void nuevoJuego() {
        referenciaTableros.leerMatriz("Tablero1");
        tableroBase.setTableroJuego(referenciaTableros.obtenerMatriz());
        tablero.setTableroJuego(tableroBase.getTableroJuego());
    }
    
    public int[][] getTableroBase(){
        return tableroBase.getTableroJuego();
    }
}