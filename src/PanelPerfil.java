import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PanelPerfil extends javax.swing.JPanel {

    
    public PanelPerfil() 
    {
        initComponents();
        //this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        panelBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelFoto = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtRedSocial = new javax.swing.JTextField();
        txtNumerotelefono = new javax.swing.JTextField();
        txtNumeroCelular = new javax.swing.JTextField();
        txtColegio = new javax.swing.JTextField();
        btnCargar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(515, 330));
        setMinimumSize(new java.awt.Dimension(515, 330));
        setPreferredSize(new java.awt.Dimension(515, 330));
        setLayout(null);

        panelBackground.setBackground(new java.awt.Color(255, 255, 255));
        panelBackground.setEnabled(false);
        panelBackground.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Perfil del Estudiante");
        panelBackground.add(jLabel1);
        jLabel1.setBounds(40, 10, 154, 23);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Nombre");
        panelBackground.add(jLabel2);
        jLabel2.setBounds(20, 50, 70, 18);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Apellido");
        panelBackground.add(jLabel3);
        jLabel3.setBounds(20, 80, 60, 18);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Red Social");
        panelBackground.add(jLabel4);
        jLabel4.setBounds(20, 110, 80, 18);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Colegio / Institucion Educativa");
        panelBackground.add(jLabel5);
        jLabel5.setBounds(20, 250, 200, 18);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Numero Telefono");
        panelBackground.add(jLabel6);
        jLabel6.setBounds(20, 150, 120, 21);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Numero Celular");
        panelBackground.add(jLabel7);
        jLabel7.setBounds(20, 200, 110, 18);

        panelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelFoto.setLayout(new java.awt.GridLayout(1, 0));

        lblFoto.setText("jLabel8");
        panelFoto.add(lblFoto);

        panelBackground.add(panelFoto);
        panelFoto.setBounds(262, 40, 240, 180);

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNombre.setText("Yo lo que soy e un freco");
        panelBackground.add(txtNombre);
        txtNombre.setBounds(100, 50, 148, 24);

        txtApellido.setEditable(false);
        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtApellido.setText("mere");
        panelBackground.add(txtApellido);
        txtApellido.setBounds(100, 80, 148, 24);

        txtRedSocial.setEditable(false);
        txtRedSocial.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtRedSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRedSocialActionPerformed(evt);
            }
        });
        panelBackground.add(txtRedSocial);
        txtRedSocial.setBounds(100, 110, 150, 24);

        txtNumerotelefono.setEditable(false);
        txtNumerotelefono.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelBackground.add(txtNumerotelefono);
        txtNumerotelefono.setBounds(20, 170, 220, 20);

        txtNumeroCelular.setEditable(false);
        txtNumeroCelular.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelBackground.add(txtNumeroCelular);
        txtNumeroCelular.setBounds(20, 220, 217, 24);

        txtColegio.setEditable(false);
        txtColegio.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtColegio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColegioActionPerformed(evt);
            }
        });
        panelBackground.add(txtColegio);
        txtColegio.setBounds(20, 270, 220, 24);

        btnCargar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCargar.setText("Cargar Foto");
        panelBackground.add(btnCargar);
        btnCargar.setBounds(330, 220, 100, 25);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton1.setText("Actualizar Informacion");
        panelBackground.add(jButton1);
        jButton1.setBounds(300, 270, 150, 23);

        add(panelBackground);
        panelBackground.setBounds(0, 0, 0, 0);
    }//GEN-END:initComponents

    private void txtColegioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColegioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColegioActionPerformed

    private void txtRedSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRedSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRedSocialActionPerformed
    
    public void actualizarInfo()
    {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String redSocial = txtRedSocial.getText();
        String numeroTelefono = txtNumerotelefono.getText();
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
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona la imagen");
        fileChooser.showOpenDialog(fileChooser);
        final File h = fileChooser.getSelectedFile();
           
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
    public javax.swing.JButton btnCargar;
    public javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel lblFoto;
    public javax.swing.JPanel panelBackground;
    public javax.swing.JPanel panelFoto;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtColegio;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNumeroCelular;
    public javax.swing.JTextField txtNumerotelefono;
    public javax.swing.JTextField txtRedSocial;
    // End of variables declaration//GEN-END:variables
}
