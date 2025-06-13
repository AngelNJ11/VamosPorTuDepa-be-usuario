package pe.vptd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.vptd.model.DepartamentoUsuario;
import pe.vptd.repository.IDepatamentoRepository;
import pe.vptd.service.IDepartamentoService;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService {
	
	@Autowired
	private IDepatamentoRepository departamentoRepo;

	@Override
	@Transactional
	public ResponseEntity<Map<String, Object>> lstDepartamento() {

		Map<String, Object> res = new HashMap<>();
		List<DepartamentoUsuario> du = departamentoRepo.listarDepartamentosConUsuarios()
			    .stream()
			    .map(p -> new DepartamentoUsuario(
			        p.getId(), p.getTitulo(), p.getDescripcion(), p.getDireccion(), p.getDistrito(),
			        p.getNum_habitaciones(), p.getNum_banos(), p.getPrecio(), p.getTipo(), p.getEstado(),
			        p.getLatitud(), p.getLongitud(), p.getImagen_principal(), p.getFecha_creacion(),
			        p.getFecha_modificacion(), p.getCreado_por(), p.getNombre(), p.getApellido(),
			        p.getEmail(), p.getTelefono()
			    ))
			    .collect(Collectors.toList());

			
		
		if (!du.isEmpty()) {
			res.put("mensaje","Lista de Productos");
			res.put("status",HttpStatus.OK);
			res.put("productos", du);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}else {
			res.put("mensaje","No existe registro");
			res.put("status",HttpStatus.NOT_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
	}
	
	
	

}
