package persistencia;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class AlmacenamientoTableros{
    public void LeerMatriz(String nombreArchivo){
    try{
        FileReader r = new FileReader(nombreArchivo);
        BufferedReader buffer = new BufferedReader(r);
        String temp = " ";
        while (temp!=null){
            temp = buffer.readLine();
            String x;
            x = temp;
            String []arreglo = x.split(" ");
        }if (temp == null){
        System.out.println("Fallo");
        }
  
                
    }catch(Exception e){
                System.out.println("No se encontro el archivo");
    };

    
    }
}

