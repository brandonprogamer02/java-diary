
import java.io.File;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PanelPerfil2 extends javax.swing.JPanel 
{
    public PanelPerfil2() throws SQLException
    {
        initComponents();
        this.btnCargar.addActionListener(new EventoBtnCargar());
        
        actualizarTxts();
        Ventana.ventana.estadoPerfil = "actualizar";
        this.btnActualizar.addActionListener(new eventoBtnActualizarPerfil());
        
        
        
    }
    public void actualizarTxts() throws SQLException
    {
        Object [] array = Conexion.selectPerfil(1);
        this.txtNombre.setText((String)array[1]);  
        this.txtApellido.setText((String)array[2]);  
        this.txtRedSocial.setText((String)array[3]);  
        this.txtNumeroTelefono.setText((String)array[4]);  
        this.txtNumeroCelular.setText((String)array[5]);  
        this.txtColegio.setText((String)array[6]);  
        
    }
    

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtRedSocial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroCelular = new javax.swing.JTextField();
        txtColegio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Perfil Estudiante");
        add(jLabel1);
        jLabel1.setBounds(28, 18, 375, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");
        add(jLabel2);
        jLabel2.setBounds(28, 67, 60, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Apellidos");
        add(jLabel3);
        jLabel3.setBounds(20, 100, 65, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Red Social");
        add(jLabel4);
        jLabel4.setBounds(20, 130, 71, 20);

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        add(txtNombre);
        txtNombre.setBounds(97, 67, 170, 24);

        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        add(txtApellido);
        txtApellido.setBounds(100, 100, 170, 24);

        txtRedSocial.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        add(txtRedSocial);
        txtRedSocial.setBounds(100, 130, 170, 24);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Numero de Telefono");
        add(jLabel5);
        jLabel5.setBounds(20, 160, 160, 20);

        txtNumeroTelefono.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        add(txtNumeroTelefono);
        txtNumeroTelefono.setBounds(20, 180, 240, 24);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Numero de Celular");
        add(jLabel6);
        jLabel6.setBounds(20, 210, 170, 20);

        txtNumeroCelular.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        add(txtNumeroCelular);
        txtNumeroCelular.setBounds(20, 230, 240, 24);

        txtColegio.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        add(txtColegio);
        txtColegio.setBounds(20, 280, 240, 24);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Colegio o Institucion Educativa");
        add(jLabel7);
        jLabel7.setBounds(20, 260, 215, 20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(275, 61, 220, 0);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
        jPanel2.add(lblFoto);

        add(jPanel2);
        jPanel2.setBounds(280, 60, 210, 140);

        btnCargar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnCargar.setText("Cargar Foto");
        add(btnCargar);
        btnCargar.setBounds(330, 210, 100, 23);

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnActualizar.setText("Actualizar Informacion");
        add(btnActualizar);
        btnActualizar.setBounds(300, 280, 150, 23);
    }//GEN-END:initComponents
     public void actualizarInfo()
    {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String redSocial = txtRedSocial.getText();
        String numeroTelefono = txtNumeroTelefono.getText();
        String numeroCelular = txtNumeroCelular.getText();
        String colegio = txtColegio.getText();
        String ruta = "fd";
        Object objeto = new Object[]{nombre,apellido,redSocial,numeroTelefono,numeroCelular,colegio,ruta};
        //Conexion.obtenerConexion();
        
        //Conexion.updatePerfil(objeto);  
    }
    public void abrirFileChooser()
    {
        try {
            System.out.println("entro en file chooser");
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona la imagen");
        fileChooser.showOpenDialog(fileChooser);
        h = fileChooser.getSelectedFile();
           
        }
        catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No seleccionaste ninguna foto");
        }
        
    }
    
    public String getPath()
    {
        String valor= this.h.getAbsolutePath();
       
        return valor;
    }
    public String getNamePath()
    {
        String valor= this.nombreFoto;
        
        return valor;
    }
    public void ponerFoto()
    {
        this.lblFoto.setIcon(new ImageIcon(this.getPath()));
        
    }
            
    public String pathFoto;
    public String nombreFoto;
    public File h; 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnCargar;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblFoto;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtColegio;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNumeroCelular;
    public javax.swing.JTextField txtNumeroTelefono;
    public javax.swing.JTextField txtRedSocial;
    // End of variables declaration//GEN-END:variables
}
