package logica;

import java.util.*;
import persistencia.*;
public class Tablero{

  private int tableroJuego[][];

  //Maneja el rango maximo del tablero del sudoku
  private static int BOARD_RANGE =9;

  public void Tablero(){
    tableroJuego[9][9]=0;
  }

  //Metodo para tener menos error en caso de cometer error
  public boolean estaCorrecto(){
    
    //Valor unico de 1 a N
    //Iteracion por todo el tablero
    boolean[] unico = new boolean[BOARD_RANGE+1];
    
    //Recorre cada renglon del tablero
    for(int i= 0; i<BOARD_RANGE;i++){
        //Valor en 0
        Arrays.fill(unico,false);
        //recorre cada columna del renglon
      for(int j=0;j<BOARD_RANGE;j++){
          //Guarda el valor de tablero[i][j]
          int Z= tableroJuego[i][j];
          
          //Comprueba si se mantiene un valor duplicado
          if(unico[Z]){
              return false;
          }
          unico[Z]=true;
      }
    }
    //Atraviesa cada columna del tablero
    for(int i=0;i<BOARD_RANGE;i++){
        //Limpia el valor de unico
        Arrays.fill(unico, false);
        
        //Atraviesa cada renglon de la columna
        for(int j =0;j<BOARD_RANGE;j++){
            
            //Guarda el valor del tablero[j][i]
            int Z= tableroJuego[j][i];
            if(unico[Z]){
                return false;
            }
            unico[Z]=true;
        }
    }
    
    //Ahora es necesario atravezar cada bloque 3.3 en el tablero
    for(int i=0;i<BOARD_RANGE-2;i+=3){
        
        //j guarda la primera columna de cada bloque 3*3
        for(int j=0;j<BOARD_RANGE-2;j+=3){
            
            //Inciailiza el valor unico a falso
            Arrays.fill(unico,false);
            
            //Atraviesa cada bloque
            for(int k=0;k<3;k++){
                for (int l=0;l<3;l++){
                //Guardado de cada valor de columna y fila
                int X= i+k;
                int Y=j+l;
                
                //guardado del valor de tablero[X][Y]
             
                int Z = tableroJuego[X][Y];
                //Revisa si hay duplicado
                
                if(unico[Z]){
                    return false;
                }
                unico[Z]=true;
            }
        }
           
    }
    
  }
    return true;
  }

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
