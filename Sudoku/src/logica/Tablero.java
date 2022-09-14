package logica;

import persistencia.*;
public class Tablero{

  private int tableroJuego[][];

  //Maneja el rango maximo del tablero del sudoku
  private static int BOARD_RANGE =9;

  public void Tablero(){
    tableroJuego[9][9]=0;
  }

  //Metodo para tener menos error en caso de cometer error
  public boolean estaCompletado(){
    //Iteracion por todo el tablero
    for(int i= 0; i<BOARD_RANGE;i++){
      for(int j=0;j<BOARD_RANGE;j++){
        
      }
    }
    return false;
  }

  /*El entero a devolver dependera de la validez del mismo tablero
  0 si el tablero está incompleto
*/
  public int sudokuValido(){
    return 0;
  }

  public void setTableroJuego(int tableroEntrada[][]){
    this.tableroJuego = tableroEntrada;
  }

  public int[][] getTableroJuego(){
    return this.tableroJuego;
  }
}
