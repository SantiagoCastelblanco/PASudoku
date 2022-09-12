package persistencia;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class AlmacenamientoTableros{

  private int matriz2[][];
  
  public AlmacenamientoTableros(){
    matriz2[9][9]=0;//matriz auxiliar
    int fila=0;
    try{
      //Hacemos lectura del txt
    BufferedReader matriz =newBufferedReader(new FileReader ("Tablero1.txt"));
      String linea = matriz.readLine();
    while (linea != null){
      //separo los caracteres, con los espacios que dejamos en txt
      String [] enteros = linea.split("");
      for ( int i = 0; i< enteros.length; i++){
        matriz2[fila][i] = Integer.parseint(enteros[i]);
        fila ++;
      }Tablero1.close();
        
      
    }
      for (int i = 0; i < longitud; i++) {
				for (int j = 0; j < longitud; j++)
					System.out.print(matriz2[i][j] + " ");
				System.out.println();
			}
      }
    catch(FileNotFoundException e){
      System.out.printIn("No se encontro el archivo");
    }
  }
 
}