import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion 
{
   
   public static Connection cnx = null;
   public static Connection obtenerConexion() throws SQLException, ClassNotFoundException 
   {
        if (cnx == null) 
        {
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "root", "");
                System.out.println("entro en pruebas bien");
                System.out.println("no entro en catch if");
            } catch (SQLException ex) 
            {
                
                System.out.println("3 " + ex.getLocalizedMessage()); // Unknown database 'pruebass'
                if(ex.getLocalizedMessage().equals("Unknown database 'pruebas'"))
                {
                    System.out.println("entro en el catch and if");
                    crearDbPruebas();
                    
                }
                
            } catch (ClassNotFoundException ex) 
            {
                //JOptionPane.showMessageDialog(null, "Conexion Fallida");
                throw new ClassCastException(ex.getMessage());
            }
        }
        System.out.println("Conexion Establecida");
        return cnx;
   }
   public static void crearDbPruebas() throws SQLException
   {
       try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
                PreparedStatement consulta;
                consulta = cnx.prepareStatement("CREATE DATABASE pruebas");
                consulta.executeUpdate();
                System.out.println("DATABASE CREADO CORRECTAMENTE");
                
            } catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "Conexion Fallida");
                JOptionPane.showMessageDialog(null, "Conexion Fallida en creacion de bd");
                throw new SQLException(ex.getCause());
            } catch (ClassNotFoundException ex) 
            {
                JOptionPane.showMessageDialog(null, "Conexion Fallida");
                JOptionPane.showMessageDialog(null, "Conexion Fallida en db class not found exception");
                throw new ClassCastException(ex.getMessage());
            }
       
       
       
   }
  public static void crearTablaEventos() throws SQLException, ClassNotFoundException 
   {
      Conexion.obtenerConexion();
       System.out.println("ENTRO EN CREACION DE TABLA EVENTOS");
      String query = "CREATE TABLE eventos("
              + "id INT(20) NOT NULL AUTO_INCREMENT,"
              + "nombre varchar(70),"
              + "lugar varchar(70),"
              + "tipo varchar(70),"
              + "fecha varchar(70),"
              + "descripcion varchar(70),"
              + "PRIMARY KEY (id)"
              + ")";
      Statement  f = cnx.createStatement();
      f.executeUpdate(query);
      
   }
  public static void crearTablaPerfil() throws SQLException, ClassNotFoundException
  {
      Conexion.obtenerConexion();
      System.out.println("ENTRO EN CREACION DE TABLA PERFIL");
      String query = "CREATE TABLE perfil("
              + "id INT(20) NOT NULL AUTO_INCREMENT,"
              + "nombre varchar(70),"
              + "apellido varchar(70),"
              + "red_social varchar(70),"
              + "numero_telefono varchar(70),"
              + "numero_celular varchar(70),"
              + "colegio varchar(70),"
              + "ruta_foto varchar(100),"
              + "PRIMARY KEY (id)"
              + ")";
      Statement  f = cnx.createStatement();
      f.executeUpdate(query);
      
  }
   
   public static void cerrar() throws SQLException 
   {
      if (cnx != null) 
      {
          cnx.close();
      }
   }
   public static void insertar(Evento registro) throws ClassNotFoundException, SQLException
   {
       try
       {
           PreparedStatement consulta;
           consulta = cnx.prepareStatement("INSERT INTO eventos(nombre,lugar,tipo,fecha,descripcion) VALUES(?, ?, ? ,? ,?)");
           consulta.setString(1, registro.getNombre());
           consulta.setString(2, registro.getLugar() );
           consulta.setString(3, registro.getTipo() );
           consulta.setString(4, registro.getFecha() );
           consulta.setString(5, registro.getDescripcion() );
           consulta.executeUpdate();
           JOptionPane.showMessageDialog(null, "Insercion Exitosa");
           
      }catch(SQLException ex)
      {
         JOptionPane.showMessageDialog(null, "Error al Insertar los datos");
         throw new SQLException(ex);
      }
       
   }
   public static ArrayList<Evento> SelectAll() throws SQLException
   {
       ArrayList<Evento> lista = new ArrayList<Evento>();
       try
       {
           String query = "SELECT * FROM eventos";
           PreparedStatement consulta = cnx.prepareStatement(query);
           ResultSet resultado = consulta.executeQuery();
           while(resultado.next())
           {
               int id = resultado.getInt("id");
               String nombre = resultado.getString("nombre");
               String lugar = resultado.getString("lugar");
               String tipo = resultado.getString("tipo");
               String fecha = resultado.getString("fecha");
               String descripcion = resultado.getString("descripcion");
               Evento objeto = new Evento(id,nombre,lugar,tipo,fecha,descripcion);
               
               lista.add(objeto);
           }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }/*
      for(Evento es:lista)
      {
          System.out.println("*ID: " + es.getId());
          System.out.println("*Nombre: " + es.getNombre());
          System.out.println("*Lugar: " + es.getLugar());
          System.out.println("*Tipo: " + es.getTipo());
          System.out.println("*Fecha: " + es.getFecha());
          System.out.println("*Descripcion: " + es.getDescripcion());
      }*/
      return lista;
   }
   public static void Update(int id,Evento registro) throws SQLException
   {
       try
       {
           PreparedStatement consulta;
           consulta = cnx.prepareStatement("UPDATE eventos SET nombre = ?, lugar = ?,tipo = ?,fecha = ?,descripcion = ? WHERE id = ?");
           consulta.setString(1, registro.getNombre());
           consulta.setString(2, registro.getLugar() );
           consulta.setString(3, registro.getTipo() );
           consulta.setString(4, registro.getFecha() );
           consulta.setString(5, registro.getDescripcion() );
           consulta.setInt(6,id);
           consulta.executeUpdate();
           JOptionPane.showMessageDialog(null, "Actualizacion Exitosa Exitosa");
           
      }catch(SQLException ex)
      {
          JOptionPane.showMessageDialog(null, "Error al Actualizar el registro");
          throw new SQLException(ex);
      }
       
   }
   public static void updatePerfil(Object[] objeto) throws SQLException
   {
       try
       {
           PreparedStatement consulta;
           consulta = cnx.prepareStatement("UPDATE perfil SET nombre = ?, apellido = ?,red_social = ?,numero_telefono = ?,numero_celular = ?, colegio = ?,ruta_foto = ? WHERE id = 1 ");
           consulta.setString(1, (String)objeto[0]);
           consulta.setString(2, (String)objeto[1] );
           consulta.setString(3, (String)objeto[2] );
           consulta.setString(4, (String)objeto[3] );
           consulta.setString(5, (String)objeto[4] );
           consulta.setString(6, (String)objeto[5] );
           consulta.setString(7, (String)objeto[6] );
           
           consulta.executeUpdate();
           JOptionPane.showMessageDialog(null, "Actualizacion Exitosa Exitosa");
           
      }catch(SQLException ex)
      {
          JOptionPane.showMessageDialog(null, "Error al Actualizar el registro");
          throw new SQLException(ex);
      }

       
   }
   public static void insertPerfil(String [] registro) throws SQLException
   {
       try
       {
           PreparedStatement consulta;
           consulta = cnx.prepareStatement("INSERT INTO perfil(nombre,apellido,red_social,numero_telefono,numero_celular,colegio,ruta_foto) VALUES(?, ?, ? ,? , ?, ?, ?)");
           consulta.setString(1, registro[0]);
           consulta.setString(2, registro[1] );
           consulta.setString(3, registro[2] );
           consulta.setString(4, registro[3] );
           consulta.setString(5, registro[4] );
           consulta.setString(6, registro[5] );
           consulta.setString(7, registro[6] );
           consulta.executeUpdate();
           JOptionPane.showMessageDialog(null, "Insercion Exitosa");
           
      }catch(SQLException ex)
      {
         JOptionPane.showMessageDialog(null, "Error al Insertar los datos");
         throw new SQLException(ex);
      }
       
   }
   public static Evento select(int Id) throws SQLException
   {
       Evento objeto = null;
       try
       {
           String query = "SELECT * FROM eventos WHERE id = "+ Id;
           PreparedStatement consulta = cnx.prepareStatement(query);
           ResultSet resultado = consulta.executeQuery();
           
           
           while(resultado.next())
           {
               int id = resultado.getInt("id");
               String nombre = resultado.getString("nombre");
               String lugar = resultado.getString("lugar");
               String tipo = resultado.getString("tipo");
               String fecha = resultado.getString("fecha");
               String descripcion = resultado.getString("descripcion");
               objeto = new Evento(id,nombre,lugar,tipo,fecha,descripcion);
               
           }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
       return objeto;
   }
   public static void borrar(int id) throws ClassNotFoundException 
   {
       try
       {
           String query = "DELETE FROM eventos WHERE id = " + id;
           PreparedStatement consulta;
           consulta = cnx.prepareStatement(query);
           consulta.executeUpdate(); 
           JOptionPane.showMessageDialog(null,"Registro borrado correctamente");
           Ventana.ventana.actualizarPanel("PanelSeleccion", new PanelSeleccion("borrar"));
       } catch (SQLException ex)
       {
           JOptionPane.showMessageDialog(null,"Ha Ocurrido un error al intentar borrar el registro");
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
   public static Object [] selectPerfil(int id ) throws SQLException
   {
       Evento objeto = null;
       Object[] f = new Object[8];
       
           String query = "SELECT * FROM perfil WHERE id = "+ id;
           PreparedStatement consulta = cnx.prepareStatement(query);
           ResultSet resultado = consulta.executeQuery();
           
           
           while(resultado.next())
           {
               f[0] = resultado.getInt("id");
               f[1] = resultado.getString("nombre");
               f[2] = resultado.getString("apellido");
               f[3] = resultado.getString("red_social");
               f[4] = resultado.getString("numero_telefono");
               f[5] = resultado.getString("numero_celular");
               f[6] = resultado.getString("colegio");
               f[7] = resultado.getString("ruta_foto");
                  
           }
      
       return f;
       
   }

   
           
   
}