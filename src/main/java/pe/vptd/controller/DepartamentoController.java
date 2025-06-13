package pe.vptd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
