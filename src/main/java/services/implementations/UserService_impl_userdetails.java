package services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import repositories.IUsuarioRepository;

@Service
public class UserService_impl_userdetails implements UserDetailsService {
	@Autowired
	@Qualifier("userRepository")
	private IUsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		entities.Usuario user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return (UserDetails) buildUser(user);
	}

	private User buildUser(entities.Usuario user) {
		return new User();
	}
}