public class Evento 
{   
    private String nombre,lugar,tipo,fecha,descripcion;
    private int id;
    
    public Evento(String nombre, String lugar, String tipo, String fecha, String descripcion )
    {
        this.nombre = nombre;
        this.lugar = lugar;
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;  
    }
    public Evento(int id,String nombre, String lugar, String tipo, String fecha, String descripcion )
    {
        this.nombre = nombre;
        this.lugar = lugar;
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;  
        this.id = id;
    }
    // esto son los metoos getter
    public String getNombre()
    {
        return nombre;
    }
    public String getLugar() {return lugar;}
    public String getTipo(){return tipo;}
    public String getFecha(){return fecha;}
    public int getId() {return id;}
    public String getDescripcion(){return descripcion;}
    // --------------------------------------------------------
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setLugar(String lugar){this.lugar = lugar;}
    public void setTipo(String tipo){this.tipo = tipo;}
    public void setFecha(String fecha){this.fecha = fecha;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}
    
}
