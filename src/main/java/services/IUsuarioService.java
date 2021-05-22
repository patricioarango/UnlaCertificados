package services;

import java.util.List;

import entities.Usuario;
import models.UsuarioModel;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
	
	public List<Usuario> GetAll();
	
	public UsuarioModel traerUsuario(long id);
	
	public UsuarioModel insertOrUpdate(UsuarioModel usuario) throws Exception;
	
	public boolean remove (long idUsuario);
}
