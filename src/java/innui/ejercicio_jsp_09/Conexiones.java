package innui.ejercicio_jsp_09;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daw
 */
public class Conexiones implements Serializable {

    public static boolean controlador(HttpSession session, String[] error) {
        boolean ret = true;
        Map<String, String> mapa = new HashMap<>();
        Connection connection = null;
        ret = leerConexion(error, mapa);
        if (ret) {
            connection = conectar(mapa.get("driver"),
                    mapa.get("url"),
                    mapa.get("nombre"),
                    mapa.get("clave"),
                    error);
        } else {
            ret = false;
        }
        if (ret) {
            session.setAttribute("conexion", connection);
            session.setAttribute("error", error);

        }
        return ret;
    }

    /**
     *
     * @param driver Cadena de texto indentificativa al driver.
     * @param url cadena de conexion
     * @param nombre nombre del usuario de la base de datos.
     * @param clave clave usuario de la base de datos
     * @param error posicion 0 que contiene
     * @return
     */
    public static Connection conectar(String driver, String url, String nombre, String clave, String[] error) {
        Connection connection = null;
        if (driver == null) {
            error[0] = "Driver no cargado";
        }
        if (url == null) {
            error[0] += "URL invalida";
        }
        if (nombre == null) {
            error[0] += "nombre incorrecto";
        }
        if (clave == null) {
            error[0] += "clave incorrecta";
        }
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, nombre, clave);

        } catch (Exception ex) {
            desconectar(connection, error);
            String mensaje = ex.getMessage();
            if (mensaje == null) {
                mensaje = "";
            }
            error[0] += "error no cargo el driver " + mensaje;
        }
        return connection;
    }

    /**
     * Obtiene los mapas del archivo de recursos/basedatos.properties
     *
     * @param error Llena en el mapa con los datos de conexion
     * @param mapaConexion Posicion 0 continen mensajes de error, si lo hay
     * @return un objeto con la conexion o null si hay un error
     */
    public static boolean leerConexion(String[] error, Map<String, String> mapaConexion) {
        boolean ret = true;
        try {
            Class clase = Conexiones.class;
            InputStream inputStream = clase.getResourceAsStream("recursos/baseDatos.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            Set<Entry<Object, Object>> setEntry = properties.entrySet();
            for (Entry<Object, Object> entry : setEntry) {
                mapaConexion.put((String) entry.getKey(), (String) entry.getValue());
            }
        } catch (IOException ex) {

            error[0] = ex.getMessage();
            if (error[0] == null) {
                error[0] = "";
            }
            error[0] += "error no cargo el driver " + error[0];
            ret = false;
        }
        return ret;
    }

    public static void desconectar(Connection connection, String[] error) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            error[0] += e.getMessage();
        }
    }
}
