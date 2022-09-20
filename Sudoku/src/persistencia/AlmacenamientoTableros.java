

package persistencia;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AlmacenamientoTableros{

  private String arreglo[];
  private int matrizLocal[][];

  public AlmacenamientoTableros(){
    arreglo = new String[81];
    matrizLocal= new int[9][9];
  }

    //Metodo dedicado a la lectura del archivo y guardado en la lista
    public void leerMatriz(){
    try{
        FileReader r = new FileReader(getClass().getResource("/persistencia/Tablero1.txt").getFile());
        BufferedReader buffer = new BufferedReader(r);
        String temp = " ";
        while (temp!=null){
            temp = buffer.readLine();
            arreglo = temp.split(" ");
        }if (temp == null){
        System.out.println("Fallo");
        }
  
                
    }catch(Exception e){
                System.out.println("No se encontro el archivo");
    };   
    }

  //Traduce el arreglo en una matriz 2x2
  public void traducirMatriz(){
    int posicionArreglo=0;
    for(int c=0;c<matrizLocal.length;c++){
      for(int f=0;f<matrizLocal[c].length;f++){
          if(arreglo[posicionArreglo]!=null){
              matrizLocal[f][c]= Integer.parseInt(arreglo[posicionArreglo]);
          }
          else{
              matrizLocal[f][c]=0;
          }
          posicionArreglo++;
      }
    }
  }
  public int[][] obtenerMatriz(){
    traducirMatriz();
    return matrizLocal;
  }
}

