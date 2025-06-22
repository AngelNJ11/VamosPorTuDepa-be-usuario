package pe.vptd.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import pe.vptd.model.Departamento;

public interface IDepartamentoService {
	
	public ResponseEntity<Map<String, Object>> lstDepartamento ();
	public ResponseEntity<Map<String, Object>> lstDepartamentoDisponible();
	public ResponseEntity<Map<String, Object>> lstDepartamentoVisto();
	public ResponseEntity<Map<String, Object>> findDepartamentoById(int id);
	public ResponseEntity<Map<String, Object>> insertarDepartamento(Departamento depa);
	public ResponseEntity<Map<String, Object>> actualizarDepartamento(Departamento depa , int id);
	public ResponseEntity<Map<String, Object>> actualizarDepartamentoEstado(int id );
	public ResponseEntity<Map<String, Object>> eliminarDepartamento (int id);
	public ResponseEntity<Map<String, Object>> filtrarDepartamentos(String distrito, Integer habitaciones, Integer banos);

	

}
