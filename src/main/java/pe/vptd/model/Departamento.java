package pe.vptd.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "departamentos")
@Data
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private String direccion;

    private String distrito;

    private Integer numHabitaciones;

    private Integer numBanos;

    private BigDecimal precio;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.DISPONIBLE;

    private BigDecimal latitud;

    private BigDecimal longitud;

    private String imagenPrincipal;

    @Column(name = "fecha_creacion")
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    @UpdateTimestamp
    private LocalDateTime fechaModificacion;


    @ManyToOne
    @JoinColumn(name = "creado_por")
    private Usuario creadoPor;

    public enum Tipo {
        ALQUILER, VENTA
    }

    public enum Estado {
        DISPONIBLE, ALQUILADO, VENDIDO
    }
	
}
