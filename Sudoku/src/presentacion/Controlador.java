package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Estudiantes
 */
public class Controlador implements ActionListener, MouseListener{

    private final Vista ventana;
    private final Modelo modelo;
    private int[] coordenadas;

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
                coordenadas=null;
                return;
            }
            if(boton.equals(ventana.getBtnBorrar())){
                if(coordenadas!=null){
                    modelo.fichaModificada(coordenadas, 0);
                }
                return;
            }
            if (boton.equals(ventana.getBtnReiniciar())){
                modelo.reiniciarJuegoActual();
                return;
            }
            for (int i = 0; i < 10; i++) {
                if(boton.equals(ventana.getBtnNumeros()[i])){
                    if(coordenadas!=null){
                        modelo.fichaModificada(coordenadas,i);
                        return;
                    }
                }
            }
        }
    }

    //Listener de las celdas
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        JLabel celda;
        if(e.getSource() instanceof JLabel){
            celda = (JLabel) e.getSource();
            if(celda.isEnabled()){
                coordenadas = ventana.pressed(celda);
            }
            else{
                coordenadas=null;
            }
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
