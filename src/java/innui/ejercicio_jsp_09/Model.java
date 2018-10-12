package innui.ejercicio_jsp_09;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jasper.tagplugins.jstl.core.Catch;

public class Model {



    public Model() {
     
    }


    public void conectar(String driver, String url, String nombre, String clave,String[] error) {
        Connection connection = null;
        if (driver == null) {
            error[0] += "Driver no cargado";
        }
        if (url == null) {
            error[0] += "URL invalida";
        }
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Conexiones.desconectar(connection, error);
            error[0] += "Error en la conexion, No cargo el Driver ";
        }
        try {
            connection = DriverManager.getConnection(url, nombre, clave);
        } catch (SQLException ex) {
            error[0] += ex.getMessage();
        }
    }

  

    public boolean estaConectado(Connection connection) {
        return (connection != null);
    }

    public static void agregarEmpleado(Empleados empleado, Connection connection, String[] error) {
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("insert into empleado (nombre,apellido,identificacion,departamento,sueldo,transporte,fdn,foto) values (?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setObject(2, empleado.getApellido());
            preparedStatement.setInt(3, empleado.getIdentificacion());
            preparedStatement.setString(4, empleado.getDepartamento());
            preparedStatement.setDouble(5, empleado.getSueldo());
            preparedStatement.setDouble(6, empleado.getTransporte());
            preparedStatement.setDate(7, empleado.getFdn());
            preparedStatement.setString(8, empleado.getFoto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            error[0] += ex.getMessage();
            ex.printStackTrace();
        }
    }

    public static Empleados buscarEmpleado(Integer id, Connection connection, String[] error) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Empleados empleados = null;
        try {
            preparedStatement = connection.prepareStatement("Select id,nombre,apellido,identificacion,departamento,sueldo,transporte,fdn,foto from Empleado where id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (Empleados.load(resultSet, error));
            }
        } catch (Exception e) {
            error[0] += e.getMessage();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    error[0] += ex.getMessage();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    error[0] += ex.getMessage();
                }
            }
        }
        return null;
    }

    public static boolean eliminarEmpleado(Integer id, Connection connection, String[] error) {
        PreparedStatement preparedStatement = null;
        boolean sw = false;
        if (buscarEmpleado(id, connection, error) == null) {
            error[0] += ("Registro de Empleado identificado con: " + id + ", no encontrado");
        }
        try {
            preparedStatement = connection.prepareStatement("delete from Empleado where id=?");
            preparedStatement.setInt(1, id);
            int r = preparedStatement.executeUpdate();
            if (r != 0) {
                sw = true;
            }
        } catch (Exception e) {
            error[0] += e.getMessage();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    error[0] += ex.getMessage();
                }
            }
        }
        return sw;
    }

    public static boolean existeEmpleado(Integer id, Connection connection, String[] error) {
        return (buscarEmpleado(id, connection, error) != null);
    }

    public static ArrayList listaEmpleado(Connection connection, String[] error) {
        ArrayList lista = new ArrayList();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select id,nombre,apellido,identificacion,departamento,sueldo,transporte,fdn,foto from empleado ");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                lista.add(Empleados.load(resultSet, error));
            }
        } catch (Exception e) {
            error[0] += e.getMessage();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    error[0] += ex.getMessage();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    error[0] += e.getMessage();
                }
            }
        }
        return lista;
    }

}
