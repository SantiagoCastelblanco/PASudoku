package persistencia;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sun.security.util.Length;
public class AlmacenamientoTableros{

  private String arreglo[];
  private int matrizLocal[][];

  public AlmacenamientoTableros(){
    arreglo[81] = "";
    matrizLocal[9][9]=0;
  }

  
    public void LeerMatriz(String nombreArchivo){
    try{
        FileReader r = new FileReader(nombreArchivo);
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

  public void traducirMatriz(){
    int posicionArreglo=0;
    for(int i=0;i<matrizLocal.length;i++){
      for(int j=0;j<matrizLocal[i].length;j++){
          matrizLocal[i][j]= Integer.parseInt(arreglo[posicionArreglo++]);
      }
    }
  }
  public int[][] obtenerMatriz(){
    traducirMatriz();
    return matrizLocal;
  }
}

