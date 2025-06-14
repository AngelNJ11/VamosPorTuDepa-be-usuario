package pe.vptd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.vptd.model.Departamento;
import pe.vptd.service.IDepartamentoService;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {
	
	@Autowired
	private IDepartamentoService departamentoServices;
	
	@GetMapping()
	public ResponseEntity<Map<String, Object>> lstDepartamento (){
		return departamentoServices.lstDepartamento();
	}
	
	@GetMapping("/disponible")
	public ResponseEntity<Map<String, Object>> lstDepartamentoDisponible(){
		return departamentoServices.lstDepartamentoDisponible();
	}
	
	@GetMapping("/visto")
	public ResponseEntity<Map<String, Object>> lstDepartamentoVisto(){
		return departamentoServices.lstDepartamentoVisto();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> findDepartamentroById(@PathVariable int  id){
		return departamentoServices.findDepartamentoById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Map<String, Object>> insertarDepartamento(@RequestBody Departamento depa){
		return departamentoServices.insertarDepartamento(depa);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Map<String, Object>> actualizarDepartamento(@RequestBody Departamento depa, @PathVariable int id){
		return departamentoServices.actualizarDepartamento(depa, id);
	}
	
	@PutMapping("/estado/{id}")
	public ResponseEntity<Map<String, Object>> actualizarDepartamentoEstado(@PathVariable int id ){
		return departamentoServices.actualizarDepartamentoEstado(id);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Map<String, Object>> eliminarDepartamento( @PathVariable int id){
		return departamentoServices.eliminarDepartamento(id);
	}
	

}
