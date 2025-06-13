package pe.vptd.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import pe.vptd.model.constante.DepartamentoEstado;
import pe.vptd.model.constante.DepartamentoTipo;

@Data
@AllArgsConstructor
public class DepartamentoUsuario {
	
	private int id;
	private String titulo;
	private String descripcion;
	private String direccion;
	private String distrito;
	private int num_habitaciones;
	private int num_banos;
	private double precio;
	private DepartamentoTipo tipo;
	private DepartamentoEstado estado;
	private double latitud;
	private double longitud;
	private String imagen_principal;
	private LocalDateTime fecha_creacion;
	private LocalDateTime fecha_modificacion;
	private int creado_por;
	
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	

}
