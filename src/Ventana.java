
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Ventana extends javax.swing.JFrame {

    //static String estadoPerfil;
    
    public String estadoPerfil = "";

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        panelBackground = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCrud = new javax.swing.JMenu();
        menuItemGuardar = new javax.swing.JMenuItem();
        menuItemEditar = new javax.swing.JMenuItem();
        menuItemBorrar = new javax.swing.JMenuItem();
        menuItemBuscar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemPerfil = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 233, 207));
        getContentPane().setLayout(null);

        panelBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBackground.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(panelBackground);
        panelBackground.setBounds(30, 20, 520, 350);

        jPanel1.setBackground(new java.awt.Color(208, 217, 240));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 580, 400);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(64, 20));

        menuCrud.setText("Crud");
        menuCrud.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuItemGuardar.setText("Guardar");
        menuCrud.add(menuItemGuardar);

        menuItemEditar.setText("Editar");
        menuCrud.add(menuItemEditar);

        menuItemBorrar.setText("Borrar");
        menuCrud.add(menuItemBorrar);

        menuItemBuscar.setText("Buscar");
        menuCrud.add(menuItemBuscar);

        jMenuBar1.add(menuCrud);

        jMenu2.setText("Informacion");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuItemPerfil.setText("Perfil del Estudiante");
        jMenu2.add(menuItemPerfil);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }//GEN-END:initComponents

    
    public Ventana() throws SQLException, ClassNotFoundException 
    {
        initComponents();
        this.setMinimumSize(new Dimension(590,450));
        
        this.panelBackground.setLayout(new GridLayout());
        //this.panelBackground.add(new PanelGuardar());
        
        actualizarPanel("panelguardar",new PanelGuardar());
        this.setLocationRelativeTo(null);
        this.menuItemGuardar.addActionListener(new EventoMenuGuardar());
        this.menuItemEditar.addActionListener(new EventoMenuEditar());
        this.menuItemBuscar.addActionListener(new EventoMenuBuscar());
        this.menuItemBorrar.addActionListener(new EventoMenuBorrar());
        this.menuItemPerfil.addActionListener(new EventoMenuPerfil());
        Conexion.obtenerConexion();
        Conexion.cnx = null;
        System.out.println("FOCKIN LINEA DE DIVISION");
        try
        {
            Conexion.obtenerConexion();
            Conexion.crearTablaEventos();
            Conexion.crearTablaPerfil();
            
            Conexion.insertPerfil(new String[]{"na de na","na de na","na de na","na de na","na de na","na de na","na de na"});
        
        }catch (SQLException ex) 
            {
                
                System.out.println("MESSAGE ERROR IS " + ex.getLocalizedMessage()); // Unknown database 'pruebass'
                if(ex.getLocalizedMessage().equals("Table 'eventos' already exists"))
                {
                    System.out.println("capturo el error que ya existia");
                    
                }
                
            } 
        
        
        
        
    }
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try
                {
                    ventana = new Ventana();
                } catch (SQLException ex)
                {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                ventana.setVisible(true);
            }
        });
        Ventana.setEstilo("Windows");
        
        
    }
    public static void setEstilo(String estilo)
    {
        try 
          {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if (estilo.equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (ClassNotFoundException ex) {} 
        catch (InstantiationException ex) {} 
        catch (IllegalAccessException ex) {} 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {}
    }
    
    public void actualizarPanel(String nombrePanel,JPanel componente)
    {
        this.panelBackground.removeAll();
        this.panelBackground.validate();
        this.panelBackground.repaint();
        deleteAllInstanciasPanel();
        this.panelBackground.add(componente);
        componente.setName(nombrePanel);
        this.panelBackground.revalidate();
        addInstanciaPanel(nombrePanel,componente);
        System.out.println("la instancia que esta: \n");
        printAllNameInstancias();
    }
    public void addInstanciaPanel(String nombrePanel,JPanel panel)
    {
        instanciasPaneles.put(nombrePanel, panel);
    }
    public static JPanel getInstanciaPanel(String nombreInstancia)
    {
        int i = 0;
        int size = instanciasPaneles.size();
        System.out.println("el size es: " + size);
        JPanel valor = null;
        for (Map.Entry<String, JPanel> entry : instanciasPaneles.entrySet()) 
        {
            String nombreActual = entry.getKey();
            if(nombreActual.equals(nombreInstancia))
            {
                valor =  entry.getValue();
                System.out.println("si se encuentra");
            }
            if(i == size -1)
            {
                System.out.println("no se ha encontrau na");
            }
                
        }
        return valor;
    }
  
    public static void deleteAllInstanciasPanel()
    {
        Map<String, JPanel> instanciasPaneles2 = new HashMap<String, JPanel>();
        instanciasPaneles2 = instanciasPaneles;
        for(Map.Entry<String, JPanel> entry : instanciasPaneles2.entrySet()) 
        {
            String valorName= entry.getValue().getName();
            removeInstancia(valorName);
        } 
            
    }
    
    public static String printAllNameInstancias()
    {
        String cadena = "";
        for(Map.Entry<String, JPanel> entry : instanciasPaneles.entrySet()) 
        {
            System.out.println(entry.getKey());
            cadena =  entry.getKey();
        }
        return cadena;
    }
    public static void removeInstancia(String nombrePanel)
    {
        instanciasPaneles.remove(nombrePanel); 
        System.out.println("elemento con el nobmre de " + nombrePanel
        +"removido corretamente");
    }
    
    public static Ventana ventana;
    
    //public static PanelGuardar panelGuardar;
    public static Map<String, JPanel> instanciasPaneles = new HashMap<String, JPanel>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JMenu menuCrud;
    public javax.swing.JMenuItem menuItemBorrar;
    public javax.swing.JMenuItem menuItemBuscar;
    public javax.swing.JMenuItem menuItemEditar;
    public javax.swing.JMenuItem menuItemGuardar;
    public javax.swing.JMenuItem menuItemPerfil;
    public javax.swing.JPanel panelBackground;
    // End of variables declaration//GEN-END:variables

}
