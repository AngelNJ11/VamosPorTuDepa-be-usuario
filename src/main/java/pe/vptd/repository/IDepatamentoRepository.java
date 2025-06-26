package pe.vptd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import pe.vptd.model.Departamento;
import pe.vptd.model.DepartamentoUsuarioProjection;
import pe.vptd.model.DepatamentoNroVistasProjection;

@Repository
public interface IDepatamentoRepository extends JpaRepository<Departamento,Integer>{
	
	@Procedure(procedureName = "listar_departamentos_con_usuarios")
    List<DepartamentoUsuarioProjection> listarDepartamentosConUsuarios();
	
	
	@Procedure(procedureName = "listar_departamentos_con_usuarios_no_vendido")
    List<DepartamentoUsuarioProjection> listarDepartamentosConUsuariosNoVendido();
	
	@Procedure(procedureName = "listar_departamentos_mas_vistos")
    List<DepatamentoNroVistasProjection> listarDepartamentosMasVistos();

	@Procedure(procedureName = "filtrar_departamentos")
	List<DepartamentoUsuarioProjection> filtrarDepartamentos(String p_distrito, Integer p_habitaciones, Integer p_banos);

}
