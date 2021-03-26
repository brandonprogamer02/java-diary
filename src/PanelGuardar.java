import java.awt.Color;

public class PanelGuardar extends javax.swing.JPanel 
{
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        dia = new com.toedter.calendar.JDayChooser();
        mes = new com.toedter.calendar.JMonthChooser();
        ano = new com.toedter.calendar.JYearChooser();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        hora = new javax.swing.JComboBox<>();

        setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        setMinimumSize(new java.awt.Dimension(515, 351));
        setLayout(null);

        dia.setBackground(new java.awt.Color(255, 255, 255));
        dia.setDecorationBackgroundColor(new java.awt.Color(204, 255, 255));
        add(dia);
        dia.setBounds(240, 210, 240, 110);

        mes.setBackground(new java.awt.Color(255, 255, 255));
        mes.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        mes.setMinimumSize(new java.awt.Dimension(129, 38));
        add(mes);
        mes.setBounds(390, 170, 90, 30);

        ano.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        add(ano);
        ano.setBounds(320, 170, 60, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Guardar");
        add(jLabel1);
        jLabel1.setBounds(60, 10, 110, 30);

        txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtFecha.setMargin(new java.awt.Insets(-5, 5, 0, 0));
        txtFecha.setMinimumSize(new java.awt.Dimension(3, 18));
        add(txtFecha);
        txtFecha.setBounds(240, 140, 260, 20);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        add(btnGuardar);
        btnGuardar.setBounds(60, 290, 100, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Fecha del Evento");
        add(jLabel2);
        jLabel2.setBounds(270, 110, 180, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("TIpo de Evento");
        add(jLabel3);
        jLabel3.setBounds(20, 110, 150, 20);

        txtTipo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtTipo.setMargin(new java.awt.Insets(-5, 5, 0, 0));
        txtTipo.setMinimumSize(new java.awt.Dimension(3, 18));
        add(txtTipo);
        txtTipo.setBounds(20, 140, 200, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Descripcion del Evento");
        add(jLabel4);
        jLabel4.setBounds(20, 170, 190, 20);

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtDescripcion.setMinimumSize(new java.awt.Dimension(3, 18));
        jScrollPane1.setViewportView(txtDescripcion);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 200, 200, 80);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Nombre del Evento");
        add(jLabel5);
        jLabel5.setBounds(20, 50, 200, 20);

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtNombre.setMargin(new java.awt.Insets(-5, 5, 0, 0));
        txtNombre.setMinimumSize(new java.awt.Dimension(3, 18));
        add(txtNombre);
        txtNombre.setBounds(20, 80, 210, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Lugar del Evento");
        add(jLabel6);
        jLabel6.setBounds(270, 50, 140, 22);

        txtLugar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtLugar.setMargin(new java.awt.Insets(-5, 5, 0, 0));
        txtLugar.setMinimumSize(new java.awt.Dimension(3, 18));
        add(txtLugar);
        txtLugar.setBounds(260, 80, 200, 20);

        hora.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        add(hora);
        hora.setBounds(250, 180, 60, 20);
    }//GEN-END:initComponents
    public PanelGuardar() 
    {
        initComponents();
        this.setBackground(Color.WHITE);
        this.mes.setBackground(Color.WHITE);
        // poner color blanco el comboBox del mes
        this.txtFecha.setEditable(false);
        
        for(int i = 0 ;i <=24;i++) // agregar items al combobox hora
        {
            if(i <10) {  this.hora.addItem(String.format("0%s:00",i));}
            else { this.hora.addItem(String.format("%s:00",i));}
        }
        this.hora.addActionListener(new EventoHora());
        this.mes.addPropertyChangeListener(new EventoGenerarFecha());
        this.dia.addPropertyChangeListener(new EventoGenerarFecha());
        this.ano.addPropertyChangeListener(new EventoGenerarFecha());
        this.btnGuardar.addActionListener(new EventoGuardar());
    }

    public String getDates()
    {
        int diaB = this.dia.getDay();
        String mesB = this.getMonthString(mes.getMonth());
        int anoB = this.ano.getValue();
        
        return String.format("%s de %s del año %s",diaB,mesB,anoB);
    }
    public static String getMonthString(int mes)
    {
        switch(mes)
        {
            case 0: return "Enero";
            case 1: return "Febrero";
            case 2: return "Marzo";
            case 3: return "Abril";
            case 4: return "Mayo";
            case 5: return "Junio";
            case 6: return "Julio";
            case 7: return "Agosto";
            case 8: return "Septiembre";
            case 9: return "Octubre";
            case 10: return "Noviembre";
            case 11: return "Diciembre";
            
        }
          return "";
    }
    public void limpiarTxt()
    {
        this.txtNombre.setText("");
        this.txtLugar.setText("");
        this.txtTipo.setText("");
        this.txtFecha.setText("");
        this.txtDescripcion.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JYearChooser ano;
    public javax.swing.JButton btnGuardar;
    public com.toedter.calendar.JDayChooser dia;
    public javax.swing.JComboBox<String> hora;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JScrollPane jScrollPane1;
    public com.toedter.calendar.JMonthChooser mes;
    public javax.swing.JTextPane txtDescripcion;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtLugar;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
