package mx.gob.eventosComunitarios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento {
	@Id
	@Column(name="idEvento")
	private long idEvento;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="nombreCliente")
	private String nombreCliente;
	
	@Column(name="apellidoCliente")
	private String apellidoCliente;
	
	@Column(name="emailCliente")
	private String emailCliente;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="fechaInicio")
	private String fechaInicio;
	
	@Column(name="fechaFin")
	private String fechaFin;
	
	@Column(name="lugar")
	private String lugar;

	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(String titulo, String descripcion, String nombreCliente, String apellidoCliente,
			String emailCliente, String telefono, String fechaInicio, String fechaFin, String lugar) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.emailCliente = emailCliente;
		this.telefono = telefono;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.lugar = lugar;
	}

	public long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
}
