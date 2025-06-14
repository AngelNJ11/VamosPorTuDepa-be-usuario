package pe.vptd.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import pe.vptd.model.constante.DepartamentoEstado;
import pe.vptd.model.constante.DepartamentoTipo;

@Data
@AllArgsConstructor
public class DepatamentoNroVistas {
	private Integer id;
	private String titulo;
	private String descripcion;
	private String direccion;
	private String distrito;
	private Integer num_habitaciones;
	private Integer num_banos;
	private Double precio;
	private DepartamentoTipo tipo;
	private DepartamentoEstado estado;
	private Double latitud;
	private Double longitud;
	private String imagen_principal;
	private LocalDateTime fecha_creacion;
	private LocalDateTime fecha_modificacion;
	private Integer creado_por;
	private Integer nro_visitas;

}
