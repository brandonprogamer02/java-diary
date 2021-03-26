import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Eventos 
{
    
}
class EventoGenerarFecha implements PropertyChangeListener
{
    @Override
    public void propertyChange(PropertyChangeEvent evt)    
    {
        try{
        String fd = evt.getPropertyName();
        System.out.println("nombre de la propiedad: " + fd);
        System.out.println("los paneles que tan son:\n"); 
        String cadena = Ventana.printAllNameInstancias();
        System.out.println("COMPROBANDO CADENA ES IGUAL A " + cadena);
        if(cadena.equals("panelguardar"))
        {
            System.out.println("entro en panel guardar dentro del evento");
            PanelGuardar panelGuardarInstancia = (PanelGuardar)Ventana.getInstanciaPanel("panelguardar");
            int dia = panelGuardarInstancia.dia.getDay();
            String mes = PanelGuardar.getMonthString(panelGuardarInstancia.mes.getMonth());
            int ano = panelGuardarInstancia.ano.getYear();
            String hora = (String)panelGuardarInstancia.hora.getSelectedItem();
            String texto = String.format("%s de %s %s %s",dia,mes,ano,hora);
            panelGuardarInstancia.txtFecha.setText(texto);
        
        }else if(cadena.equals("paneleditar"))
        {
            System.out.println("entro en panel editar dentro del evento");
            PanelEditar panelEditarInstancia = (PanelEditar)Ventana.getInstanciaPanel("paneleditar");
            int dia = panelEditarInstancia.dia.getDay();
            String mes = PanelGuardar.getMonthString(panelEditarInstancia.mes.getMonth());
            int ano = panelEditarInstancia.ano.getYear();
            String hora = (String)panelEditarInstancia.hora.getSelectedItem();
            String texto = String.format("%s de %s %s %s",dia,mes,ano,hora);
            panelEditarInstancia.txtFecha.setText(texto);
        
            
        }
        
        }catch(NullPointerException exe)
        {
            System.out.println("execion captura");
        }
        
        
           
    }  
}
class EventoMenuGuardar implements ActionListener
{   
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        System.out.println("entro en evento guardar");
        Ventana.ventana.actualizarPanel("panelguardar",new PanelGuardar());
    }
    
}
class EventoMenuEditar implements ActionListener
{
    public  PanelSeleccion panelSeleccion;
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        System.out.println("entro en evento editar");
        try
        {
            panelSeleccion = new PanelSeleccion("editar");
            
            Ventana.ventana.actualizarPanel("panelseleccion",panelSeleccion);
        } catch (SQLException ex)
        {
            Logger.getLogger(EventoMenuEditar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(EventoMenuEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}     
class EventoHora implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String cadena = Ventana.printAllNameInstancias();
        System.out.println("COMPROBANDO CADENA ES IGUAL A " + cadena);
        if(cadena.equals("panelguardar"))
        {
            PanelGuardar panelGuardarInstancia = (PanelGuardar)Ventana.getInstanciaPanel("panelguardar");
            String fecha = panelGuardarInstancia.txtFecha.getText();
            int longitud = fecha.length();
            try{
            String fechaSinHora = fecha.substring(0, longitud -5);
            String nuevaFecha = fechaSinHora + panelGuardarInstancia.hora.getSelectedItem();
            panelGuardarInstancia.txtFecha.setText(nuevaFecha);
            }catch(StringIndexOutOfBoundsException ex)
            {
                JOptionPane.showMessageDialog(null, "Debes seleccionar la fecha primero");
            }
            
        }else if(cadena.equals("paneleditar"))
        {
            PanelEditar panelEditarInstancia = (PanelEditar)Ventana.getInstanciaPanel("paneleditar");
            String fecha = panelEditarInstancia.txtFecha.getText();
            int longitud = fecha.length();
            try{
            String fechaSinHora = fecha.substring(0, longitud -5);
            String nuevaFecha = fechaSinHora + panelEditarInstancia.hora.getSelectedItem();
            panelEditarInstancia.txtFecha.setText(nuevaFecha);
            }catch(StringIndexOutOfBoundsException ex)
            {
                JOptionPane.showMessageDialog(null, "Debes seleccionar la fecha primero");
            }
            
        }
        
        
        
        
        
    }
    
}
class EventoSeleccionarEditar extends MouseAdapter
{
    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("ha ganau el foco el panel" + e.getComponent().getName());
        if(e.getComponent().getName().equals("txtDescripcion"))
        {
            System.out.println("en txtDescripcion:" + e.getComponent().getParent().getParent().getParent().getName());
        }
        PanelSeleccion.seleccionar(e.getComponent());
    }
}
class EventoGuardar implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            Conexion.obtenerConexion();
            PanelGuardar panelGuardarInstancia = (PanelGuardar)Ventana.getInstanciaPanel("panelguardar");
            String nombre = panelGuardarInstancia.txtNombre.getText();
            String lugar = panelGuardarInstancia.txtLugar.getText();
            String tipo = panelGuardarInstancia.txtTipo.getText();
            String fecha = panelGuardarInstancia.txtFecha.getText();
            String descripcion = panelGuardarInstancia.txtDescripcion.getText();
            Evento objeto = new Evento(nombre,lugar,tipo,fecha,descripcion);
            Conexion.insertar(objeto);
            
            panelGuardarInstancia.limpiarTxt();
        } catch (SQLException ex)
        {
            Logger.getLogger(EventoGuardar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(EventoGuardar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}

class EventoMenuBuscar implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try
            {
                Ventana.ventana.actualizarPanel("panelbuscar",new PanelBuscar());
            } catch (SQLException ex)
            {
                Logger.getLogger(EventoMenuBuscar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(EventoMenuBuscar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
}

class EventoEditar implements ActionListener
{
    public static PanelEditar panelEditar;
    public static String seleccionado;
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        seleccionado = PanelSeleccion.idSeleccionado;
        System.out.println("el seleccionado en el evento ya es el " + seleccionado);
        try{
        if(seleccionado.equals("0"))
        {
            JOptionPane.showMessageDialog(null,"No Tienes Seleccionado ningun registro!");
        }else
        {
            panelEditar = new PanelEditar(Integer.valueOf(seleccionado));
            Ventana.ventana.actualizarPanel("paneleditar",panelEditar);
            PanelEditar f = (PanelEditar)Ventana.getInstanciaPanel("paneleditar");
            
            
            
        }
        }catch(NullPointerException es)
        {
            JOptionPane.showMessageDialog(null,"No Tienes Seleccionado ningun registro!");
        }
        PanelSeleccion.idSeleccionado = "0";
    }
    
}   
class EventoEditar2 implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String nombre,lugar,tipo,fecha,descripcion;
        try
        {
            Conexion.obtenerConexion();
            Evento dataBD = Conexion.select(Integer.valueOf(EventoEditar.seleccionado));
            // filtro por si el usuario deja casillas vacias entonces que conserve
            // los datos originales de la db
            if(EventoEditar.panelEditar.txtNombre.getText().equals(""))
            {
                nombre = dataBD.getNombre();
            }else 
            { 
                nombre = EventoEditar.panelEditar.txtNombre.getText(); 
            }
            if(EventoEditar.panelEditar.txtLugar.getText().equals(""))
            {
                lugar = dataBD.getLugar();
            }else 
            { 
                lugar = EventoEditar.panelEditar.txtLugar.getText(); 
            }
            if(EventoEditar.panelEditar.txtTipo.getText().equals(""))
            {
                tipo = dataBD.getTipo();
            }else 
            { 
                tipo = EventoEditar.panelEditar.txtTipo.getText();
            }
            if(EventoEditar.panelEditar.txtFecha.getText().equals(""))
            {
                fecha = dataBD.getFecha();
            }else 
            { 
                fecha = EventoEditar.panelEditar.txtFecha.getText();
            }
            if(EventoEditar.panelEditar.txtDescripcion.getText().equals(""))
            {
                descripcion = dataBD.getDescripcion();
            }else 
            { 
                descripcion = EventoEditar.panelEditar.txtDescripcion.getText();
            }
            
            Evento registro = new Evento(nombre,lugar,tipo,fecha,descripcion);
            
            Conexion.Update(Integer.valueOf(EventoEditar.seleccionado),registro);
            
            EventoEditar.panelEditar.txtNombre.setText("");
            EventoEditar.panelEditar.txtLugar.setText("");
            EventoEditar.panelEditar.txtTipo.setText("");
            EventoEditar.panelEditar.txtFecha.setText("");
            EventoEditar.panelEditar.txtDescripcion.setText("");
            
        } catch (SQLException ex)
        {
            Logger.getLogger(EventoEditar2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(EventoEditar2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
} 

class EventoMenuBorrar implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            PanelSeleccion panelSeleccion = new PanelSeleccion("borrar");
            Ventana.ventana.actualizarPanel("panelseleccion",panelSeleccion);
        } catch (SQLException ex)
        {
            Logger.getLogger(EventoMenuBorrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(EventoMenuBorrar.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }    
}
class EventoBorrar implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(PanelSeleccion.idSeleccionado.equals("0"))
        {
            JOptionPane.showMessageDialog(null,"No Tienes Seleccionado ningun registro!");
        }else
        {
            int idSeleccionado = Integer.valueOf(PanelSeleccion.idSeleccionado);
            try
            {
                Conexion.obtenerConexion();
                Conexion.borrar(idSeleccionado);
                PanelSeleccion.idSeleccionado = "0";
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(EventoBorrar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex)
            {
                Logger.getLogger(EventoBorrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        
        
    }
    
}
class EventoMenuPerfil implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            Ventana.ventana.actualizarPanel("panelperfil2", new PanelPerfil2());
        } catch (SQLException ex)
        {
            Logger.getLogger(EventoMenuPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
class EventoBtnCargar implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
         PanelPerfil2 panelPerfil2 = (PanelPerfil2)Ventana.getInstanciaPanel("panelperfil2");
         panelPerfil2.abrirFileChooser();
         String path = panelPerfil2.getPath();
         String name =  panelPerfil2.getNamePath();
         panelPerfil2.ponerFoto();
    }
    
}

class eventoBtnActualizarPerfil implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        System.out.println("el evento del perfil es: "+ Ventana.ventana.estadoPerfil);
        if(Ventana.ventana.estadoPerfil.equals("insertar"))
        {
            PanelPerfil2 panelPerfil2 = (PanelPerfil2) Ventana.getInstanciaPanel("panelPerfil2");
            String nombre = panelPerfil2.txtNombre.getText();
            String apellidos = panelPerfil2.txtApellido.getText();
            String redSocial = panelPerfil2.txtRedSocial.getText();
            String numeroTelefono = panelPerfil2.txtNumeroTelefono.getText();
            String numeroCelular = panelPerfil2.txtNumeroCelular.getText();
            String colegio = panelPerfil2.txtColegio.getText();
            String ruta = panelPerfil2.getNamePath();
            String [] array = new String[]{nombre,apellidos,redSocial,numeroTelefono,numeroCelular,colegio,ruta};
            try
            {
                Conexion.insertPerfil(array);
            } catch (SQLException ex)
            {
                Logger.getLogger(eventoBtnActualizarPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(Ventana.ventana.estadoPerfil.equals("actualizar"))
        {
            System.out.println("POR LO MENO LLEGO");
            PanelPerfil2 panelPerfil2 = (PanelPerfil2) Ventana.getInstanciaPanel("panelperfil2");
            String nombre = panelPerfil2.txtNombre.getText();
            System.out.println("EL FUCK NOBMRE "+ nombre);
            String apellidos = panelPerfil2.txtApellido.getText();
            String redSocial = panelPerfil2.txtRedSocial.getText();
            String numeroTelefono = panelPerfil2.txtNumeroTelefono.getText();
            String numeroCelular = panelPerfil2.txtNumeroCelular.getText();
            String colegio = panelPerfil2.txtColegio.getText();
            String ruta = panelPerfil2.getNamePath();
            String [] array = new String[]{nombre,apellidos,redSocial,numeroTelefono,numeroCelular,colegio,ruta};
            
            try
            {
                Conexion.obtenerConexion();
                Conexion.updatePerfil(array);
                panelPerfil2.actualizarTxts();
            } catch (SQLException ex)
            {
                Logger.getLogger(eventoBtnActualizarPerfil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(eventoBtnActualizarPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}


    
