package persistencia;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class AlmacenamientoTableros{

  private String arreglo[];
  private int matrizLocal[][];
  private static String TABLEROS_PATH = "/persistencia/tableros";

  public AlmacenamientoTableros(){
    arreglo = new String[81];
    matrizLocal= new int[9][9];
    
  }
  //Metodo dedicado a obtener el string de los archivos presentes
  public String obtenerRutaArchvio(){
    String str ="";
    int cantidadTableros;
    
    String array[]=new File(getClass().getResource(TABLEROS_PATH).getPath()).list();
    cantidadTableros = new File(getClass().getResource(TABLEROS_PATH).getPath()).list().length;
    int intRandom = ThreadLocalRandom.current().nextInt(1,cantidadTableros+1);
    str = "/"+array[intRandom-1];
    return str;
  }

    //Metodo dedicado a la lectura del archivo y guardado en la lista
    public void leerMatriz(){
    try{
        FileReader r = new FileReader(getClass().getResource(TABLEROS_PATH+obtenerRutaArchvio()).getFile());
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

