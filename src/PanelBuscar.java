
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class PanelBuscar extends javax.swing.JPanel 
{

    public PanelBuscar() throws SQLException, ClassNotFoundException 
    {
        this.initComponents();
        this.paintScroll();
        this.setBackground(Color.WHITE);
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() 
    {      
        setLayout(null);
    }                        
    public void paintScroll() throws SQLException, ClassNotFoundException
    {
        int x = 0;
        int y = 0;
        panel = new JPanel();
        panel.setBounds(50, 30, 451, 400);
        
        panel.setLayout(null);
        
        Conexion.obtenerConexion();
        ArrayList<Evento> data = Conexion.SelectAll();
        int i = 0;
        for (Evento awt: data) 
        {
            PanelSeleccion2 f = new PanelSeleccion2();
            
            panel.add(f);
            //f.setBackground(Color.RED);
            f.setBounds(x,y,451,100);
            f.txtId.setText(String.valueOf(awt.getId()));
            f.txtNombre.setText(awt.getNombre());
            f.txtFecha.setText(awt.getFecha());
            f.txtLugar.setText(awt.getLugar());
            f.txtTipo.setText(awt.getTipo());
            f.txtDescripcion.setText(awt.getDescripcion());
            
            
            
            f.setMinimumSize(new Dimension(451,140));
            f.setMaximumSize(new Dimension(451,140));
            f.setSize(new Dimension(451,140));
            f.setName("Panel " + i);
            y+= 140;
            panel.setPreferredSize(new Dimension(451,y));
            i++;
        }
        scrollPane = new JScrollPane(panel);
        
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        this.add(scrollPane);
        scrollPane.setBounds(30, 40, 460, 300);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
    }
    
            
    public JScrollPane scrollPane;
    public static JPanel panel;
    public static String seleccionado;
    // Variables declaration - do not modify                     
    
    // End of variables declaration                   
}
