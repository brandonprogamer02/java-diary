public class PanelSeleccion2 extends javax.swing.JPanel {

    public PanelSeleccion2() 
    {
        initComponents();
        //this.addFocusListener(new EventoSeleccionarEditar());
        
        this.txtDescripcion.getParent().setName("padreTxtDescripcion");
        this.addMouseListener(new EventoSeleccionarEditar());
        this.txtFecha.addMouseListener(new EventoSeleccionarEditar());
        this.txtDescripcion.addMouseListener(new EventoSeleccionarEditar());
        this.txtLugar.addMouseListener(new EventoSeleccionarEditar());
        this.txtNombre.addMouseListener(new EventoSeleccionarEditar());
        this.txtTipo.addMouseListener(new EventoSeleccionarEditar());
        this.lblDescripcion.addMouseListener(new EventoSeleccionarEditar());
        this.lblLugar.addMouseListener(new EventoSeleccionarEditar());
        this.lblFecha.addMouseListener(new EventoSeleccionarEditar());
        this.lblNombre.addMouseListener(new EventoSeleccionarEditar());
        this.lblTipo.addMouseListener(new EventoSeleccionarEditar());
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblLugar = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtId = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(450, 140));
        setMinimumSize(new java.awt.Dimension(150, 170));
        setLayout(null);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblNombre.setText("Nombre");
        lblNombre.setName("lblNombre"); // NOI18N
        lblNombre.setPreferredSize(new java.awt.Dimension(35, 20));
        add(lblNombre);
        lblNombre.setBounds(10, 13, 64, 19);

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNombre.setText("Juanito Fest");
        txtNombre.setName("txtNombre"); // NOI18N
        add(txtNombre);
        txtNombre.setBounds(78, 11, 150, 24);

        lblFecha.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblFecha.setText("Fecha");
        lblFecha.setName("lblFecha"); // NOI18N
        lblFecha.setPreferredSize(new java.awt.Dimension(35, 20));
        add(lblFecha);
        lblFecha.setBounds(10, 42, 43, 20);

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtFecha.setText("20 de mayo del 2020");
        txtFecha.setName("txtFecha"); // NOI18N
        add(txtFecha);
        txtFecha.setBounds(78, 41, 150, 24);

        lblTipo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblTipo.setText("Tipo ");
        lblTipo.setName("lblTipo"); // NOI18N
        lblTipo.setPreferredSize(new java.awt.Dimension(35, 20));
        add(lblTipo);
        lblTipo.setBounds(10, 73, 43, 19);

        txtTipo.setEditable(false);
        txtTipo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTipo.setText("Fiesta de Cumpleanos");
        txtTipo.setName("txtTipo"); // NOI18N
        add(txtTipo);
        txtTipo.setBounds(78, 71, 150, 24);

        lblLugar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblLugar.setText("Lugar ");
        lblLugar.setName("lblLugar"); // NOI18N
        add(lblLugar);
        lblLugar.setBounds(10, 107, 50, 20);

        txtLugar.setEditable(false);
        txtLugar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtLugar.setText("Piantini RD");
        txtLugar.setName("txtLugar"); // NOI18N
        add(txtLugar);
        txtLugar.setBounds(78, 106, 150, 24);

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblDescripcion.setText("Descripcion");
        lblDescripcion.setName("lblDescripcion"); // NOI18N
        add(lblDescripcion);
        lblDescripcion.setBounds(240, 10, 86, 20);

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDescripcion.setRows(5);
        txtDescripcion.setEnabled(false);
        txtDescripcion.setName("txtDescripcion"); // NOI18N
        jScrollPane1.setViewportView(txtDescripcion);

        add(jScrollPane1);
        jScrollPane1.setBounds(240, 40, 199, 88);

        txtId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtId.setText("5");
        txtId.setEnabled(false);
        add(txtId);
        txtId.setBounds(400, 10, 20, 20);
    }//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblDescripcion;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblLugar;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblTipo;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtLugar;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}

