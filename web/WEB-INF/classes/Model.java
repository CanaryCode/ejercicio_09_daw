package org;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Model{
	
	private transient Connection co;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/ejercicios";
	private String nombre = "root";
	private String clave = "";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Model(){
		try {
			conectar();
		} catch (Exception ex){}
	}

	public void setDriver(String a) {
		driver = a;
	}

	public void setUrl(String a) {
		url = a;
	}

	public void setNombre(String a) {
		nombre = a;
	}
	public void setClave(String a) {
		clave = a;
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getNombre(){
		return nombre;
	}

	public String getClave(){
		return clave;
	}

	public void conectar() throws SQLException {
		if (driver == null) {
			throw new SQLException("Driver no cargado");
		}
		if (url == null) {
			throw new SQLException("URL invalida");
		}
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException ex){
			desconectar();
			throw new SQLException("Error en la conexion, No cargo el Driver ");
		}
		co = DriverManager.getConnection(url,nombre,clave);
	}

	public void desconectar() {
		try {
			if (co != null) {
				co.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception ignorar) {}
	}
	
	public boolean estaConectado() {
			return (co != null);
	}

	public void agregarEmpleado(Empleado empleado) throws SQLException {
		pstmt = co.prepareStatement("insert into Empleado (nombre,apellido,identificacion,departamento,sueldo,transporte,fdn,foto) values (?,?,?,?,?,?,?,?)");
		pstmt.setString(1,empleado.getNombre());
		pstmt.setObject(2,empleado.getApellido());
		pstmt.setInt(3,empleado.getIdentificacion());
		pstmt.setString(4,empleado.getDepartamento());
		pstmt.setDouble(5,empleado.getSueldo());
		pstmt.setDouble(6,empleado.getTransporte());
		pstmt.setDate(7,empleado.getFdn());
		pstmt.setString(8,empleado.getFoto() );
		pstmt.executeUpdate();
	}

	public Empleado buscarEmpleado(Integer id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = co.prepareStatement("Select id,nombre,apellido,identificacion,departamento,sueldo,transporte,fdn,foto from Empleado where id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				return(Empleado.load(rs));
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null){
				pstmt.close();
			}
		}
		return null;
	}

	public boolean eliminarEmpleado( Integer id)throws SQLException{
		PreparedStatement pstmt = null;
		boolean sw=false;
		if (this.buscarEmpleado(id)==null)
			throw new SQLException("Registro de Empleado identificado con: "+id+", no encontrado");
		try{
			pstmt= co.prepareStatement("delete from Empleado where id=?");
			pstmt.setInt(1,id);
			int r=pstmt.executeUpdate();
			if ( r!=0)
				sw=true;
		}finally{
			if(pstmt!= null)
				pstmt.close();
		}
		return sw;
	}

	public boolean existeEmpleado(Integer id)throws SQLException{
		return (buscarEmpleado(id)!=null);
	}

	public ArrayList listaEmpleado() throws SQLException {
		ArrayList lista = new ArrayList();
		try {
			pstmt = co.prepareStatement("select id,nombre,apellido,identificacion,departamento,sueldo,transporte,fdn,foto from Empleado ");
			rs=pstmt.executeQuery();
			while(rs.next()){
				lista.add(Empleado.load(rs));
			}
		}finally{
			if (rs != null){
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return lista;
	}


}