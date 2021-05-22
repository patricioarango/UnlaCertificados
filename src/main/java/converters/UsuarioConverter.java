package converters;

import org.springframework.stereotype.Component;

import entities.Usuario;
import models.UsuarioModel;

@Component
public class UsuarioConverter {

	public UsuarioModel entityToModel(Usuario user) {
		return new UsuarioModel(user.getNombre(), user.getApellido(), user.getEmail(), user.getUsername(), user.getPassword(),user.getTipo_documento(), user.getNro_documento(), user.getRol());
	}

	public Usuario modeltoEntity(UsuarioModel user) {
		return new Usuario(user.getNombre(), user.getApellido(), user.getEmail(), user.getUsername(), user.getPassword(),user.getTipo_documento(), user.getNro_documento(), user.getRol());
	}
}
