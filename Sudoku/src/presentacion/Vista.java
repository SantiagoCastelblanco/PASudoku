
package presentacion;

// Librerias que se utilizaran para la interfaz
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Vista extends javax.swing.JFrame {
    
    private final Modelo modelo;
    private Controlador control;
    private ArrayList<JLabel> listaLblAux;

    // Se declara las componentes del jframe
    public Vista(Modelo aThis) {
        modelo = aThis;
        initComponents();
        crearEtiquetasTablero();// Metodos para crear el tablero del sudoku
        creatBotonesNumericos();
        this.setLocationRelativeTo(null);// Hace que la ventana salgo en medio de la pantalla
        asignarEventos();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelBotonNum = new javax.swing.JPanel();
        pnlBotonAccion = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        pnlCeldas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelJuego.setBackground(new java.awt.Color(204, 204, 255));
        panelJuego.setPreferredSize(new java.awt.Dimension(700, 690));
        panelJuego.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lblTitulo.setText("SUDOKU");
        panelJuego.add(lblTitulo);
        lblTitulo.setBounds(280, 20, 200, 40);

        panelBotonNum.setLayout(null);
        panelJuego.add(panelBotonNum);
        panelBotonNum.setBounds(10, 570, 490, 110);

        pnlBotonAccion.setLayout(null);

        btnNuevo.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        btnNuevo.setText("Nuevo");
        pnlBotonAccion.add(btnNuevo);
        btnNuevo.setBounds(6, 25, 168, 46);

        btnReiniciar.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        pnlBotonAccion.add(btnReiniciar);
        btnReiniciar.setBounds(6, 89, 168, 46);

        btnBorrar.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        btnBorrar.setText("Borrar");
        pnlBotonAccion.add(btnBorrar);
        btnBorrar.setBounds(6, 153, 168, 46);

        panelJuego.add(pnlBotonAccion);
        pnlBotonAccion.setBounds(510, 80, 180, 590);

        pnlCeldas.setBackground(new java.awt.Color(102, 102, 255));
        pnlCeldas.setLayout(null);
        panelJuego.add(pnlCeldas);
        pnlCeldas.setBounds(10, 80, 490, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotonNum;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel pnlBotonAccion;
    private javax.swing.JPanel pnlCeldas;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel lblCeldas[][];
    private javax.swing.JButton btnNumeros[];
    
    private void asignarEventos() {
        btnNuevo.addActionListener(getControl());
        btnBorrar.addActionListener(getControl());
        btnReiniciar.addActionListener(getControl());
        
    }

    //Metodo para crear las etiquetas del tablero(casillas 9x9)
    private void crearEtiquetasTablero() {
        lblCeldas = new JLabel[9][9];
        listaLblAux = new ArrayList<>();
        
         int x = 9;
         int y = 9;
         int n = 0;
         int dimension=50;
         
        //Columna - Y
        for (int c = 0; c < 9; c++) {
            //Filas - X
            for (int f = 0; f < 9; f++) {
                lblCeldas[f][c] = new JLabel();
                pnlCeldas.add(lblCeldas[f][c]);
                lblCeldas[f][c].setBounds(x, y, dimension, dimension);
                lblCeldas[f][c].setBackground(new java.awt.Color(242, 242, 242));
                lblCeldas[f][c].setForeground(new java.awt.Color(0, 0, 0));
                lblCeldas[f][c].setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
                lblCeldas[f][c].setOpaque(true);
                lblCeldas[f][c].setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblCeldas[f][c].setBorder(BorderFactory.createLineBorder(new Color(102,102,255), 1));
                lblCeldas[f][c].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);        
                x += dimension;
                
                lblCeldas[f][c].setToolTipText("");
                if((f+1)%3 == 0){
                    x += 9;
                }
                asignarEventoCelda(lblCeldas[f][c]);
            }
            x = 9;
            y += dimension;
            if((c+1)%3 == 0){
                    y += 10;
            }
        }
    } 
    private void creatBotonesNumericos() {
        btnNumeros = new JButton[10];
        int x = 100;
        int y = 5;
        int dimension = 50;
        int ubicacionArreglo = 0;
        for (int c = 0; c < 2; c++) {
            for (int f = 0; f < 5; f++) {
                if(ubicacionArreglo==0){
                    ubicacionArreglo++;
                    continue;
                }
                btnNumeros[ubicacionArreglo] = new JButton();
                panelBotonNum.add(btnNumeros[ubicacionArreglo]);
                btnNumeros[ubicacionArreglo].setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
                btnNumeros[ubicacionArreglo].setText(String.valueOf(ubicacionArreglo));
                btnNumeros[ubicacionArreglo].setBounds(x,y,dimension,dimension);
                x+=dimension+20;
                asignarEventoBtnNumerico(btnNumeros[ubicacionArreglo]);
                ubicacionArreglo++;
            }
            x=70;
            y+=dimension+2;
        }
    }
    public void asignarEventoCelda(JLabel Celdas){
        Celdas.addMouseListener(getControl());
    }

    // Metodo para cambiar de color la casilla que se selecione
    public int[] pressed(JLabel Celdas){
        int retorno[] = new int[2];
        for(JLabel jLbl : listaLblAux){
            jLbl.setBackground(new java.awt.Color(242, 242, 242));
            jLbl.setForeground(new java.awt.Color(0, 0, 0));
            jLbl.setBorder(BorderFactory.createLineBorder(new Color(102,102,255), 1));
        }
        listaLblAux.clear();
        
        for (int f = 0; f < 9; f++) {
            for (int c = 0; c < 9; c++) {
                if(lblCeldas[f][c] == Celdas){
                    listaLblAux.add(lblCeldas[f][c]);
                    lblCeldas[f][c].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    lblCeldas[f][c].setBackground(Color.BLUE);
                    lblCeldas[f][c].setForeground(Color.WHITE);
                    retorno[0]=f;
                    retorno[1]=c;
                }
            }
        }
        return retorno;
    }

    public void nuevoTableroJuego(int[][] tableroBase) {
        for(int c=0;c<9;c++){
            for(int f=0;f<9;f++){
                int celdaActual = tableroBase[f][c];
                if(celdaActual!=0){
                    lblCeldas[f][c].setText(String.valueOf(celdaActual));
                    lblCeldas[f][c].setEnabled(false);
                }
                else{
                    lblCeldas[f][c].setEnabled(true);
                    lblCeldas[f][c].setText("");
                }
            }
        }
    }

    private void asignarEventoBtnNumerico(JButton btnNumero) {
        btnNumero.addActionListener(getControl());
    }

    public JButton[] getBtnNumeros() {
        return btnNumeros;
    }

    void actualizarTablero(int[][] tablero) {
        for (int c = 0; c < 9; c++) {
            for (int f = 0; f < 9; f++) {
                int celdaActual = tablero[f][c];
                if(celdaActual!=0){
                    lblCeldas[f][c].setText(String.valueOf(celdaActual));
                }
                else{
                    lblCeldas[f][c].setText("");
                }
            }
        }
    }

    void mostrarVictoria() {
        JOptionPane.showMessageDialog(null, "Felicidades, ganaste");
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public JButton getBtnReiniciar() {
        return btnReiniciar;
    }
    
        public Controlador getControl() {
        if (control == null) {
            control = new Controlador(this);
        }
        return control;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public Modelo getModelo() {
        return modelo;
    }
}
