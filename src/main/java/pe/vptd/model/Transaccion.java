package pe.vptd.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
import pe.vptd.model.constante.TransaccionesEstado;

@Entity
@Table(name = "transacciones")
@Data
public class Transaccion {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "usuario_id")
	    private Usuario usuario;

	    @ManyToOne
	    @JoinColumn(name = "departamento_id")
	    private Departamento departamento;

	    @Enumerated(EnumType.STRING)
	    private TransaccionesEstado tipo;

	    private BigDecimal monto;

	    @CreationTimestamp
	    @Column(name = "fecha")
	    private LocalDateTime fecha;


	 
}