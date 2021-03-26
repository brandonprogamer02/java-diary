
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class PanelSeleccion extends javax.swing.JPanel 
{

    public PanelSeleccion(String modo) throws SQLException, ClassNotFoundException 
    {
        if(modo.equals("editar"))
        {
            this.initComponents();
            this.paintScroll();
            this.setBackground(Color.WHITE);
            this.btnEditar.addActionListener(new EventoEditar());
        }
        else if(modo.equals("borrar"))
        {
            this.initComponents();
            this.paintScroll();
            this.setBackground(Color.WHITE);
            this.btnEditar.addActionListener(new EventoBorrar());
            this.btnEditar.setText("Borrar");
        }
        
        
       
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        btnEditar = new javax.swing.JButton();

        setLayout(null);

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEditar.setText("Editar");
        add(btnEditar);
        btnEditar.setBounds(220, 320, 71, 21);
    }//GEN-END:initComponents
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
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);
        scrollPane.setBounds(30, 10, 460, 300);
        
    }
    public static void seleccionar(Component componenteSeleccionado)
    {
        String id = "0";
        Component componentePadre = componenteSeleccionado.getParent();
        
        try{
        for(Component f:panel.getComponents())
        {
            if(String.valueOf(componentePadre.getClass()).equals("class javax.swing.JViewport"))
            {
                if(f.getName().equals(componenteSeleccionado.getParent().getParent().getParent().getName()))
                {
                    
                    f.setBackground(new Color(104,208,249));
                    PanelSeleccion2 dedo = (PanelSeleccion2)f;
                    id = dedo.txtId.getText();
                }else {f.setBackground(Color.WHITE);}
                          
            }
            if(String.valueOf(componentePadre.getClass()).equals("class PanelSeleccion2"))
            {
                if(f.getName().equals(componentePadre.getName()))
                {
                    f.setBackground(new Color(104,208,249));
                    PanelSeleccion2 dedo = (PanelSeleccion2)f;
                    id = dedo.txtId.getText();
                }else {f.setBackground(Color.WHITE);}
                
               
            }
            
            else if(String.valueOf(componentePadre.getClass()).equals("class javax.swing.JPanel"))
            {
                
                String nombres = componenteSeleccionado.getName();
               
                if(f.getName().equals(nombres))
                {
                    f.setBackground(new Color(104,208,249));
                    PanelSeleccion2 dedo = (PanelSeleccion2)f;
                    id = dedo.txtId.getText();
                }else {f.setBackground(Color.WHITE);}
                
            }  
        }}catch(NullPointerException exe)
        {
            //captura de excepcion por loquera de java
        }
        //JOptionPane.showMessageDialog(null,"El seleccionado es el " + id);
        idSeleccionado = id;
    }
            
    public JScrollPane scrollPane;
    public static JPanel panel;
    public static String idSeleccionado ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEditar;
    // End of variables declaration//GEN-END:variables
}
