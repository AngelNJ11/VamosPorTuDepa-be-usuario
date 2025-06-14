package pe.vptd.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.vptd.model.Departamento;
import pe.vptd.model.DepartamentoUsuario;
import pe.vptd.model.DepatamentoNroVistas;
import pe.vptd.model.constante.DepartamentoEstado;
import pe.vptd.model.constante.DepartamentoTipo;
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

	@Override
	public ResponseEntity<Map<String, Object>> insertarDepartamento(Departamento depa) {
		Map<String, Object> res = new HashMap<>();
		if(depa == null) {
			res.put("mensaje","no se ingreso Depatamento");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
		depa.setFechaCreacion(LocalDateTime.now());
		depa.setEstado(DepartamentoEstado.DISPONIBLE);
		departamentoRepo.save(depa);
		res.put("mensaje", "Departamento fue insertado");
		res.put("Departamiento", depa);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@Override
	public ResponseEntity<Map<String, Object>> actualizarDepartamento(Departamento depa, int id) {
		
		Map<String, Object> res = new HashMap<>();
		try {
			Departamento oldD = departamentoRepo.findById(id).get();
			
			oldD.setTitulo(depa.getTitulo());
			oldD.setDescripcion(depa.getDescripcion());
			oldD.setDireccion(depa.getDireccion());
			oldD.setDistrito(depa.getDistrito());
			oldD.setNumHabitaciones(depa.getNumHabitaciones());
			oldD.setNumBanos(depa.getNumBanos());
			oldD.setPrecio(depa.getPrecio());
			oldD.setTipo(depa.getTipo());
			oldD.setEstado(depa.getEstado());
			oldD.setLatitud(depa.getLatitud());
			oldD.setLongitud(depa.getLongitud());
			oldD.setImagenPrincipal(depa.getImagenPrincipal());
			oldD.setFechaModificacion(LocalDateTime.now());
			departamentoRepo.save(oldD);

			res.put("mensaje", "Departamento fue actualizado");
			res.put("Departamiento", oldD);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		
		} catch (Exception e) {
			res.put("mensaje",e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> eliminarDepartamento(int id) {
		Map<String, Object> res = new HashMap<>();

		try {
			departamentoRepo.deleteById(id);
			res.put("mensaje","Departamento fue eliminado");
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			res.put("Mensaje",e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
	}

	@Override
	@Transactional
	public ResponseEntity<Map<String, Object>> lstDepartamentoDisponible() {
		Map<String, Object> res = new HashMap<>();
		List<DepartamentoUsuario> du = departamentoRepo.listarDepartamentosConUsuariosNoVendido()
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
			res.put("mensaje","no hay departamento registrado");
			res.put("status",HttpStatus.NOT_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
	}

	@Override
	@Transactional
	public ResponseEntity<Map<String, Object>> lstDepartamentoVisto() {
		Map<String, Object> res = new HashMap<>();
		List<DepatamentoNroVistas> du = departamentoRepo.listarDepartamentosMasVistos()
			    .stream()
			    .map(p -> new DepatamentoNroVistas(
			        p.getId(), p.getTitulo(), p.getDescripcion(), p.getDireccion(), p.getDistrito(),
			        p.getNum_habitaciones(), p.getNum_banos(), p.getPrecio(), p.getTipo(), p.getEstado(),
			        p.getLatitud(), p.getLongitud(), p.getImagen_principal(), p.getFecha_creacion(),
			        p.getFecha_modificacion(), p.getCreado_por(), p.getNro_visitas()
			    ))
			    .collect(Collectors.toList());
		
		if (!du.isEmpty()) {
			res.put("mensaje","Lista de Top 10 Departamentos mas vistos");
			res.put("status",HttpStatus.OK);
			res.put("productos", du);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}else {
			res.put("mensaje","no hay departamento registrado");
			res.put("status",HttpStatus.NOT_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> findDepartamentoById(int id) {
		Map<String, Object> res = new HashMap<>();
		try {
			Departamento d = departamentoRepo.findById(id).get();
			res.put("mensje", d);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			res.put("mensaje",e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> actualizarDepartamentoEstado(int id) {
		Map<String, Object> res = new HashMap<>();
		try {
			Departamento d = departamentoRepo.findById(id).get();
			if(d.getTipo().equals(DepartamentoTipo.ALQUILER)) {
				d.setEstado(DepartamentoEstado.ALQUILADO);
			}if(d.getTipo().equals(DepartamentoTipo.VENTA)) {
				d.setEstado(DepartamentoEstado.VENDIDO);
			}
			departamentoRepo.save(d);
			res.put("mensje", d);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			res.put("mensaje",e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
	}


	
	
	

}
