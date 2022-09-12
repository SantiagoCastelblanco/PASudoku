package logica;
import persistencia.*;

public class Juego{

  //Tablero manejara el tablero interno del juego, y asi mismo la logica de victoria y derrota. referencia es para los tableros guardados
  private Tablero tablero;
  private AlmacenamientoTableros referenciaTableros;

  public Juego(){
    tablero = new Tablero();
    referenciaTableros = new AlmacenamientoTableros();
  }
}