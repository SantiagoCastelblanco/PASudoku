
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Estudiantes
 */
public class Controlador implements ActionListener{

    private final Vista ventana;
    private final Modelo modelo;

    public Controlador(Vista aThis) {
        ventana = aThis;
        modelo = ventana.getModelo();
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton;
        if(e.getSource() instanceof JButton){
            boton=(JButton)e.getSource();
            if(boton.equals(ventana.getBtnNuevo())){
                modelo.crearNuevoJuego();
            }
        }
    }
}
