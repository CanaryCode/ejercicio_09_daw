package org;
import java.io.Serializable;
import java.lang.Comparable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Empleado implements Serializable,Comparable{

	private Integer id = 0;
	private String nombre = "";
	private String  apellido = "";
	private Integer identificacion = 0;
	private String departamento = "";
	private Double sueldo = 0.0;
	private Double transporte = 0.0;
	private Date fdn = new Date(new java.util.Date().getDate());
	private String foto="sinfoto.jpg";

	public Empleado(){
		 super();
	}

	public Empleado(Integer id, String nombre, String  apellido, Integer identificacion, String departamento, Double sueldo, Double transporte, Date fdn,String foto){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.departamento = departamento;
		this.sueldo = sueldo;
		this.transporte = transporte;
		this.fdn = fdn;
		this.foto = foto;
	}
	
	public Empleado(Integer id, String nombre, String  apellido, Integer identificacion, String departamento, Double sueldo, Double transporte, java.util.Date fdn,String foto){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.departamento = departamento;
		this.sueldo = sueldo;
		this.transporte = transporte;
		this.fdn = new Date(fdn.getTime());
		this.foto = foto;
	}

	public Empleado(Empleado e){
		this.id = e.getId();
		this.nombre = e.getNombre();
		this.apellido = e.getApellido();
		this.identificacion = e.getIdentificacion();
		this.departamento = e.getDepartamento();
		this.sueldo = e.getSueldo();
		this.transporte = e.getTransporte();
		this.fdn = e.getFdn();
		this.foto = e.getFoto();
	}

	public Integer getId(){ 
		return id;
	}
	public String getNombre(){ 
		return nombre;
	}
	public String  getApellido(){ 
		return apellido;
	}
	public Integer getIdentificacion(){ 
		return identificacion;
	}
	public String getDepartamento(){ 
		return departamento;
	}
	public Double getSueldo(){ 
		return sueldo;
	}
	public Double getTransporte(){ 
		return transporte;
	}
	public Date getFdn(){ 
		return fdn;
	}
	public String getFoto(){ 
		return foto;
	}

	public void setId(Integer id ){ 
		 this.id=id;
	}
	public void setNombre(String nombre ){ 
		 this.nombre=nombre;
	}
	public void setApellido(String  apellido ){ 
		 this.apellido=apellido;
	}
	public void setIdentificacion(Integer identificacion ){ 
		 this.identificacion=identificacion;
	}
	public void setDepartamento(String departamento ){ 
		 this.departamento=departamento;
	}
	public void setSueldo(Double sueldo ){ 
		 this.sueldo=sueldo;
	}
	public void setTransporte(Double transporte ){ 
		 this.transporte=transporte;
	}
	public void setFdn(Date fdn ){ 
		 this.fdn=fdn;
	}
	public void setFdn(java.util.Date fdn ){ 
		 this.fdn=new Date(fdn.getTime());
	}
	public void setFoto(String foto ){ 
		 this.foto=foto;
	}

	public String toString(){ 
		return(
		"DATOS:::EMPLEADO:::...\n"+
		"ID             : "+id+"\n"+
		"NOMBRE         : "+nombre+"\n"+
		"APELLIDO       : "+apellido+"\n"+
		"IDENTIFICACION : "+identificacion+"\n"+
		"DEPARTAMENTO   : "+departamento+"\n"+
		"SUELDO         : "+sueldo+"\n"+
		"TRANSPORTE     : "+transporte+"\n"+
		"FDN            : "+fdn+"\n"+
		"FOTO           : "+foto+"\n"+
		"");
	}

	public static Empleado load(ResultSet rs) throws SQLException {
		Empleado empleado = new Empleado();
		empleado.setId(rs.getInt("ID"));
		empleado.setNombre(rs.getString("NOMBRE"));
		empleado.setApellido(rs.getString("APELLIDO"));
		empleado.setIdentificacion(rs.getInt("IDENTIFICACION"));
		empleado.setDepartamento(rs.getString("DEPARTAMENTO"));
		empleado.setSueldo(rs.getDouble("SUELDO"));
		empleado.setTransporte(rs.getDouble("TRANSPORTE"));
		empleado.setFdn(rs.getDate("FDN"));
		empleado.setFoto(rs.getString("FOTO"));
		return empleado;
	}

	public int compareTo(Object empleado){
		return (this.apellido).compareTo(((Empleado)empleado).getApellido());
	}
}