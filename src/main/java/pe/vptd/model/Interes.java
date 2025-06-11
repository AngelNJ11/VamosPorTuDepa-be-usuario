package pe.vptd.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "interes")
@Data
public class Interes {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "mensaje")
    private String mensaje;


    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @CreationTimestamp
    private LocalDateTime fecha;
}
