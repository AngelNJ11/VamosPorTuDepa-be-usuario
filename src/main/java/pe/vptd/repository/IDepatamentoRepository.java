package pe.vptd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import pe.vptd.model.Departamento;
import pe.vptd.model.DepartamentoUsuario;
import pe.vptd.model.DepartamentoUsuarioProjection;

@Repository
public interface IDepatamentoRepository extends JpaRepository<Departamento,Integer>{
	
	@Procedure(procedureName = "listar_departamentos_con_usuarios")
    List<DepartamentoUsuarioProjection> listarDepartamentosConUsuarios();

}
