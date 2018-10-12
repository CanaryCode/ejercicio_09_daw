package innui.ejercicio_jsp_09;

import java.io.Serializable;
import java.lang.Comparable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

public class Empleados implements Serializable, Comparable {

    public Integer id = 0;
    public String nombre = "";
    public String apellido = "";
    public Integer identificacion = 0;
    public String departamento = "";
    public Double sueldo = 0.0;
    public Double transporte = 0.0;
    public Date fdn = new Date(new java.util.Date().getDate());
    public String foto = "sinfoto.jpg";

    public Empleados() {
        super();
    }

    public static boolean cargar_empleado(ResultSet resultSet, Empleados empleado, String[] error) {
        boolean ret=true;
        try {
            int id = resultSet.getInt("id");
            empleado.setId(id);
            
            int identificacion = resultSet.getInt("identificacion");
            empleado.setIdentificacion(identificacion);
            
              String nombre=resultSet.getString("nombre");
              empleado.setNombre(nombre);
            
              String apellido=resultSet.getString("apellido");
              empleado.setApellido(apellido);
            
              String departamento=resultSet.getString("departamento");
              empleado.setDepartamento(departamento);
            
              String foto=resultSet.getString("foto");
              empleado.setFoto(foto);
            
             double sueldo=resultSet.getDouble("sueldo");
              empleado.setSueldo(sueldo);
            
             double transpoorte=resultSet.getDouble("transporte");
              empleado.setTransporte(transpoorte);
              
              Date fdn = resultSet.getDate("fdn");
              empleado.setFdn(fdn);

        } catch (Exception e) {
            error[0]+=e.getMessage();
            return false;
        }
        return ret;
    }

    public static ArrayList listarEmpleados(String[] error, Connection connection)  {
        ArrayList<Empleados> lista = new ArrayList();
        boolean ret = true;
        Empleados empleado = null;
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("select id,nombre,apellido,identificacion,departamento,sueldo,transporte,fdn,foto from empleado ");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                empleado = new Empleados();
                ret = cargar_empleado(resultSet, empleado, error);
                if(ret){
                    lista.add(empleado);
                }
            }
        } catch (Exception e) {
            error[0] = e.getMessage();

        } finally {
          
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                   error[0]+=ex.getMessage();
                }
      
            if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                       error[0]+=ex.getMessage();
                    }
            }
        }
        return lista;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public Double getTransporte() {
        return transporte;
    }

    public Date getFdn() {
        return fdn;
    }

    public String getFoto() {
        return foto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public void setTransporte(Double transporte) {
        this.transporte = transporte;
    }

    public void setFdn(Date fdn) {
        this.fdn = fdn;
    }

    public void setFdn(java.util.Date fdn) {
        this.fdn = new Date(fdn.getTime());
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String toString() {
        return ("DATOS:::EMPLEADO:::...\n"
                + "ID             : " + id + "\n"
                + "NOMBRE         : " + nombre + "\n"
                + "APELLIDO       : " + apellido + "\n"
                + "IDENTIFICACION : " + identificacion + "\n"
                + "DEPARTAMENTO   : " + departamento + "\n"
                + "SUELDO         : " + sueldo + "\n"
                + "TRANSPORTE     : " + transporte + "\n"
                + "FDN            : " + fdn + "\n"
                + "FOTO           : " + foto + "\n"
                + "");
    }

    public static Empleados load(ResultSet resultSet,String[] error) {
        Empleados empleado = new Empleados();
        try{
        
        empleado.setId(resultSet.getInt("ID"));
        empleado.setNombre(resultSet.getString("NOMBRE"));
        empleado.setApellido(resultSet.getString("APELLIDO"));
        empleado.setIdentificacion(resultSet.getInt("IDENTIFICACION"));
        empleado.setDepartamento(resultSet.getString("DEPARTAMENTO"));
        empleado.setSueldo(resultSet.getDouble("SUELDO"));
        empleado.setTransporte(resultSet.getDouble("TRANSPORTE"));
        empleado.setFdn(resultSet.getDate("FDN"));
        empleado.setFoto(resultSet.getString("FOTO"));}
        catch(Exception e){
            error[0]+=e.getMessage();
        }
        return empleado;
    }

    public int compareTo(Object empleado) {
        return (this.apellido).compareTo(((Empleados) empleado).getApellido());
    }
}
