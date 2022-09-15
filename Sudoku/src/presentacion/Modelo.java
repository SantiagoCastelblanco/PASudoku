
package presentacion;

public class Modelo {
    
    private Vista ventana;
    
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
    
    
    
}
