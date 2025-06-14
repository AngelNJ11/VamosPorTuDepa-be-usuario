package pe.vptd.model;

import java.time.LocalDateTime;

import pe.vptd.model.constante.DepartamentoEstado;
import pe.vptd.model.constante.DepartamentoTipo;

public interface DepatamentoNroVistasProjection {
	int getId();
    String getTitulo();
    String getDescripcion();
    String getDireccion();
    String getDistrito();
    int getNum_habitaciones();
    int getNum_banos();
    double getPrecio();
    DepartamentoTipo getTipo();
    DepartamentoEstado getEstado();
    double getLatitud();
    double getLongitud();
    String getImagen_principal();
    LocalDateTime getFecha_creacion();
    LocalDateTime getFecha_modificacion();
    int getCreado_por();
	int getNro_visitas();

}
