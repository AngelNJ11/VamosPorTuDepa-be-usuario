package pe.vptd.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface IDepartamentoService {
	
	public ResponseEntity<Map<String, Object>> lstDepartamento ();

}
