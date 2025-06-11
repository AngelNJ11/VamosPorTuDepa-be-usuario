package pe.vptd.model;

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
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;

    private String contrasena;

    private String telefono;

    @Enumerated(EnumType.STRING)
    private Rol rol = Rol.CLIENTE;

    private Boolean estado = true;

    @CreationTimestamp
    @Column(name = "fecha_creado")
    private LocalDateTime fechaCreado;

    @UpdateTimestamp
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    public enum Rol {
        CLIENTE, ADMIN
    }
}
