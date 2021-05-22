package repositories;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{
	public Usuario findByUsername(String username);
	
	public Usuario findByIdUsuario(long idUsusario);
	
	@Query("SELECT u from user u JOIN FETCH u.id_rol WHERE u.username = (:username)")
	public Usuario findByUsernameAndFetchUserRolesEagerly(@Param("username") String username);
}
