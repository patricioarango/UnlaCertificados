package services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import converters.UsuarioConverter;
import entities.Usuario;
import models.UsuarioModel;
import repositories.IUsuarioRepository;
import services.IUsuarioService;

@Service
public class UserService implements IUsuarioService {
	@Autowired //Inyeccion de dependencia-- Patron Singleton
	private IUsuarioRepository userRepo;
	
	@Autowired
	private UsuarioConverter userConverter;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	@Override
	public List<Usuario> GetAll() {
		return userRepo.findAll();
	}

	@Override
	public UsuarioModel traerUsuario(long id) {
		UsuarioModel usuario= userConverter.entityToModel(userRepo.findByIdUsuario(id));
		return usuario;
	}
	
	@Override
	public boolean remove(long idUsuario) {
		try {
		userRepo.deleteById(idUsuario);
		return true;
		}catch( Exception he){
			return false;
		}
	}

	@Override
	public Usuario findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}